/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.persistencia;

import br.com.porao.entidades.Produto;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface RepositorioProdutos extends CrudRepository<Produto, Long> {
    public Produto findByNome(String nome);    
}
