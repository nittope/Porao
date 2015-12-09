/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Venda;
import br.com.porao.persistencia.RepositorioVendas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
@Service
public class ServicosVendaImpl implements ServicosVenda {
    
    @Autowired
    private RepositorioVendas repositorio;
    
    @Override
    public void cadastrar(Venda venda) throws VendaExistenteException {        
        repositorio.save(venda);           
        
    }

   
    @Override
    public List<Venda> listarTodas() {
        
        return(List<Venda>) repositorio.findAll();
        
    }
    
}
