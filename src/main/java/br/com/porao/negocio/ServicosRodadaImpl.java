/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Rodada;
import br.com.porao.persistencia.RepositorioRodadas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosRodadaImpl implements ServicosRodada {
    
    @Autowired
    private RepositorioRodadas repositorio;

    @Override
    public void cadastrar(Rodada rodada) throws RodadaExistenteException {
        
        if(repositorio.findByMesa(rodada.getMesa())!= null)
            throw new RodadaExistenteException();
        repositorio.save(rodada);
        
    }

    @Override
    public void atualizar(Rodada rodada) throws RodadaInexistenteException {
        
        Rodada rodadaAtualizar = repositorio.findByMesa(rodada.getMesa());
        
        if(rodadaAtualizar == null)
            throw new RodadaInexistenteException();
        rodadaAtualizar.setClientes(rodada.getClientes());
        rodadaAtualizar.setMesa(rodada.getMesa());
        //rodadaAtualizar.setPedidos(rodada.getPedidos());
        rodadaAtualizar.setVenda(rodada.getVenda());
        
        repositorio.save(rodadaAtualizar);
        
    }

    @Override
    public void remover(Long id) throws RodadaInexistenteException {
         Rodada rodadaAtualizar = repositorio.findByMesa(id);
        
        if(rodadaAtualizar == null)
            throw new RodadaInexistenteException();
        repositorio.delete(rodadaAtualizar);
    }

    @Override
    public List<Rodada> listarTodas() {
        return (List<Rodada>) repositorio.findAll();
        
    }
    
}
