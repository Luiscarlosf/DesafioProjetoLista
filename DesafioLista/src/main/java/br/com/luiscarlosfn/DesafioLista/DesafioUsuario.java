package br.com.luiscarlosfn.DesafioLista;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DesafioUsuario {

    String[] listaUsuario = new String[10];

    @GetMapping("/web/listaUsuario")
    public String[] lista(){

        return listaUsuario;

    }

    @GetMapping("/web/add/{usuario}")
    public String add(@PathVariable("usuario") String usuario){

        String fraseDeRetorno = "";

        for(int i = 0; i < listaUsuario.length; i++){
            if(listaUsuario[i] == null){
                listaUsuario[i] = usuario;
                fraseDeRetorno = "Usuário adicionado";
                break;
            }else{
                fraseDeRetorno = "Lista preenchida completamente";
            }
        }

        return fraseDeRetorno;

    }

    @GetMapping("/web/delete/{usuario}")
    public String delete(@PathVariable("usuario") String usuario){

        String fraseDeRetorno = "";

        for(int i = 0; i < listaUsuario.length; i++){
            if(listaUsuario[i] != null && listaUsuario[i].equals(usuario)){
                listaUsuario[i] = null;
                fraseDeRetorno = "Usuário deletado";
                break;
            }else{
                fraseDeRetorno = "Usuário não identificado";
            }
        }

        return fraseDeRetorno;

    }

    @GetMapping("web/alteration/{usuarioAntigo}/{usuarioNovo}")
    public String alteration(@PathVariable("usuarioAntigo") String usuarioAnt,@PathVariable("usuarioNovo") String usuarioNov){

        String fraseDeRetorno = "";

        for(int i = 0; i < listaUsuario.length; i++){
            if(listaUsuario[i] != null && listaUsuario[i].equals(usuarioAnt)){
                listaUsuario[i] = usuarioNov;
                fraseDeRetorno = "Alteração completada";
                break;
            }else{
                fraseDeRetorno = "Usuário não encontrado";
            }
        }

        return fraseDeRetorno;

    }
}
