package com.dudicorp.demo.repository;

import com.dudicorp.demo.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITema extends JpaRepository<Tema,Long> {
}
