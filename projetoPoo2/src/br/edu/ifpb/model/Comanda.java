package br.edu.ifpb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Luan
 */
public class Comanda {
    private List<Pedido> pedidos;
    private int numMesa;

    public Comanda(List<Pedido> pedidos, int numMesa) {
        this.pedidos = new ArrayList<>();
        this.numMesa = numMesa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
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
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.pedidos);
        hash = 31 * hash + this.numMesa;
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
}
