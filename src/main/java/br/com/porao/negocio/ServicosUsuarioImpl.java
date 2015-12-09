
package br.com.porao.negocio;

import br.com.porao.entidades.Usuario;
import br.com.porao.persistencia.RepositorioUsuarios;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosUsuarioImpl implements ServicosUsuario{

    @Autowired
    private RepositorioUsuarios repositorio;
    
    @Override
    public void cadastrar(Usuario usuario) throws UsuarioExistenteException {
         if (repositorio.findByNome(usuario.getNome())!= null)
            throw new UsuarioExistenteException();
        repositorio.save(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) throws UsuarioInexistenteException {
        Usuario usuarioAtualizar = repositorio.findByNome(usuario.getNome());
        
        if(usuarioAtualizar == null)
            throw new UsuarioInexistenteException();
        usuarioAtualizar.setNome(usuario.getNome());
        usuarioAtualizar.setNiveldeacesso(usuario.getNiveldeacesso());
        //usuarioAtualizar.setPedidos(usuario.getPedidos());
        usuarioAtualizar.setLogin(usuario.getLogin());
        usuarioAtualizar.setSenha(usuario.getSenha());
        
        repositorio.save(usuarioAtualizar);
        
    }

    @Override
    public void remover(String nome) throws UsuarioInexistenteException {
        Usuario usuarioAtualizar = repositorio.findByNome(nome);
        
        if(usuarioAtualizar == null)
            throw new UsuarioInexistenteException();
        repositorio.delete(usuarioAtualizar);
        
    }

    @Override
    public List<Usuario> listarTodos() {
        return (List<Usuario>) repositorio.findAll();
        
    }
}
