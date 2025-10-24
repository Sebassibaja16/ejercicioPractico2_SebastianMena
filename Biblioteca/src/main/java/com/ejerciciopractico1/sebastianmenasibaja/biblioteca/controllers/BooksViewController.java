/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.controllers;

import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Libro;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.CategoriaService;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author menas
 */
public class BooksViewController {
      private final LibroService libroService;
  private final CategoriaService categoriaService;

  public BooksViewController(LibroService libroService, CategoriaService categoriaService){
    this.libroService = libroService;
    this.categoriaService = categoriaService;
  }

  @GetMapping
  public String list(@RequestParam(required=false) String q, Model model){
    model.addAttribute("pageTitle","Libros");
    model.addAttribute("q", q);
    model.addAttribute("books", libroService.listar(q));
    return "books/list";
  }

  @GetMapping("/new")
  public String createForm(Model model){
    model.addAttribute("pageTitle","Nuevo libro");
    model.addAttribute("book", new Libro());
    model.addAttribute("allCategories", categoriaService.listar());
    model.addAttribute("isEdit", false);
    return "books/form";
  }

  @PostMapping
  public String create(@Valid @ModelAttribute("book") Libro book, BindingResult br, Model model){
    if (br.hasErrors()){
      model.addAttribute("allCategories", categoriaService.listar());
      model.addAttribute("isEdit", false);
      return "books/form";
    }
    if (book.getCategoria()!=null && book.getCategoria().getId()!=null){
      book.setCategoria(categoriaService.buscarOThrow(book.getCategoria().getId()));
    }
    libroService.crear(book);
    return "redirect:/books";
  }

  @GetMapping("/{id}/edit")
  public String editForm(@PathVariable Long id, Model model){
    Libro b = libroService.buscar(id).orElseThrow();
    model.addAttribute("pageTitle","Editar libro");
    model.addAttribute("book", b);
    model.addAttribute("allCategories", categoriaService.listar());
    model.addAttribute("isEdit", true);
    return "books/form";
  }

  @PostMapping("/{id}/edit")
  public String update(@PathVariable Long id, @Valid @ModelAttribute("book") Libro book,
                       BindingResult br, Model model){
    if (br.hasErrors()){
      model.addAttribute("allCategories", categoriaService.listar());
      model.addAttribute("isEdit", true);
      return "books/form";
    }
    if (book.getCategoria()!=null && book.getCategoria().getId()!=null){
      book.setCategoria(categoriaService.buscarOThrow(book.getCategoria().getId()));
    }
    libroService.actualizar(id, book);
    return "redirect:/books";
  }

  @PostMapping("/{id}/delete")
  public String delete(@PathVariable Long id){
    libroService.eliminar(id);
    return "redirect:/books";
  }
}
