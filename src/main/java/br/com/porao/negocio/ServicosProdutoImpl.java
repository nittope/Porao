

package br.com.porao.negocio;

import br.com.porao.entidades.Produto;
import br.com.porao.persistencia.RepositorioProdutos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosProdutoImpl implements ServicosProduto{

    @Autowired
    private RepositorioProdutos repositorio;
    
    @Override
    public void cadastrar(Produto produto) throws ProdutoExistenteException {
        
        if(repositorio.findByNome(produto.getNome())!= null)
            throw new ProdutoExistenteException();
        repositorio.save(produto);
        
    }

    @Override
    public void atualizar(Produto produto) throws ProdutoInexistenteException {
        Produto produtoAtualizar = repositorio.findByNome(produto.getNome());
        
        if(produtoAtualizar != null)
            throw new ProdutoInexistenteException();
        produtoAtualizar.setEstoque(produto.getEstoque());
        //produtoAtualizar.setItem(produto.getItem());
        produtoAtualizar.setNome(produto.getNome());
        produtoAtualizar.setPreco(produto.getPreco());
        
        repositorio.save(produtoAtualizar);
    }

    @Override
    public void remover(String nome) throws ProdutoInexistenteException {
        Produto produtoAtualizar = repositorio.findByNome(nome);
        if(produtoAtualizar != null)
            throw new ProdutoInexistenteException();
        repositorio.delete(produtoAtualizar);
    }

    @Override
    public List<Produto> listarTodos() {
        return (List<Produto>) repositorio.findAll();
    }
}
