package com.tntproduction.model.entity;

import com.tntproduction.model.entity.enums.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "work")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "work_name",nullable = false)
    private String workName;

    @Column(name = "logo_url" , nullable = false)
    private String logoURL;


    @ElementCollection
    @CollectionTable(name="work_files_urls", joinColumns = @JoinColumn(name="work_id"))
    @Column(name = "file_url")
    private List<String> workFilesUrls;

    @Column(name = "description", length = 10000, nullable = false)
    private String Description;

    @ElementCollection
    @CollectionTable(name="work_department", joinColumns = @JoinColumn(name="work_id"))
    @Column(name = "department", nullable = false)
    @Enumerated(EnumType.STRING)
    private List<Department> department;
}
