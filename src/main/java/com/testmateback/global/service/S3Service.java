package com.testmateback.global.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.util.IOUtils;
import com.testmateback.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class S3Service {

    @Autowired
    private final AmazonS3 amazonS3Client;
    private final UserRepository userRepository;


    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName;


    public void deleteImage(String imageUrl) {
        String fileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
        amazonS3Client.deleteObject(bucketName, fileName);
    }

    public String uploadImageToS3(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename(); // 원본 파일명
        String extension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1); // 확장자명

        String s3FileName = UUID.randomUUID().toString().substring(0, 10) + "." + extension; // 변경된 파일명

        InputStream is = image.getInputStream();
        byte[] bytes = IOUtils.toByteArray(is); // 이미지를 byte[]로 변환

        ObjectMetadata metadata = new ObjectMetadata(); // metadata 생성
        metadata.setContentType("image/" + extension);
        metadata.setContentLength(bytes.length);

        // S3에 요청할 때 사용할 byteInputStream 생성
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

        try {
            // S3로 putObject 할 때 사용할 요청 객체 생성
            // 생성자 : bucket 이름, 파일명, byteInputStream, metadata
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, s3FileName, byteArrayInputStream, metadata)
                    .withCannedAcl(CannedAccessControlList.PublicRead);

            // 실제로 S3에 이미지 데이터를 넣는 부분
            amazonS3Client.putObject(putObjectRequest); // put image to S3
        } catch (Exception e) {
            log.error("Error uploading image to S3", e);
            throw new RuntimeException("Error uploading image to S3", e);
        } finally {
            byteArrayInputStream.close();
            is.close();
        }

        // 이미지가 성공적으로 업로드되면 해당 이미지의 URL을 반환
        return "https://" + bucketName + ".s3.amazonaws.com/" + s3FileName;
    }


}
