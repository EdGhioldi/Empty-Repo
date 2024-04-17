package com.dudicorp.demo.repository;

import com.dudicorp.demo.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurso extends JpaRepository<Curso, Long> {
}
