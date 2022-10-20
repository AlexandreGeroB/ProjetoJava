package com.example.demo.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@JsonIgnoreProperties("monitorador")
public class Enderecos {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(nullable = false)
  private String end;

  @Column(nullable = false)
  private String num;

  @Column(nullable = false)
  private String cep;

  @Column(nullable = false)
  private String bairro;

  @Column(nullable = false)
  private String cidade;

  @Column(nullable = false)
  private String estado;

  @ManyToOne
  @JoinColumn( name = "idmonitorador")
  private Monitorador monitorador;
}