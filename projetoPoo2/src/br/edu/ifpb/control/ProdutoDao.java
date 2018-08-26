package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
import java.util.Set;

/**
 *
 * @author Luan
 */
public interface ProdutoDao {
    
    public boolean salvar(Produto produto);
    public boolean deletar(long codigo);
    public boolean atualizar(Produto produto, long codigo);
    public boolean existeProduto(long codigo);
    public Set<Produto> listar();
}
