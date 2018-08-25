package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Luan
 */
public class CadastroUsuarioDaoImpl implements CadastroUsuarioDao {
    
    private Set<Funcionario> funcionarios;

    public CadastroUsuarioDaoImpl() {
        this.funcionarios = new HashSet<>();
    }
    
    @Override
    public boolean autentica(String user, String pass){
        return funcionarios.stream().anyMatch((f) -> (f.getUsuario().equals(user) && f.getSenha().equals(pass)));
    }
    
    @Override
    public boolean salvar(Funcionario funcionario){
        return funcionarios.add(funcionario);
    }
    
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
    
    @Override
    public boolean existeFuncionario(String cpf){
        return funcionarios.stream().anyMatch((f) -> (f.getCpf().equals(cpf)));
    }
    
    @Override
    public Set<Funcionario> listar(){
        return funcionarios;
    }
}
