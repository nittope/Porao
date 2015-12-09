/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Mesa;
import br.com.porao.persistencia.RepositorioMesas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosMesaImpl implements ServicosMesa {
    
    @Autowired
    private RepositorioMesas repositorio;

    @Override
    public void cadastrar(Mesa mesa) throws MesaExistenteException {
        if (repositorio.findByNome(mesa.getNome())!= null)
            throw new MesaExistenteException();
        repositorio.save(mesa);
        
    }

    @Override
    public void atualizar(Mesa mesa) throws MesaInexistenteException {
        Mesa mesaAtualizar = repositorio.findByNome(mesa.getNome());
        
        if (mesaAtualizar == null)
            throw new MesaInexistenteException();
        mesaAtualizar.setNome(mesa.getNome());
        //mesaAtualizar.setPedido(mesa.getPedido());
        //mesaAtualizar.setRodadas(mesa.getRodadas());
        mesaAtualizar.setStatus(mesa.getStatus());
        
        repositorio.save(mesaAtualizar);
        
    }

    @Override
    public void remover(String nome) throws MesaInexistenteException {
        
         Mesa mesaAtualizar = repositorio.findByNome(nome);
        
        if (mesaAtualizar == null)
            throw new MesaInexistenteException();
        
        repositorio.delete(mesaAtualizar);
        
    }

    @Override
    public List<Mesa> listarTodas() {
       return (List<Mesa>) repositorio.findAll();
    }
    
}
