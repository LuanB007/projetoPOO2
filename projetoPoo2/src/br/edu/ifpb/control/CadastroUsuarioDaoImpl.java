package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Essa classe contém os métodos necessários para fazer o CRUD de usuário(funcionário).
 * @author Luan
 */
public class CadastroUsuarioDaoImpl implements CadastroUsuarioDao {
    
    private Set<Funcionario> funcionarios;
    
    /**
     * Contrutor da lista de funcionários.
     */
    public CadastroUsuarioDaoImpl() {
        this.funcionarios = new HashSet<>();
    }
    
    /**
     * Método usado para verificar a autenticação do usuário.
     * @param user o usuario
     * @param pass a senha
     * @return true ou false
     */
    @Override
    public boolean autentica(String user, String pass){
        return funcionarios.stream().anyMatch((f) -> (f.getUsuario().equals(user) && f.getSenha().equals(pass)));
    }
    
    /**
     * Método usado para salvar o funcionário na lista.
     * @param funcionario objeto funcionário.
     * @return true ou false
     */
    @Override
    public boolean salvar(Funcionario funcionario){
        return funcionarios.add(funcionario);
    }
    
    /**
     * Método usado para deletar um funcionário.
     * @param cpf CPF do funcionário.
     * @return true ou false
     */
    @Override
    public boolean deletar(String cpf){
        if(existeFuncionario(cpf)){
            for (Funcionario f: funcionarios){
                if(f.getCpf().equals(cpf)){
                    funcionarios.remove(f);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Método que atualiza os dados de um funcionário já presente na lista.
     * @param funcionario objeto funcionário.
     * @param cpf CPF do funcionário.
     * @return 
     */
    @Override
    public boolean atualizar(Funcionario funcionario, String cpf){
        if(existeFuncionario(cpf)){
            for (Funcionario f: funcionarios){
                if(f.getCpf().equals(cpf)){
                    funcionarios.remove(f);
                    funcionarios.add(funcionario);
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Método utilizado para verificar se o usuário já está cadastrado.
     * @param cpf CPF do funcionário.
     * @return true ou false.
     */
    @Override
    public boolean existeFuncionario(String cpf){
        return funcionarios.stream().anyMatch((f) -> (f.getCpf().equals(cpf)));
    }
    
    /**
     * Método utilizado para listar todos os funcionários cadastrados.
     * @return a lista de funcionários.
     */
    @Override
    public Set<Funcionario> listar(){
        return funcionarios;
    }
}
