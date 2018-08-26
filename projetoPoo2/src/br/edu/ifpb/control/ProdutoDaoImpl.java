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
    public boolean deletar(long codigo){
        if(existeProduto(codigo)){
            for (Produto p: produtos){
                if(p.getCodigo() == codigo){
                    produtos.remove(p);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean atualizar(Produto produto, long codigo){
        if(existeProduto(codigo)){
            for (Produto p: produtos){
                if(p.getCodigo() == codigo){
                    produtos.remove(p);
                    produtos.add(produto);
                    return true;
                }
            }
        }
        return false;
    }
    
    @Override
    public boolean existeProduto(long codigo){
        return produtos.stream().anyMatch((p) -> (p.getCodigo() == codigo));
    }
    
    @Override
    public Set<Produto> listar(){
        return produtos;
    }
}
