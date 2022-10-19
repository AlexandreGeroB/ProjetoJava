package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Enderecos;
import com.example.demo.repository.EnderecosRepository;

  @RestController
  @RequestMapping("/api/enderecos")
  public class EnderecosController {

    private EnderecosRepository enderecosRepository;


    public EnderecosController(EnderecosRepository enderecosRepository) {
      this.enderecosRepository = enderecosRepository;
    }

    @GetMapping
  public List<Enderecos> list() {
    return enderecosRepository.findAll();
  }

    @GetMapping("/{id}")
    public ResponseEntity<Enderecos> findById(@PathVariable Long id) {
        return enderecosRepository.findById(id)
              .map(record -> ResponseEntity.ok().body(record))
              .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public void salvar(@RequestBody Enderecos enderecos) {
       enderecosRepository.save(enderecos);
    }

    @PutMapping
      public void alterar(@RequestBody Enderecos enderecos){
          if(enderecos.getId() > 0)
              enderecosRepository.save(enderecos);
      }

    @DeleteMapping("/{id}")
      public void excluir(@PathVariable Long id){
        enderecosRepository.deleteById(id);
      }
  }
