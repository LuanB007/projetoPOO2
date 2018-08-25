package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Luan
 */
public class ProdutoDaoImpl implements ProdutoDao {
    
    private Set<Produto> produtos;

    public ProdutoDaoImpl() {
        this.produtos = new HashSet<>();
    }

    @Override
    public boolean salvar(Produto produto){
        return produtos.add(produto);
    }
    
    @Override
    public boolean deletar(Produto produto){
        return produtos.remove(produto);
    }
    
    @Override
    public boolean atualizar(Produto produto){
        if(deletar(produto)) return salvar(produto);
        else return false;
    }
    
    @Override
    public Object[] listar(){
        return produtos.toArray();
    }
}
