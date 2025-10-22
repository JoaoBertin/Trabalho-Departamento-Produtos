package com.trabalho.departamento.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nome;

    private BigDecimal preco;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;

    public Produto() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
    public Departamento getDepartamento() { return departamento; }
    public void setDepartamento(Departamento departamento) { this.departamento = departamento; }
}
