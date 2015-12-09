

package br.com.porao.negocio;

import br.com.porao.entidades.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface ServicosUsuario extends Serializable {
    
    public void cadastrar (Usuario usuario) throws UsuarioExistenteException;
    public void atualizar (Usuario usuario) throws UsuarioInexistenteException;
    public void remover (String nome) throws UsuarioInexistenteException;
    public List<Usuario> listarTodos();

    
}
