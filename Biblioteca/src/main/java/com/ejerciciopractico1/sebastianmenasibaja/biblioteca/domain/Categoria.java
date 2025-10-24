/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain;


import jakarta.persistence.*;


/**
 *
 * @author menas
 */
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String nombre;

  @Column(length = 255)
  private String descripcion;

  // getters/setters
  public Long getId() { return id; } public void setId(Long id) { this.id = id; }
  public String getNombre() { return nombre; } public void setNombre(String nombre) { this.nombre = nombre; }
  public String getDescripcion() { return descripcion; } public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
