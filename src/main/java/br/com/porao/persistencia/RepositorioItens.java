
package br.com.porao.persistencia;

import br.com.porao.entidades.Item;
import br.com.porao.entidades.Produto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface RepositorioItens extends CrudRepository<Item, Long> {   
    public Item findByProduto(Produto produto);
}
