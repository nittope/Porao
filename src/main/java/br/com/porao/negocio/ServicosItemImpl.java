
package br.com.porao.negocio;

import br.com.porao.entidades.Item;
import br.com.porao.entidades.Produto;
import br.com.porao.persistencia.RepositorioItens;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosItemImpl implements ServicosItem{

    @Autowired
    private RepositorioItens repositorio;

    @Override
    public void cadastrar(Item item) throws ItemExistenteException {
        
        repositorio.save(item);
        
    }

    @Override
    public void atualizar(Item item) throws ItemInexistenteException {
        Item itemAtualizar = repositorio.findByProduto((Produto) item.getProduto());
        
        if(itemAtualizar == null)
            throw new ItemInexistenteException();
        itemAtualizar.setProduto(item.getProduto());
        itemAtualizar.setQuantidade(item.getQuantidade());
        itemAtualizar.setTotal(item.getTotal());
        
    }

    @Override
    public void remover(Item item) throws ItemInexistenteException {
        
        Item itemAtualizar = repositorio.findByProduto((Produto) item.getProduto());
        
        if(itemAtualizar == null)
            throw new ItemInexistenteException();
        repositorio.delete(itemAtualizar);
        
    }

    @Override
    public List<Item> listarTodos() {
        return (List<Item>) repositorio.findAll();
    }
    
}
