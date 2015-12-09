

package br.com.porao.ui;

import br.com.porao.entidades.Item;

import br.com.porao.negocio.FachadaServicos;
import br.com.porao.negocio.ItemExistenteException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Controller
public class ControllerItem {
    static Logger log = Logger.getLogger(ControllerItem.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    @RequestMapping(value = "/item/listar", method = RequestMethod.GET)
    public @ResponseBody List<Item> listarTodos(){
        return fachada.listarTodosOsItens();
    }
    
    @RequestMapping(value = "/item/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addItem (Item item){
        try{
            this.fachada.cadastrarItem(item);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(ItemExistenteException itemexistente){
            return new ResponseEntity<ItemExistenteException>(itemexistente, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping("/item")
    public String form(){
        return "cadastroitens";
    }

}
