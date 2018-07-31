package br.edu.ifpb.services;

import br.edu.ifpb.model.Comanda;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Luan
 */
public class GerenciaMesa {
    private static int id;
    private int numeroMesa;
    private List<Comanda> comanda;

    public GerenciaMesa(int numero, List<Comanda> comanda) {
        this.numeroMesa = id++;
        this.comanda = comanda;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public List<Comanda> getComanda() {
        return comanda;
    }

    public void setComanda(List<Comanda> comanda) {
        this.comanda = comanda;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.numeroMesa;
        hash = 37 * hash + Objects.hashCode(this.comanda);
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
        final GerenciaMesa other = (GerenciaMesa) obj;
        if (this.numeroMesa != other.numeroMesa) {
            return false;
        }
        if (!Objects.equals(this.comanda, other.comanda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GerenciaMesa{" + "numero=" + numeroMesa + ", comanda=" + comanda + '}';
    }
    
}
