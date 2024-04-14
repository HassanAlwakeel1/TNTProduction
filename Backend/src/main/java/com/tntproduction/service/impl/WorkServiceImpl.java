package com.tntproduction.service.impl;

import com.tntproduction.model.dto.WorkDTO;
import com.tntproduction.model.entity.Work;
import com.tntproduction.model.entity.enums.Department;
import com.tntproduction.repository.WorkRepository;
import com.tntproduction.service.WorkService;
import com.tntproduction.utility.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorkServiceImpl implements WorkService {

    private final WorkRepository workRepository;

    @Override
    public ResponseEntity<String> addOrUpdateWork(WorkDTO workDTO) {
        if (workDTO.getId() != null){
            Optional<Work> optionalWork = workRepository.findById(workDTO.getId());

            //This for the case that workDTO have id but the id don't exist in the DB
            if (optionalWork.isPresent()){
                Work existingWork  = optionalWork.get();
                updateWorkFromDTO(existingWork,workDTO);
                workRepository.save(existingWork);
                return ResponseEntity.ok("Work updated successfully");
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Work not found with ID : " + workDTO.getId());
            }
        }else {
            saveNewWorkFromDTO(workDTO);
            return ResponseEntity.ok("Work added successfully");
        }
    }

    @Override
    public ResponseEntity<String> deleteWork(Long workId) {
        Optional<Work> optionalWork = workRepository.findById(workId);
        if (optionalWork.isPresent()){
             workRepository.deleteById(workId);
             return ResponseEntity.ok("Work deleted successfully");
        }else return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Don't found Work with ID : " + workId);
    }

    @Override
    public List<Work> getAllWorks() {
        return  workRepository.findAll();
    }

    @Override
    public List<Work> getWorksByDepartment(Department department) {
        return workRepository.findAll().stream()
                .filter(work -> work.getDepartment().contains(department))
                .collect(Collectors.toList());
    }

    private Work saveNewWorkFromDTO(WorkDTO workDTO){
       Work work = new Work();
       updateWorkFromDTO(work,workDTO);
       return workRepository.save(work);
    }

    private void updateWorkFromDTO(Work work, WorkDTO workDTO){
        work.setWorkName(workDTO.getWorkName());
        work.setDescription(workDTO.getDescription());
        work.setLogoURL(Utils.storeFileAndGetUrl(workDTO.getWorkLogo()));
        work.setDepartment(workDTO.getDepartments());
        work.setWorkFilesUrls(storeMultipleFilesAndGetURLs(workDTO.getWorkFiles()));
    }

    private List<String> storeMultipleFilesAndGetURLs(List<MultipartFile> files){
        List<String> filesURLs = new ArrayList<>();
        for(int counter=0;counter<files.size();counter++){
            filesURLs.add(Utils.storeFileAndGetUrl(files.get(counter)));
        }
        return filesURLs;
    }
}
