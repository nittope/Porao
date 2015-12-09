/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Pedido;
import br.com.porao.persistencia.RepositorioPedidos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosPedidoImpl implements ServicosPedido {

    @Autowired
    private RepositorioPedidos repositorio;

    @Override
    public void cadastrar(Pedido pedido) throws PedidoExistenteException {
        repositorio.save(pedido);
    }

    @Override
    public List<Pedido> listarTodos() {
        return (List<Pedido>) repositorio.findAll();
        
    }

}
