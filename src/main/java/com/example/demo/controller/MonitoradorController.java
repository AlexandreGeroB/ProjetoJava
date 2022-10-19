package com.example.demo.controller;

import java.util.List;

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
  private MonitoradorRepository monitoradorRepository;

  @Autowired
  private EnderecosController enderecosController;


  public MonitoradorController(MonitoradorRepository monitoradorRepository) {
    this.monitoradorRepository = monitoradorRepository;
  }

  @GetMapping
  public List<Monitorador> list() {
    return monitoradorRepository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Monitorador> findById(@PathVariable Long id) {
      return monitoradorRepository.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public void salvar(@RequestBody Monitorador monitorador) {
    monitoradorRepository.save(monitorador);
    monitorador.getEnderecos().forEach(enderecos -> {
      enderecos.setMonitorador(monitorador);
      enderecosController.salvar(enderecos);
    });
  }

  @PutMapping
    public void alterar(@RequestBody Monitorador monitorador){
        if(monitorador.getId() > 0)
            monitoradorRepository.save(monitorador);
    }

  @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
      monitoradorRepository.deleteById(id);
    }
}

