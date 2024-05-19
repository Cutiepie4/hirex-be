package com.ptit.Hirex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ptit.Hirex.entity.Resume;
import java.util.List;


@Repository
public interface ResumeRepository extends JpaRepository <Resume, Long>{
    List<Resume> findAllByEmployeeId(Long id);

}
