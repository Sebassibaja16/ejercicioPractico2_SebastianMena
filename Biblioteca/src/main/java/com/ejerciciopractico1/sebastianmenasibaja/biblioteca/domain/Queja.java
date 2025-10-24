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
@Table(name = "queja")
public class Queja {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre_cliente", length = 150)
  private String nombreCliente;

  @Column(length = 200)
  private String email;

  @Column(length = 30)
  private String telefono;

  // Usa "tipo" si tu tabla corregida tiene esa columna (no "2po")
  @Column(name = "tipo", nullable = false, length = 12)
  private String tipo; // QUEJA | SUGERENCIA | CONSULTA

  @Column(length = 200)
  private String asunto;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String mensaje;

  private Boolean tratado = Boolean.FALSE;

  // Getters y setters (o Lombok si lo usas)
  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }
  public String getNombreCliente() { return nombreCliente; }
  public void setNombreCliente(String v) { this.nombreCliente = v; }
  public String getEmail() { return email; }
  public void setEmail(String v) { this.email = v; }
  public String getTelefono() { return telefono; }
  public void setTelefono(String v) { this.telefono = v; }
  public String getTipo() { return tipo; }
  public void setTipo(String v) { this.tipo = v; }
  public String getAsunto() { return asunto; }
  public void setAsunto(String v) { this.asunto = v; }
  public String getMensaje() { return mensaje; }
  public void setMensaje(String v) { this.mensaje = v; }
  public Boolean getTratado() { return tratado; }
  public void setTratado(Boolean v) { this.tratado = v; }
}

