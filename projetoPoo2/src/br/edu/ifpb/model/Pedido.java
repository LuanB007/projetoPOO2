package br.edu.ifpb.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Luan
 */
public class Pedido {
    private Produto produto;
    private int quantidade;
    private LocalDate data;
    private LocalDate hora;
    private double subtotal;

    public Pedido(Produto produto, int quantidade, LocalDate data, LocalDate hora, double subtotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
        this.hora = LocalDate.now();
        this.subtotal = subtotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getHora() {
        return hora;
    }

    public void setHora(LocalDate hora) {
        this.hora = hora;
    }

    public double getSubtotal() {
        return produto.getPrecoUnit() * quantidade;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.produto);
        hash = 23 * hash + this.quantidade;
        hash = 23 * hash + Objects.hashCode(this.data);
        hash = 23 * hash + Objects.hashCode(this.hora);
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.subtotal) ^ (Double.doubleToLongBits(this.subtotal) >>> 32));
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
        final Pedido other = (Pedido) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (Double.doubleToLongBits(this.subtotal) != Double.doubleToLongBits(other.subtotal)) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pedido{" + "produto=" + produto + ", quantidade=" + quantidade + ", data=" + data + ", hora=" + hora + ", subtotal=" + subtotal + '}';
    }
    
}
