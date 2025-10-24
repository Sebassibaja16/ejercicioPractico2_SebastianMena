/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.impl;

import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Queja;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.repository.QuejaRepository;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.QuejaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * @author menas
 */

@Service
@Transactional
public class QuejaServiceImpl implements QuejaService {
  private final QuejaRepository repo;
  public QuejaServiceImpl(QuejaRepository repo){ this.repo = repo; }
  @Override public Queja crear(Queja q){ return repo.save(q); }
  @Override public List<Queja> listar(){ return repo.findAll(); }
}
