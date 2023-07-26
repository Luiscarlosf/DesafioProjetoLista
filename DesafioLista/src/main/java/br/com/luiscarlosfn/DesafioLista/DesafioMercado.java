package br.com.luiscarlosfn.DesafioLista;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesafioMercado {

    String[] lista = new String[10];

    @GetMapping("/mercado/lista")
    public String[] lista(){

        return lista;

    }

    @GetMapping("/mercado/adicionar/{produto}")
    public String adicionar(@PathVariable("produto") String produto){

        String fraseDeRetorno = "";

        for(int i = 0; i < lista.length; i++){
            if(lista[i] == null){
                lista[i] = produto;
                fraseDeRetorno = "Produto adicionado com sucesso.";
                break;
            }else if(lista[i] != null){
                fraseDeRetorno = "Não há mais espaços disponíveis";
            }
        }

        return fraseDeRetorno;

    }

    @GetMapping("/mercado/deletar/{produto}")
    public String deletar(@PathVariable("produto") String produto){

        String fraseDeRetorno = "";

        for(int i = 0; i < lista.length; i++){

            if(lista[i].equals(produto)){

                lista[i] = null;
                fraseDeRetorno = "O item foi deletado com sucesso";
                break;

            }
        }

        return fraseDeRetorno;

    }

    @GetMapping("/mercado/substituir/{produtoAntigo}/{produtoNovo}")
    public String substituir(@PathVariable("produtoAntigo") String produtoAnt, @PathVariable("produtoNovo") String produtoNov){

        String fraseDeRetorno = "";
        for(int i = 0; i < lista.length; i++){

            if(lista[i].equals(produtoAnt)){

                lista[i] = produtoNov;
                fraseDeRetorno = "Produto alterado com sucesso";
                break;

            }

        }

        return fraseDeRetorno;

    }

}