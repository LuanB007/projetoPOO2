package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Luan
 */
public class FazerPedido {
    private List<Produto> produtos;
    private int quantidade;

    public FazerPedido(List<Produto> produtos, int quantidade) {
        this.produtos = new ArrayList<>();
        this.quantidade = quantidade;
    }

    public List<Produto> getProdutos() {
        if (produtos == null) produtos = new ArrayList<>();
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.produtos);
        hash = 89 * hash + this.quantidade;
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
        final FazerPedido other = (FazerPedido) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (!Objects.equals(this.produtos, other.produtos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "FazerPedido{" + "produtos=" + produtos + ", quantidade=" + quantidade + '}';
    }
    
    
}
