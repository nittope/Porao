/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.ui;

import br.com.porao.entidades.Pedido;
import br.com.porao.entidades.Produto;
import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.PedidoExistenteException;
import br.com.porao.negocio.ProdutoExistenteException;
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
public class ControllerPedido {
static Logger log = Logger.getLogger(ControllerPedido.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    @RequestMapping(value = "/pedido/listar", method = RequestMethod.GET)
    public @ResponseBody List<Pedido> listarTodos(){
        return fachada.listarTodosOsPedidos();
    }
    
    @RequestMapping(value = "/pedido/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addPedido (Pedido pedido){
        try{
            this.fachada.cadastrarPedido(pedido);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(PedidoExistenteException pedidoexistente){
            return new ResponseEntity<PedidoExistenteException>(pedidoexistente, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/pedido")
    public String form(){
        return "cadastropedidos";
    }

}

