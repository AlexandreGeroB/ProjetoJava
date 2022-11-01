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

  @GetMapping
  public ResponseEntity<List<Monitorador>> findAll(){
    List<Monitorador> list = monitoradorService.findAll();
    return ResponseEntity.ok().body(list);
  }


  @GetMapping("/{id}")
  public ResponseEntity<?> findById(@PathVariable Long id) {
      Monitorador list = monitoradorService.findById(id);
      return ResponseEntity.ok().body(list);
 }

  @PostMapping
  public ResponseEntity<?> salvar(@RequestBody Monitorador monitoradorAux) {
    try{
      Monitorador monitorador = monitoradorService.persist(monitoradorAux);
      return ResponseEntity.ok(monitorador);

    }catch (Exception e){
      return ResponseEntity.badRequest().body(e.getMessage());

    }

  }

  @PutMapping("/{id}")
    public ResponseEntity<Monitorador> update(@RequestBody Monitorador monitorador, @PathVariable Long id){
        monitorador = monitoradorService.update(monitorador, id);
        return ResponseEntity.noContent().build();
    }

  @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
      monitoradorService.delete(id);
        return ResponseEntity.noContent().build();
  }

}

