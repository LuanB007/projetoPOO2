package br.edu.ifpb.model;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author Luan
 */
public class GerenciaMesa {
    private static int id;
    private int numero;
    private List<Comanda> comanda;

    public GerenciaMesa(int numero, List<Comanda> comanda) {
        this.numero = id++;
        this.comanda = comanda;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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
        hash = 37 * hash + this.numero;
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
        if (this.numero != other.numero) {
            return false;
        }
        if (!Objects.equals(this.comanda, other.comanda)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "GerenciaMesa{" + "numero=" + numero + ", comanda=" + comanda + '}';
    }
    
}
