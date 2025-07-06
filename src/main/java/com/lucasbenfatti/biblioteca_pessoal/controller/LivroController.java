package com.lucasbenfatti.biblioteca_pessoal.controller;

import com.lucasbenfatti.biblioteca_pessoal.model.Livro;
import com.lucasbenfatti.biblioteca_pessoal.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca-pessoal/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> listarTodosLivros() {
        List<Livro> livros = livroService.listarTodosLivros();
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/editora")
    public ResponseEntity<List<Livro>> findByEditora(@RequestParam String nomeEditora) {
        List<Livro> livros = livroService.findByEditora(nomeEditora);
        return ResponseEntity.ok(livros);
    }

    @GetMapping("/autor")
    public ResponseEntity<List<Livro>> findByAutor(@RequestParam String nomeAutor) {
        List<Livro> livros = livroService.findByAutor(nomeAutor);
        return ResponseEntity.ok(livros);
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid Livro livro) {
        Livro novoLivro = livroService.cadastrarLivro(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable Long id) {
        livroService.excluirLivro(id);
        return ResponseEntity.noContent().build();
    }
}
