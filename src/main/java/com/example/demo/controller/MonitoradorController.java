package com.example.demo.controller;

import java.util.List;

import com.example.demo.repository.EnderecosRepository;
import com.example.demo.service.MonitoradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Monitorador;
import com.example.demo.repository.MonitoradorRepository;

@RestController
@RequestMapping("/api/monitorador")
public class MonitoradorController {


  @Autowired
  private MonitoradorService monitoradorService;

//
//  @GetMapping
//  public List<Monitorador> list() {
//    List<Monitorador> monitoradores = monitoradorRepository.findAll();
//    return monitoradores;
//  }
//
//
//  @GetMapping("/{id}")
//  public ResponseEntity<Monitorador> findById(@PathVariable Long id) {
//      return monitoradorRepository.findById(id)
//            .map(record -> ResponseEntity.ok().body(record))
//            .orElse(ResponseEntity.notFound().build());
// }

  @PostMapping
  public ResponseEntity<?> salvar(@RequestBody Monitorador monitoradorAux) {
    try{
      Monitorador monitorador = monitoradorService.persist(monitoradorAux);
      return ResponseEntity.ok(monitorador);

    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());

    }

  }

//  @PutMapping
//    public void alterar(@RequestBody Monitorador monitorador){
//        if(monitorador.getId() > 0)
//            monitoradorRepository.save(monitorador);
//    }
//
//  @DeleteMapping("/{id}")
//    public void excluir(@PathVariable Long id){
//      monitoradorRepository.deleteById(id);
//  }



}

