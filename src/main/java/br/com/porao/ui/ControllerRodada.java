/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.ui;

import br.com.porao.entidades.Produto;
import br.com.porao.entidades.Rodada;
import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.ProdutoExistenteException;
import br.com.porao.negocio.RodadaExistenteException;
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
public class ControllerRodada {
static Logger log = Logger.getLogger(ControllerRodada.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    @RequestMapping(value = "/rodada/listar", method = RequestMethod.GET)
    public @ResponseBody List<Rodada> listarTodos(){
        return fachada.listarTodasAsRodadas();
    }
    
    @RequestMapping(value = "/rodada/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addRodada (Rodada rodada){
        try{
            this.fachada.cadastrarRodada(rodada);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(RodadaExistenteException rodadaexistente){
            return new ResponseEntity<RodadaExistenteException>(rodadaexistente, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/rodada")
    public String form(){
        return "cadastrorodadas";
    }

}

