/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.control;

import br.edu.ifpb.model.Pedido;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan
 */
public class PedidoDaoImpl implements PedidoDao {
    
    private File file;
    
    public PedidoDaoImpl(){
        file = new File("Pedidos");
        
        if(!file.exists()) try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CadastroUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean salvarPedido (Pedido pedido) throws IOException, ClassNotFoundException {
        Set<Pedido> pedidos = getPedidos();
        if(pedidos.add(pedido)){
            atualizarArquivo(pedidos);
            return true;
        } else return false;
    }
    
    @Override
    public boolean atualizarPedido(Pedido velho, Pedido novo) throws IOException, ClassNotFoundException {
        Set<Pedido> pedidos = getPedidos();
        if((pedidos.remove(velho)) && (pedidos.add(novo))){
            atualizarArquivo(pedidos);
            return true;
        } else return false;
    }
    
    @Override
    public boolean removerPedido (Pedido pedido) throws IOException, ClassNotFoundException{
        Set<Pedido> pedidos = getPedidos();
        if(pedidos.remove(pedido)){
            atualizarArquivo(pedidos);
            return true;
        } else return false;
    }
    
    @Override
    public Set<Pedido> getPedidos() throws IOException, ClassNotFoundException{
        if(file.length()>0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            return (Set<Pedido>) in.readObject();
        }else{
            return new HashSet<>();
        }
    }
    
    @Override
    public Set<Pedido> getPedidoMesa(int mesa) throws IOException, ClassNotFoundException{
        Set<Pedido> pedidos = getPedidos();
        Set<Pedido> pedidosMesa = new HashSet<>();
        for (Pedido pedido : pedidos){
            if(pedido.getNumMesa() == mesa){
                pedidosMesa.add(pedido);
            }
        }
        return pedidosMesa;
    }
    
    @Override
   public double valorTotal(int mesa) throws IOException, ClassNotFoundException{
       Set<Pedido> pedidos = getPedidos();
       double total = 0;
       for(Pedido pedido : pedidos){
           if((pedido.getNumMesa() == mesa)&&(pedido.isStatus() == false)){
               total += (pedido.getProduto().getPrecoUnit() * pedido.getQuantidade());
               pedido.setStatus(true);
               atualizarArquivo(pedidos);
           }
       }
       return total;
   }
    
    private void atualizarArquivo(Set<Pedido> pedidos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(pedidos);
    }
}
