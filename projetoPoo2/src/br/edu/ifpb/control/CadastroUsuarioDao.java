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
    public boolean deletar(Funcionario funcionario);
    public boolean atualizar(Funcionario funcionario);
    public Set<Funcionario> listar();
}
