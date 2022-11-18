package com.example.demo.service;

import com.example.demo.model.Monitorador;
import com.example.demo.repository.EnderecosRepository;
import com.example.demo.repository.MonitoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonitoradorService {

    @Autowired
    private MonitoradorRepository monitoradorRepository;

    @Autowired
    private EnderecosRepository enderecosRepository;

    public Monitorador persist(Monitorador monitoradorAux) throws Exception{
        if(monitoradorAux.getEnderecos() == null || monitoradorAux.getEnderecos().isEmpty()){
            throw new Exception("Endereço é obrigatorio");
        }

        Monitorador monitorador = monitoradorRepository.save(monitoradorAux);

        monitorador.getEnderecos().forEach(endereco -> {
            endereco.setMonitorador(monitorador);
            enderecosRepository.save(endereco);
        });

        return monitorador;
    }

    public List<Monitorador> findAll(){
        return monitoradorRepository.findAll();
    }

    public Monitorador findById(Long id) {
        Optional<Monitorador> obj = monitoradorRepository.findById(id);
            return obj.get();
    }


    public Monitorador update(Monitorador monitorador, Long id) {
        monitorador.setId(id);

        return monitoradorRepository.save(monitorador);
    }

    public void delete(Long id) {
        monitoradorRepository.deleteById(id);
    }
}
