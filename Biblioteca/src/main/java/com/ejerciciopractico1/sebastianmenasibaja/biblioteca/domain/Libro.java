/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


/**
 *
 * @author menas
 */
@Entity
@Table(name = "libro")
public class Libro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  
  @Column(name = "titulo", nullable = false)
  private String titulo;

  @Column(nullable = false, length = 200)
  private String autor;

  private String isbn;

  @Column(columnDefinition = "TEXT")
  private String descripcion;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "categoria_id", referencedColumnName = "id", nullable = false)
  private Categoria categoria;

  @Column(name = "fecha_publicacion")
  private LocalDate fechaPublicacion;

  private Boolean disponible = Boolean.TRUE;
  private BigDecimal precio;

  // getters/setters
  public Long getId() { return id; } public void setId(Long id) { this.id = id; }
  public String getTitulo() { return titulo; } public void setTitulo(String titulo) { this.titulo = titulo; }
  public String getAutor() { return autor; } public void setAutor(String autor) { this.autor = autor; }
  public String getIsbn() { return isbn; } public void setIsbn(String isbn) { this.isbn = isbn; }
  public String getDescripcion() { return descripcion; } public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
  public Categoria getCategoria() { return categoria; } public void setCategoria(Categoria categoria) { this.categoria = categoria; }
  public LocalDate getFechaPublicacion() { return fechaPublicacion; } public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
  public Boolean getDisponible() { return disponible; } public void setDisponible(Boolean disponible) { this.disponible = disponible; }
  public BigDecimal getPrecio() { return precio; } public void setPrecio(BigDecimal precio) { this.precio = precio; }
}

