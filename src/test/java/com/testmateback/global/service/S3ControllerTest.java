package com.testmateback.global.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Nested
class S3ControllerTest {

    @Mock
    private S3Service s3Service;

    @InjectMocks
    private S3Controller s3Controller;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(s3Controller).build();
    }

    @Test
    void uploadFile_shouldReturnSuccessMessage() throws Exception {
        // Arrange
        String fileName = "test-image.png";
        MockMultipartFile mockFile = new MockMultipartFile("file", fileName, "image/png", "test-image-content".getBytes());
        when(s3Service.uploadImageToS3(mockFile)).thenReturn("https://test-bucket.s3.amazonaws.com/test-image.png");

        // Act & Assert
        mockMvc.perform(multipart("/api/s3/upload")
                        .file(mockFile)
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(content().string("File uploaded successfully: https://test-bucket.s3.amazonaws.com/test-image.png"));
    }
}