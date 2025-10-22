package com.trabalho.departamento.service;

import com.trabalho.departamento.model.Departamento;
import com.trabalho.departamento.repository.DepartamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {
    private final DepartamentoRepository repo;
    public DepartamentoService(DepartamentoRepository repo) { this.repo = repo; }

    public List<Departamento> listar() { return repo.findAll(); }
    public Optional<Departamento> porId(Long id) { return repo.findById(id); }
    public Departamento salvar(Departamento d) { return repo.save(d); }
    public void deletar(Long id) { repo.deleteById(id); }
}
