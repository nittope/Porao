/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Cliente;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface ServicosCliente extends Serializable{
    
    public void cadastrar(Cliente cliente) throws ClienteExistenteException;
    public void atualizar(Cliente cliente) throws ClienteInexistenteException;
    public void remover(String nome) throws ClienteInexistenteException;
    public List<Cliente> listarTodos();
    
}
