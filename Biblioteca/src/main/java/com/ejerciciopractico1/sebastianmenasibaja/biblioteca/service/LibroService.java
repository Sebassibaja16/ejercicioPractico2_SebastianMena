/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service;

import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Libro;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author menas
 */
public interface LibroService {
    List<Libro> listar(String q);
  Optional<Libro> buscar(Long id);
  Libro crear(Libro l);
  Libro actualizar(Long id, Libro l);
  void eliminar(Long id);
}
