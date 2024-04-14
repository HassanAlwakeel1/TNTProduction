package com.tntproduction.controller;

import com.tntproduction.model.dto.WorkDTO;
import com.tntproduction.model.entity.Work;
import com.tntproduction.model.entity.enums.Department;
import com.tntproduction.service.WorkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/work")
@RequiredArgsConstructor
public class WorkController {

    private final WorkService workService;

    @PostMapping("/add-update")
    public ResponseEntity<String> createUpdateWork(@ModelAttribute WorkDTO workDTO){
        return workService.addOrUpdateWork(workDTO);
    }

    @DeleteMapping("/delete-work/{workId}")
    public ResponseEntity<String> deleteWork(@PathVariable Long workId){
        return workService.deleteWork(workId);
    }

    @GetMapping("find-all-works")
    public List<Work> getAllWorks(){
        return workService.getAllWorks();
    }

    @GetMapping("find-by-department/{department}")
    public List<Work> getWorksByDepartment(@PathVariable Department department){
        return workService.getWorksByDepartment(department);
    }

}
