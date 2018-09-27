package br.edu.ifpb.model;

import java.io.Serializable;
import java.util.Objects;
/**
 * Classe que contém os dados do produto.
 * @author Luan
 */
public class Produto implements Serializable {
    private long codigo;
    private String nome;
    private String descricao;
    private double precoUnit;
    
    /**
     * Construtor da classe Produto.
     * @param codigo o código do produto.
     * @param nome nome do produto.
     * @param descricao caracteristicas do produto.
     * @param precoUnit valor unitário.
     */
    public Produto(long codigo, String nome, String descricao, double precoUnit){
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.precoUnit = precoUnit;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoUnit() {
        return precoUnit;
    }

    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (this.codigo ^ (this.codigo >>> 32));
        hash = 61 * hash + Objects.hashCode(this.nome);
        hash = 61 * hash + Objects.hashCode(this.descricao);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.precoUnit) ^ (Double.doubleToLongBits(this.precoUnit) >>> 32));
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
        final Produto other = (Produto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.precoUnit) != Double.doubleToLongBits(other.precoUnit)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "codigo=" + codigo + ", nome=" + nome + ", descricao=" + descricao + ", precoUnit=" + precoUnit + '}';
    }
    
}
