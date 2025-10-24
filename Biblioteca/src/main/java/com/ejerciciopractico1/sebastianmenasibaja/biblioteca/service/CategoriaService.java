/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Categoria;
import java.util.List;
/**
 *
 * @author menas
 */
public interface CategoriaService {
    List<Categoria> listar();
  Categoria buscarOThrow(Long id);
}
