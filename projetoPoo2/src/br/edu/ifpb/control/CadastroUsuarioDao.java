package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.util.Set;
/**
 *
 * @author Luan
 */
public interface CadastroUsuarioDao {
    
    public boolean autentica(String user, String pass);
    public boolean salvar(Funcionario funcionario);
    public boolean deletar(String cpf);
    public boolean atualizar(Funcionario funcionario, String cpf);
    public boolean existeFuncionario(String cpf);
    public Set<Funcionario> listar();
}
