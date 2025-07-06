package com.lucasbenfatti.biblioteca_pessoal.repository;

import com.lucasbenfatti.biblioteca_pessoal.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByEditora(String editora);
    List<Livro> findByAutor(String autor);



}
