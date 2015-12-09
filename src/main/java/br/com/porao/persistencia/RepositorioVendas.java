/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.persistencia;

import br.com.porao.entidades.Rodada;
import br.com.porao.entidades.Venda;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface RepositorioVendas extends CrudRepository<Venda, Long> {
    
    public Venda findById(Long id);
}
