/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.porao.negocio;

import br.com.porao.entidades.Rodada;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Anna Paula, Ivson, Marcus Vinicius
 */
public interface ServicosRodada extends Serializable {
    
    public void cadastrar(Rodada rodada) throws RodadaExistenteException;
    public void atualizar(Rodada rodada) throws RodadaInexistenteException;
    public void remover (Long id) throws RodadaInexistenteException;
    public List<Rodada> listarTodas();
    
}
