
package br.com.porao.negocio;

import br.com.porao.entidades.Cliente;
import br.com.porao.entidades.Item;
import br.com.porao.entidades.Mesa;
import br.com.porao.entidades.Pedido;
import br.com.porao.entidades.Produto;
import br.com.porao.entidades.Rodada;
import br.com.porao.entidades.Usuario;
import br.com.porao.entidades.Venda;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface FachadaServicos extends Serializable {
    
    public void cadastrarUsuario(Usuario usuario) throws UsuarioExistenteException;
    public void atualizarUsuario(Usuario usuario) throws UsuarioInexistenteException;
    public void remverUsuario(String nome) throws UsuarioInexistenteException;
    public List<Usuario> listarTodosOsUsuarios();
    
    public void cadastrarProduto(Produto produto) throws ProdutoExistenteException;
    public void atualizarProduto(Produto produto) throws ProdutoInexistenteException;
    public void removerProduto(String nome) throws ProdutoInexistenteException;
    public List<Produto> listarTodosOsProdutos();
    
    public void cadastrarItem(Item item) throws ItemExistenteException;
    public void atualizarItem(Item item) throws ItemInexistenteException;
    public void removerItem(Item item) throws ItemInexistenteException;
    public List<Item> listarTodosOsItens();
    
    public void cadastrarMesa(Mesa mesa) throws MesaExistenteException;
    public void atualizarMesa(Mesa mesa) throws MesaInexistenteException;
    public void removerMesa(String nome) throws MesaInexistenteException;
    public List<Mesa> listarTodasAsMesas();
    
    public void cadastrarCliente(Cliente cliente) throws ClienteExistenteException;
    public void atualizarCliente(Cliente cliente) throws ClienteInexistenteException;
    public void removerCliente(String nome) throws ClienteInexistenteException;
    public List<Cliente> listarTodosOsClientes();
    
    public void cadastrarVenda(Venda venda) throws VendaExistenteException;    
    public List<Venda> ListarTodasAsVendas();
    
     public void cadastrarRodada(Rodada rodada) throws RodadaExistenteException;
    public void atualizarRodada(Rodada rodada) throws RodadaInexistenteException;
    public void removerRodada(Long id) throws RodadaInexistenteException;
    public List<Rodada> listarTodasAsRodadas();
    
    public void cadastrarPedido(Pedido pedido) throws PedidoExistenteException;    
    public List<Pedido> listarTodosOsPedidos();

}
