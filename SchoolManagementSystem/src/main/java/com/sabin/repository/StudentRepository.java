package com.sabin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sabin.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
