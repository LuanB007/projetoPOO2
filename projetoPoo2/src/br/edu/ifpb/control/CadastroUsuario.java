package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.util.Arrays;

/**
 *
 * @author Luan
 */
public class CadastroUsuario {
    private Funcionario[] funcionarios;
    private int quant;
    private String usuario;
    private String senha;

    public CadastroUsuario(Funcionario[] funcionarios, int quant, String usuario, String senha) {
        this.funcionarios = new Funcionario[10];
        this.quant = 0;
        this.usuario = usuario;
        this.senha = senha;
    }
    
    private void aumentarArray() {
        funcionarios = Arrays.copyOf(funcionarios, funcionarios.length*2);
    }

    private boolean isCheio() {
        return quant == funcionarios.length;
    }
    
    private int posicaoPorCpf(String cpf){
        for(int i=0; i<quant;i++){
            if(funcionarios[i].getCpf().equals(cpf)){
                return i;
            }
        }
        return -1;
    }
    
    public Funcionario buscarPorCpf(String cpf){
        for(int i=0; i<quant; i++){
            if(funcionarios[i].getCpf().equalsIgnoreCase(cpf)){
                return funcionarios[i];
            }
        }
        return null;
}

public boolean salvar(Funcionario funcionario){

        if(isCheio()){
            aumentarArray();
        }

        if(buscarPorCpf(funcionario.getCpf()) == null){
            funcionarios[quant++] = funcionario;
            return true;
        }else{
            return false;
        }
    }

    
    public Funcionario[] listar(){
        return Arrays.copyOfRange(funcionarios, 0, quant);
    }
    
    public void atualizar(Funcionario funcionario){
        //falta
    }
    
    public boolean excluir(String cpf){
        int i = posicaoPorCpf(cpf);

        if(i>=0){
            for(int j=i; j<quant-1;j++){
                funcionarios[j] = funcionarios[j+1];
            }
            quant--;
            return true;
        }else{
            return false;
        }
    }

}
