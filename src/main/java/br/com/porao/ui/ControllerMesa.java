
package br.com.porao.ui;

import br.com.porao.entidades.Mesa;
import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.MesaExistenteException;
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
public class ControllerMesa {
    static Logger log = Logger.getLogger(ControllerMesa.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    @RequestMapping(value = "/mesa/listar", method = RequestMethod.GET)
    public @ResponseBody List<Mesa> listarTodos(){
        return fachada.listarTodasAsMesas();
    }
    
    @RequestMapping(value = "/mesa/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addMesa (Mesa mesa){
        try{
            this.fachada.cadastrarMesa(mesa);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(MesaExistenteException mesaexistente){
            return new ResponseEntity<MesaExistenteException>(mesaexistente, HttpStatus.BAD_REQUEST);
        }
    }
    @RequestMapping("/mesa")
    public String form(){
        return "cadastromesas";
    }

}
