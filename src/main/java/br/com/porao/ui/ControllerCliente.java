/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.ui;

import br.com.porao.entidades.Cliente;
import br.com.porao.entidades.Mesa;
import br.com.porao.negocio.ClienteExistenteException;
import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.MesaExistenteException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Controller
public class ControllerCliente {
    
    static Logger log = Logger.getLogger(ControllerCliente.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    @RequestMapping(value = "/cliente/listar", method = RequestMethod.GET)
    public @ResponseBody List<Cliente> listarTodos(){
        return fachada.listarTodosOsClientes();
    }
    
    @RequestMapping(value = "/cliente/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addCliente (Cliente cliente){
        try{
            this.fachada.cadastrarCliente(cliente);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(ClienteExistenteException clienteexistente){
            return new ResponseEntity<ClienteExistenteException>(clienteexistente, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/cliente")
    public String form(){
        return "cadastroclientes";
    }

}


