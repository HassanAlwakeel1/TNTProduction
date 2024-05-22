package com.tntproduction.utility;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utils {

    //TODO : This will be replaced with the directory of the server that we will store the files on
    private static final String UPLOAD_DIR = "D:\\tnt_media";

    public static String storeFileAndGetUrl(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String fileUrl = "";

        try {
            if (fileName.contains("..")) {
                throw new RuntimeException("Invalid file name!");
            }

            File uploadDir = new File(UPLOAD_DIR);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            File mediaFile = new File(uploadDir, fileName);
            try (FileOutputStream outputStream = new FileOutputStream(mediaFile)) {
                outputStream.write(file.getBytes());
            }
            fileUrl = generateFileUrl(mediaFile.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileUrl;
    }

    private static String generateFileUrl(String fileName) {
        return fileName;
    }
}
