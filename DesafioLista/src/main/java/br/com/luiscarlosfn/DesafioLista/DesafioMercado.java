package br.com.luiscarlosfn.DesafioLista;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesafioMercado {

    @GetMapping("/teste")
    public void teste(){

        System.out.print("Testando");

    }

}
