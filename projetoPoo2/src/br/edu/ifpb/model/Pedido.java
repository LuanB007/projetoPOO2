package br.edu.ifpb.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Classe que contém os dados do pedido.
 * @author Luan
 */
public class Pedido implements Serializable {
    private Produto produto;
    private int quantidade;
    private LocalDate data;
    private LocalDateTime hora;
    private double subtotal;
    private int mesa;
    private boolean status;
    

    /**
     * Construtor da classe Pedido.
     * @param produto objeto produto.
     * @param quantidade quantidade do produto pedido.
     * @param data data do pedido.
     * @param hora horário do pedido.
     * @param mesa mesa que fez o pedido.
     * @param status boolean que define se o pedido já foi atendido.
     */
    public Pedido(Produto produto, int quantidade, LocalDate data, LocalDate hora, int mesa, boolean status) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.data = LocalDate.now();
        this.hora = LocalDateTime.now();
        this.mesa = mesa;
        this.status = status;
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

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public double getSubtotal() {
        return produto.getPrecoUnit()*quantidade;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.produto);
        hash = 53 * hash + this.quantidade;
        hash = 53 * hash + Objects.hashCode(this.data);
        hash = 53 * hash + Objects.hashCode(this.hora);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.subtotal) ^ (Double.doubleToLongBits(this.subtotal) >>> 32));
        hash = 53 * hash + this.mesa;
        hash = 53 * hash + (this.status ? 1 : 0);
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
        if (this.mesa != other.mesa) {
            return false;
        }
        if (this.status != other.status) {
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
        return "Pedido{" + "produto=" + produto + ", quantidade=" + quantidade + ", data=" + data + ", hora=" + hora + ", subtotal=" + subtotal + ", mesa=" + mesa + ", status=" + status + '}';
    }

}
