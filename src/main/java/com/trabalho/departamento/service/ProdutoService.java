package com.trabalho.departamento.service;

import com.trabalho.departamento.model.Produto;
import com.trabalho.departamento.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository repo;
    public ProdutoService(ProdutoRepository repo) { this.repo = repo; }

    public List<Produto> listar() { return repo.findAll(); }
    public Optional<Produto> porId(Long id) { return repo.findById(id); }
    public Produto salvar(Produto p) { return repo.save(p); }
    public void deletar(Long id) { repo.deleteById(id); }
    public List<Produto> listarPorDepartamento(Long departamentoId) { return repo.findByDepartamentoId(departamentoId); }
}
