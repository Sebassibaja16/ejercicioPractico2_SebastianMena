/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.impl;

import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Libro;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.repository.LibroRepository;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.LibroService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;


/**
 *
 * @author menas
 */
@Service
@Transactional
public class LibroServiceImpl implements LibroService {
    private final LibroRepository repo;
  public LibroServiceImpl(LibroRepository repo){ this.repo = repo; }

  @Override public List<Libro> listar(String q){
    return (q==null || q.isBlank()) ? repo.findAll() : repo.findByTituloContainingIgnoreCase(q);
  }
  @Override public Optional<Libro> buscar(Long id){ return repo.findById(id); }
  @Override public Libro crear(Libro l){ return repo.save(l); }
  @Override public Libro actualizar(Long id, Libro l){
    Libro db = repo.findById(id).orElseThrow();
    db.setTitulo(l.getTitulo());
    db.setAutor(l.getAutor());
    db.setIsbn(l.getIsbn());
    db.setDescripcion(l.getDescripcion());
    db.setCategoria(l.getCategoria());
    db.setFechaPublicacion(l.getFechaPublicacion());
    db.setDisponible(l.getDisponible());
    db.setPrecio(l.getPrecio());
    return db;
  }
  @Override public void eliminar(Long id){ repo.deleteById(id); }
}
