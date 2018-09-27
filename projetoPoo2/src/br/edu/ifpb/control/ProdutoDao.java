package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Luan
 */
public interface ProdutoDao {
    
    public boolean salvar(Produto produto) throws IOException, ClassNotFoundException;
    public boolean deletar(long codigo) throws IOException, ClassNotFoundException;
    public boolean atualizar(Produto produto, long codigo) throws IOException, ClassNotFoundException;
    public boolean existeProduto(long codigo) throws IOException, ClassNotFoundException ;
    public Set<Produto> getProdutos() throws IOException, ClassNotFoundException;
}
