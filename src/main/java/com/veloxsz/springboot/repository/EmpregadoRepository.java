package com.veloxsz.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.veloxsz.springboot.model.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {

}
