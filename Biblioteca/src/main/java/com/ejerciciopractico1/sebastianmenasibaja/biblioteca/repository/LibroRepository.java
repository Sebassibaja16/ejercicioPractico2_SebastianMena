/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ejerciciopractico1.sebastianmenasibaja.biblioteca.repository;
import com.ejerciciopractico1.sebastianmenasibaja.biblioteca.domain.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 *
 * @author menas
 */
public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByTituloContainingIgnoreCase(String q);
}
