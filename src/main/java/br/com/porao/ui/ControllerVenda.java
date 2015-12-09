/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.ui;

import br.com.porao.entidades.Usuario;
import br.com.porao.entidades.Venda;
import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.UsuarioExistenteException;
import br.com.porao.negocio.VendaExistenteException;
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
public class ControllerVenda {
static Logger log = Logger.getLogger(ControllerVenda.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    
    @RequestMapping(value = "/venda/listar", method = RequestMethod.GET)
    public @ResponseBody List<Venda> listarTodos(){
        return fachada.ListarTodasAsVendas();
    }
    
    @RequestMapping(value = "/venda/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addVenda (Venda venda){
        try{
            this.fachada.cadastrarVenda(venda);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(VendaExistenteException vendaexistente){
            return new ResponseEntity<VendaExistenteException>(vendaexistente, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping("/venda")
    public String form(){
        return "cadastrovendas";
    }
}

