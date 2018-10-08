/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.control;

import br.edu.ifpb.model.Pedido;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Luan
 */
public class PedidoDaoImpl implements PedidoDao {
    
    private Set<Pedido> pedidos;
    private int mesa;
    
    public PedidoDaoImpl(){
        this.pedidos = new HashSet<>();
    }
    
    public boolean salvarPedido (Pedido pedido) {
        return pedidos.add(pedido);
    }
    
    public boolean atualizarPedido(Pedido velho, Pedido novo){
        if((velho != null) | (novo != null)){
            pedidos.remove(velho);
            pedidos.add(novo);
            return true;
        }
        return false;
    }
    
    public boolean removerPedido (Pedido pedido){
        if(pedido != null){
            pedidos.remove(pedido);
            return true;
        }
        return false;
    }
    
    public Set<Pedido> getPedidos(){
        return pedidos;
    }
}
