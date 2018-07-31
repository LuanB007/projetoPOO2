package br.edu.ifpb.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luan
 */
public class Cardapio {
    private List<Produto> produtos;
    
    public Cardapio(){
        this.produtos = new ArrayList<>();
    }
    
    public List<Produto> getCardapio(){
        if(produtos == null) produtos = new ArrayList<>();
        return produtos;
    }
    
    public void setProdutos(List<Produto> produto){
        this.produtos = produto;
    }
}
