

package br.com.porao.negocio;

import br.com.porao.entidades.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface ServicosProduto extends Serializable {
    public void cadastrar(Produto produto) throws ProdutoExistenteException;
    public void atualizar(Produto produto) throws ProdutoInexistenteException;
    public void remover(String nome) throws ProdutoInexistenteException;
    public List<Produto> listarTodos();
    
}
