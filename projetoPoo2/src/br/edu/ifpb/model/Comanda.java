package br.edu.ifpb.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Luan
 */
public class Comanda {
    private List<Pedido> pedidos;
    private boolean atendido;

    public Comanda(List<Pedido> pedidos, boolean atendido) {
        this.pedidos = pedidos;
        this.atendido = atendido;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public boolean isAtendido() {
        return atendido;
    }

    public void setAtendido(boolean atendido) {
        this.atendido = atendido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.pedidos);
        hash = 31 * hash + (this.atendido ? 1 : 0);
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
        if (this.atendido != other.atendido) {
            return false;
        }
        if (!Objects.equals(this.pedidos, other.pedidos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comanda{" + "pedidos=" + pedidos + ", atendido=" + atendido + '}';
    }
    
}
