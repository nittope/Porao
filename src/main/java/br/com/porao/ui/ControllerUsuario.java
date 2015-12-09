
package br.com.porao.ui;

import br.com.porao.entidades.Usuario;
import br.com.porao.negocio.FachadaServicos;
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
public class ControllerUsuario {
    static Logger log = Logger.getLogger(ControllerUsuario.class);
    
    @Autowired
    private FachadaServicos fachada;
    
    
    
    @RequestMapping(value = "/usuario/listar", method = RequestMethod.GET)
    public @ResponseBody List<Usuario> listarTodos(){
        return fachada.listarTodosOsUsuarios();
    }
    
    @RequestMapping(value = "/usuario/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<?> addUsuario (Usuario usuario){
        try{
            this.fachada.cadastrarUsuario(usuario);
            return new ResponseEntity<String>(HttpStatus.OK);
        }
        catch(UsuarioExistenteException usuarioexistente){
            return new ResponseEntity<UsuarioExistenteException>(usuarioexistente, HttpStatus.BAD_REQUEST);
        }
    }
    
    @RequestMapping("/usuario")
    public String form(){
        return "cadastrousuarios";
    }
}
