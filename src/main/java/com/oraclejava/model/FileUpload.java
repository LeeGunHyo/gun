package com.oraclejava.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class FileUpload {
    private MultipartFile[] files;
}
