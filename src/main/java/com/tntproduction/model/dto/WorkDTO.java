package com.tntproduction.model.dto;

import com.tntproduction.model.entity.enums.Department;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class WorkDTO {

    private Long id;

    private String workName;

    private MultipartFile workLogo;

    private List<MultipartFile> workFiles;

    private String description;

    private List<Department> departments;
}
