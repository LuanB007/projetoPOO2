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
    public boolean deletar(Funcionario funcionario){
        return funcionarios.remove(funcionario);
    }
    
    @Override
    public boolean atualizar(Funcionario funcionario){
        if(deletar(funcionario)) return salvar(funcionario);
        else return false;
    }
    
    @Override
    public Set<Funcionario> listar(){
        return funcionarios;
    }
}
