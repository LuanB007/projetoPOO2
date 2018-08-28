package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
import java.util.HashSet;
import java.util.Set;

/**
 * Essa classe contém os métodos necessários para fazer o CRUD de produtos.
 * @author Luan
 */
public class ProdutoDaoImpl implements ProdutoDao {
    
    private Set<Produto> produtos;
    
    /**
     * Contrutor da lista de produtos.
     */
    public ProdutoDaoImpl() {
        this.produtos = new HashSet<>();
    }

    /**
     * Método usado para cadastrar o produto.
     * @param produto objeto produto.
     * @return true ou false.
     */
    @Override
    public boolean salvar(Produto produto){
        return produtos.add(produto);
    }
    
    /**
     * Método usado para remover um produto existente.
     * @param codigo código do produto cadastrado.
     * @return true ou false.
     */
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
    
    /**
     * Método utilizado para atualizar um produto existente.
     * @param produto o objeto produto com as informações atualizadas.
     * @param codigo código do produto cadastrado.
     * @return true ou false.
     */
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
    
    /**
     * Método que verifica se o produto está cadastrado.
     * @param codigo código do produto.
     * @return true ou false.
     */
    @Override
    public boolean existeProduto(long codigo){
        return produtos.stream().anyMatch((p) -> (p.getCodigo() == codigo));
    }
    
    /**
     * Método utilizado para listar todos os produtos cadastrados.
     * @return uma lista de produtos.
     */
    @Override
    public Set<Produto> listar(){
        return produtos;
    }
}
