/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.controllers;

import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Queja;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.LibroService;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.QuejaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author menas
 */
public class HomeController {
  private final LibroService libroService;
  private final QuejaService quejaService;

  public HomeController(LibroService libroService, QuejaService quejaService){
    this.libroService = libroService;
    this.quejaService = quejaService;
  }

  @GetMapping("/")
  public String index(Model model){
    model.addAttribute("pageTitle","Inicio");
    model.addAttribute("latestBook", libroService.listar(null).stream().findFirst().orElse(null));
    model.addAttribute("feedback", new Queja());
    return "index";
  }

  @PostMapping("/feedback")
  public String feedback(@ModelAttribute("feedback") Queja q){
    if (q.getTipo()==null || q.getTipo().isBlank()) q.setTipo("CONSULTA");
    q.setTratado(Boolean.FALSE);
    quejaService.crear(q);
    return "redirect:/?ok=1";
  }
}
