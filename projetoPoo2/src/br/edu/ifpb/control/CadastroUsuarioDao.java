package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
/**
 *
 * @author Luan
 */
public interface CadastroUsuarioDao {
    
    public boolean salvar(Funcionario funcionario);
    public boolean deletar(Funcionario funcionario);
    public boolean atualizar(Funcionario funcionario);
    public Object[] listar();
}
