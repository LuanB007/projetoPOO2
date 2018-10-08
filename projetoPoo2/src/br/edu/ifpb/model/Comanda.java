package br.edu.ifpb.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Classe que contém os dados da mesa
 * @author Luan
 */
public class Comanda implements Serializable{
    private Set<Pedido> pedidos;
    private int numMesa;

    public Comanda(){
        this.pedidos = new HashSet<>();
    }
    
    /**
     * Contrutor da classe Comanda.
     * @param pedidos pedidos feito
     * @param numMesa numero da mesa.
     */
    public Comanda(Set<Pedido> pedidos, int numMesa) {
        this.pedidos = new HashSet<>();
        this.numMesa = numMesa;
    }

    public Set<Pedido> getPedidos() {
        if(pedidos == null) pedidos = new HashSet<>();
        return pedidos;
    }

    public void setPedidos(Set<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.pedidos);
        hash = 17 * hash + this.numMesa;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comanda other = (Comanda) obj;
        if (this.numMesa != other.numMesa) {
            return false;
        }
        if (!Objects.equals(this.pedidos, other.pedidos)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        return "Comanda{" + "pedidos=" + pedidos + ", numMesa=" + numMesa + '}';
    }
}
