package com.tntproduction.service;

import com.tntproduction.model.dto.WorkDTO;
import com.tntproduction.model.entity.Work;
import com.tntproduction.model.entity.enums.Department;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkService {
    ResponseEntity<String> addOrUpdateWork(WorkDTO workDTO);

    ResponseEntity<String> deleteWork(Long id);

    List<Work> getAllWorks();

    List<Work> getWorksByDepartment(Department department);
}
