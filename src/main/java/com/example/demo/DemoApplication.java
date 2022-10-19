package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
/*
  @Bean
  CommandLineRunner initDataBase(MonitoradorRepository monitoradorRepository){
    return args -> {

      monitoradorRepository.deleteAll();

      Monitorador m = new Monitorador();
      m.setNome("Alexandre");
      m.setCpf("12345678910");
      m.setRg("12345678");
      m.setCnpj(null);
      m.setInscricaoEstadual(null);
      m.setEmail("alexandre@gmail.com");
      m.setContato("994548169");

      monitoradorRepository.save(m);
    };
  }
*/
}


