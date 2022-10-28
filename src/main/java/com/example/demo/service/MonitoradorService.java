package com.example.demo.service;

import com.example.demo.model.Monitorador;
import com.example.demo.repository.EnderecosRepository;
import com.example.demo.repository.MonitoradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}