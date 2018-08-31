package br.edu.ifpb.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 * @author Luan
 */
public class Gerencia {
    private List<Comanda> comandas;

    /**
     * Contrutor da classe comanda.
     * @param comandas 
     */
    public Gerencia(List<Comanda> comandas) {
        this.comandas = new ArrayList<>();
    }

    public List<Comanda> getComandas() {
        return comandas;
    }

    public void setComandas(List<Comanda> comandas) {
        this.comandas = comandas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.comandas);
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
        final Gerencia other = (Gerencia) obj;
        if (!Objects.equals(this.comandas, other.comandas)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Gerencia{" + "comandas=" + comandas + '}';
    }
    
}
