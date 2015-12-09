/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Pedido;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface ServicosPedido extends Serializable {
    
    public void cadastrar(Pedido pedido) throws PedidoExistenteException;   
    public List<Pedido> listarTodos();
    
}
