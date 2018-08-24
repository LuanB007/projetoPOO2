package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;

/**
 *
 * @author Luan
 */
public interface ProdutoDao {
    
    public boolean salvar(Produto produto);
    public boolean deletar(Produto produto);
    public boolean atualizar(Produto produto);
    public Object[] listar();
}
