package com.lucasbenfatti.biblioteca_pessoal.controller;

import com.lucasbenfatti.biblioteca_pessoal.model.Livro;
import com.lucasbenfatti.biblioteca_pessoal.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroWebController {

    @Autowired
    private LivroService livroService;

    /*@GetMapping
    public String listarTodos(Model model) {
        model.addAttribute("livros", livroService.listarTodosLivros());
        model.addAttribute("livro", new Livro());
        return "livros";
    }*/

    @PostMapping
    public String adicionar(@Valid @ModelAttribute("livro") Livro livro, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("livros", livroService.listarTodosLivros());
            return "livros";
        }
        livroService.cadastrarLivro(livro);
        return "redirect:/livros";
    }

    @PostMapping("/buscar-autor")
    public String buscarPorAutor(@RequestParam String autor, Model model) {
        model.addAttribute("livros", livroService.findByAutor(autor));
        model.addAttribute("livro", new Livro());
        return "livros";
    }

    @PostMapping("/buscar-editora")
    public String buscarPorEditora(@RequestParam String editora, Model model) {
        model.addAttribute("livros", livroService.findByEditora(editora));
        model.addAttribute("livro", new Livro());
        return "livros";
    }

    @PostMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        livroService.excluirLivro(id);
        return "redirect:/livros";
    }

    @GetMapping
    public String listarPaginado(@RequestParam(defaultValue = "0") int pagina,
                                 Model model) {
        Page<Livro> paginaLivros = livroService.listarPaginado(pagina, 5); // 5 livros por página
        model.addAttribute("livros", paginaLivros.getContent());
        model.addAttribute("paginaAtual", paginaLivros.getNumber());
        model.addAttribute("totalPaginas", paginaLivros.getTotalPages());
        model.addAttribute("livro", new Livro());
        return "livros";
    }

}
