package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;

/**
 *
 * @author Luan
 */
public interface CadastroUsuarioDao {
    
    public boolean salvar(Funcionario funcionario);
    public Funcionario[] listar();
    public boolean excluir(String cpf);
    public boolean atualizar(Funcionario funcionario);
}
