/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.persistencia;

import br.com.porao.entidades.Mesa;
import br.com.porao.entidades.Rodada;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface RepositorioRodadas extends CrudRepository<Rodada, Long> {
    public Rodada findByMesa(Mesa mesa); 

    public Rodada findByMesa(Long id);
}
