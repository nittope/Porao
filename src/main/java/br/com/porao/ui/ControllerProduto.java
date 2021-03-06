/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.ui;

import br.com.porao.entidades.Produto;
import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.ProdutoExistenteException;
import br.com.porao.negocio.UsuarioExistenteException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Controller
public class ControllerProduto {
    static Logger log = Logger.getLogger(ControllerProduto.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    @RequestMapping(value = "/produto/listar", method = RequestMethod.GET)
    public @ResponseBody List<Produto> listarTodos(){
        return fachada.listarTodosOsProdutos();
    }
    
    @RequestMapping(value = "/produto/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addProduto (Produto produto){
        try{
            this.fachada.cadastrarProduto(produto);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(ProdutoExistenteException produtoexistente){
            return new ResponseEntity<ProdutoExistenteException>(produtoexistente, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/produto")
    public String form(){
        return "cadastroprodutos";
    }

}
