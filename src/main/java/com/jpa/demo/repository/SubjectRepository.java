package com.jpa.demo.repository;

import com.jpa.demo.entity.solution.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
