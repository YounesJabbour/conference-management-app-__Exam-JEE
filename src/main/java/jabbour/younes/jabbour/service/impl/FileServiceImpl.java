package jabbour.younes.jabbour.service.impl;

import jabbour.younes.jabbour.service.interfaces.FileService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class FileServiceImpl implements FileService {

    @Value("${files.path}")
    private String filesPath;

    @Override
    public String uploadFile(MultipartFile file) {
               String fileType = null;
            Path folderPath = Paths.get(System.getProperty("user.home"), filesPath);
            if (!Files.exists(folderPath)) {
                try {
                    Files.createDirectories(folderPath);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            String fileName = UUID.randomUUID().toString() + file.getOriginalFilename();
            Path filePath = Paths.get(System.getProperty("user.home"), filesPath, fileName);

            try {
                fileType = Files.probeContentType(filePath);
                Files.copy(file.getInputStream(), filePath);

            } catch (IOException e) {
                e.printStackTrace();
            }
            return filePath.toFile().getPath();
        }
}
