package com.ptit.Hirex.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work")
public class Work {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    private LocalTime startTime;

    private LocalTime endTime;

    private LocalDate startDate;

    private LocalDate endDate;

    private String jobPosition;
    
	private String typeWork;
    
    private String typeJob;

    private Long wage;

    @ManyToMany
    @JoinTable(
            name = "work_required_ability",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> requiredAbilities;

    @ManyToMany
    @JoinTable(
            name = "work_optional_ability",
            joinColumns = @JoinColumn(name = "work_id"),
            inverseJoinColumns = @JoinColumn(name = "ability_id")
    )
    private List<Ability> optionalAbilities;

    @ManyToOne
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    @ManyToMany
    @JoinTable(
        name = "work_employee", 
        joinColumns = @JoinColumn(name = "work_id"), 
        inverseJoinColumns = @JoinColumn(name = "employee_id")
    )
    private List<Employee> employees;

    @OneToMany(mappedBy = "work", cascade = CascadeType.ALL)
    private List<ResumeWork> resumeWorks;

    @CreatedDate
    private Instant createOn;
}
