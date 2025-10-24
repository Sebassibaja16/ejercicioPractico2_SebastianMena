/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.impl;

import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Categoria;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.repository.CategoriaRepository;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.CategoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author menas
 */
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository repo;
  public CategoriaServiceImpl(CategoriaRepository repo){ this.repo = repo; }
  @Override public List<Categoria> listar(){ return repo.findAll(); }
  @Override public Categoria buscarOThrow(Long id){ return repo.findById(id).orElseThrow(); }
}
