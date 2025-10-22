package com.trabalho.departamento.controller;

import com.trabalho.departamento.model.Departamento;
import com.trabalho.departamento.service.DepartamentoService;
import com.trabalho.departamento.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/departamentos")
public class DepartamentoController {
    private final DepartamentoService service;
    private final ProdutoService produtoService;

    public DepartamentoController(DepartamentoService service, ProdutoService produtoService) {
        this.service = service;
        this.produtoService = produtoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("departamentos", service.listar());
        return "departamentos";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "editar-departamento";
    }

    @PostMapping("/salvar")
    public String salvar(Departamento departamento, BindingResult br) {
        if (br.hasErrors()) return "editar-departamento";
        service.salvar(departamento);
        return "redirect:/departamentos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        var d = service.porId(id).orElseThrow();
        model.addAttribute("departamento", d);
        model.addAttribute("produtos", produtoService.listarPorDepartamento(id));
        return "editar-departamento";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        service.deletar(id);
        return "redirect:/departamentos";
    }
}
