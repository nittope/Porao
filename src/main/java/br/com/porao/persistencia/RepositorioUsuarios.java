
package br.com.porao.persistencia;

import br.com.porao.entidades.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {
    
    public Usuario findByNome (String nome);
    
} 
