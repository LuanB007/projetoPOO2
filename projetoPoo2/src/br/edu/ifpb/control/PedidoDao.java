/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.control;

import br.edu.ifpb.model.Pedido;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Luan
 */
public interface PedidoDao {
    
    public boolean salvarPedido (Pedido pedido) throws IOException, ClassNotFoundException;
    public boolean atualizarPedido(Pedido velho, Pedido novo) throws IOException, ClassNotFoundException;
    public boolean removerPedido (Pedido pedido) throws IOException, ClassNotFoundException;
    public Set<Pedido> getPedidos() throws IOException, ClassNotFoundException;
}
