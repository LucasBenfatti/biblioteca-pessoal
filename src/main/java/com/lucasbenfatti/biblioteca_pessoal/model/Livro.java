package com.lucasbenfatti.biblioteca_pessoal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O título é obrigatório")
    private String titulo;
    @NotBlank(message = "O autor é obrigatório")
    private String autor;
    @NotBlank(message = "A editora é obrigatório")
    private String editora;
    @Min(value = 1440, message = "Ano de publicação deve ser superior a 1440")
    private int anoPublicacao;
    @Min(value = 1, message = "Número de páginas deve ser maior que zero")
    private int qtdePaginas;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQtdePaginas() {
        return qtdePaginas;
    }

    public void setQtdePaginas(int qtdePaginas) {
        this.qtdePaginas = qtdePaginas;
    }
}


