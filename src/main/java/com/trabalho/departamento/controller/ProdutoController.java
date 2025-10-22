package com.trabalho.departamento.controller;

import com.trabalho.departamento.model.Produto;
import com.trabalho.departamento.service.DepartamentoService;
import com.trabalho.departamento.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;
    private final DepartamentoService departamentoService;

    public ProdutoController(ProdutoService produtoService, DepartamentoService departamentoService) {
        this.produtoService = produtoService;
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("produtos", produtoService.listar());
        model.addAttribute("departamentos", departamentoService.listar());
        return "produtos";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("produto", new Produto());
        model.addAttribute("departamentos", departamentoService.listar());
        return "editar-produto";
    }

    @PostMapping("/salvar")
    public String salvar(Produto produto, BindingResult br) {
        if (br.hasErrors()) return "editar-produto";
        produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        var p = produtoService.porId(id).orElseThrow();
        model.addAttribute("produto", p);
        model.addAttribute("departamentos", departamentoService.listar());
        return "editar-produto";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        produtoService.deletar(id);
        return "redirect:/produtos";
    }
}
