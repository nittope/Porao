
package br.com.porao.negocio;

import br.com.porao.entidades.Item;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface ServicosItem extends Serializable {
    
    public void cadastrar (Item item) throws ItemExistenteException;
    public void atualizar (Item item) throws ItemInexistenteException;
    public void remover (Item item) throws ItemInexistenteException;
    public List<Item> listarTodos();
    
}
