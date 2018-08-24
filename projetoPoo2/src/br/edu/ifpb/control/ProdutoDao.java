package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;

/**
 *
 * @author Luan
 */
public interface ProdutoDao {
    
    public boolean salvar(Produto produto);
    public Produto[] listar();
    public boolean excluir(long codigo);
    public boolean atualizar(Produto produto);
}
