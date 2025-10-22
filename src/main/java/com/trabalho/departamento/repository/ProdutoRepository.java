package com.trabalho.departamento.repository;

import com.trabalho.departamento.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByDepartamentoId(Long departamentoId);
}
