package com.trabalho.departamento.repository;

import com.trabalho.departamento.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
}
