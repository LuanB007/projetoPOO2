/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.control;

import br.edu.ifpb.model.Comanda;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Luan
 */
public class ComandaDaoImpl implements ComandaDao {
    
    private Set<Comanda> comandas;
    
    public ComandaDaoImpl(){
        this.comandas = new HashSet<>();
    }
    
    @Override
    public boolean salvarComanda(Comanda comanda){
        comandas.add(comanda);
        return true;
    }
    
    @Override
    public boolean atualizarComanda(Comanda novaComanda, int mesaVelha){
        for(Comanda comanda: comandas){
            if(comanda.getNumMesa() == mesaVelha){
                Comanda c = comanda;
                comandas.remove(c);
                comandas.add(novaComanda);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean removerComanda(int mesa){
        for(Comanda comanda : comandas){
            if(comanda.getNumMesa() == mesa){
                Comanda c = comanda;
                comandas.remove(c);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Set<Comanda> getComandas(){
        return comandas;
    }
}
