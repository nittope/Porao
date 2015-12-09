/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Cliente;
import br.com.porao.persistencia.RepositorioClientes;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosClienteImpl implements ServicosCliente {
    
    @Autowired
    private RepositorioClientes repositorio;

    @Override
    public void cadastrar(Cliente cliente) throws ClienteExistenteException {
        if(repositorio.findByNome(cliente.getNome())!= null)
            throw new ClienteExistenteException();
        repositorio.save(cliente);
    }

    @Override
    public void atualizar(Cliente cliente) throws ClienteInexistenteException {
        Cliente clienteAtualizar = repositorio.findByNome(cliente.getNome());
        
        if(clienteAtualizar != null)
            throw new ClienteInexistenteException();
        clienteAtualizar.setNome(cliente.getNome());
       // clienteAtualizar.setPedidos(cliente.getPedidos());
        //clienteAtualizar.setRodada(cliente.getRodada());
        
        repositorio.save(clienteAtualizar);
    }

    @Override
    public void remover(String nome) throws ClienteInexistenteException {
        
         Cliente clienteAtualizar = repositorio.findByNome(nome);
        
        if(clienteAtualizar != null)
            throw new ClienteInexistenteException();
        repositorio.delete(clienteAtualizar);
    }

    @Override
    public List<Cliente> listarTodos() {
        return (List<Cliente>) repositorio.findAll();
        
    }
    
}