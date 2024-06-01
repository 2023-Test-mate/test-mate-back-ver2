package com.testmateback.global.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class S3ServiceTest {

    @Mock
    private AmazonS3Client amazonS3Client;

    @InjectMocks
    private S3Service s3Service;

    @BeforeEach
    void setUp() {
        // Mockito 어노테이션을 초기화합니다.
        MockitoAnnotations.openMocks(this);
        // bucketName 필드를 "test-bucket" 값으로 설정합니다.
        ReflectionTestUtils.setField(s3Service, "bucketName", "test-bucket");
    }

    @Test
    void uploadImageToS3_shouldUploadFileAndReturnUrl() throws IOException {
        // Arrange
        String fileName = "test-image.png";
        // MockMultipartFile을 생성하기 -> 이 파일은 실제 파일 x
        MockMultipartFile mockFile = new MockMultipartFile("file", fileName, "image/png", "test-image-content".getBytes());

        // S3 클라이언트의 getUrl 메서드가 호출될 때 반환할 URL을 설정
        when(amazonS3Client.getUrl(anyString(), anyString())).thenReturn(new URL("https://test-bucket.s3.amazonaws.com/test-image.png"));

        // Act
        // S3Service의 uploadImageToS3 메서드를 호출
        String result = s3Service.uploadImageToS3(mockFile);

        // Assert
        // S3 클라이언트의 putObject 메서드가 한 번 호출되었는지 검증하기
        verify(amazonS3Client, times(1)).putObject(any(PutObjectRequest.class));
        // 메서드의 반환 값이 예상한 URL과 일치하는지 검증하기
        assertEquals("https://test-bucket.s3.amazonaws.com/test-image.png", result);
    }
}