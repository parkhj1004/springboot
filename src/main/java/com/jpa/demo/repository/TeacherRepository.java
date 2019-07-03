package com.jpa.demo.repository;

import com.jpa.demo.entity.solution.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
