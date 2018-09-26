package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.io.IOException;
import java.util.Set;
/**
 *
 * @author Luan
 */
public interface CadastroUsuarioDao {
    
    public boolean existeFuncionario(String cpf) throws IOException, ClassNotFoundException;
    public boolean autentica(String user, String pass) throws IOException, ClassNotFoundException;
    public boolean salvar(Funcionario funcionario) throws IOException, ClassNotFoundException;
    public boolean deletar(String cpf) throws IOException, ClassNotFoundException;
    public boolean atualizar(Funcionario funcionario, String cpf) throws IOException, ClassNotFoundException;
    public Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException;
}
