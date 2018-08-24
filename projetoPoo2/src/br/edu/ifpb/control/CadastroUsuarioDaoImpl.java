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
    private int quant;

    public CadastroUsuarioDaoImpl() {
        this.funcionarios = new HashSet<>();
        this.quant = 0;
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
    public Object[] listar(){
        return funcionarios.toArray();
    }
}
