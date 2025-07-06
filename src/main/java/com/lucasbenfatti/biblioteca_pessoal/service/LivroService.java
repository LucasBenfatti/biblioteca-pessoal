package com.lucasbenfatti.biblioteca_pessoal.service;

import com.lucasbenfatti.biblioteca_pessoal.model.Livro;
import com.lucasbenfatti.biblioteca_pessoal.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarTodosLivros() {
        return livroRepository.findAll();
    }

    public List<Livro> findByEditora(String editora) {
        return livroRepository.findByEditora(editora);
    }

    public List<Livro> findByAutor(String autor) {
        return livroRepository.findByAutor(autor);
    }

    public Livro cadastrarLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public void excluirLivro(Long id) {
        if (!livroRepository.existsById(id)) {
            throw new EntityNotFoundException("Livro não encontrado.");
        }
        livroRepository.deleteById(id);
        System.out.println("Livro " + id + " excluído com sucesso!");
    }



    public Page<Livro> listarPaginado(int pagina, int tamanho) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        return livroRepository.findAll(pageable);
    }


}
