package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.util.Arrays;

/**
 *
 * @author Luan
 */
public class CadastroUsuarioDaoImpl implements CadastroUsuarioDao {
    
    private Funcionario[] funcionarios;
    private int quant;

    public CadastroUsuarioDaoImpl() {
    }

    public CadastroUsuarioDaoImpl(Funcionario[] funcionarios, int quant) {
        this.funcionarios = new Funcionario[10];
        this.quant = 0;
    }
    
    public Funcionario autenticar(String usuario, String senha){
        for(int i=0; i<quant; i++){
            if(funcionarios[i].getUsuario().equalsIgnoreCase(usuario) && funcionarios[i].getSenha().equalsIgnoreCase(senha)){
                return funcionarios[i];
            }
        }
        return null;
    }

    @Override
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
    
    public Funcionario buscarPorCpf(String cpf){
        for(int i=0; i<quant; i++){
            if(funcionarios[i].getCpf().equals(cpf)){
                return funcionarios[i];
            }
        }
        return null;
    }

    @Override
    public Funcionario[] listar(){
        return Arrays.copyOfRange(funcionarios, 0, quant);
    }
    
    @Override
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
    
    @Override
    public boolean atualizar(Funcionario funcionario){
        int i = posicaoPorCpf(funcionario.getCpf());

        if(i>=0){
            funcionarios[i] = funcionario;
            return true;
        }else{
            return false;
        }
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Arrays.deepHashCode(this.funcionarios);
        hash = 29 * hash + this.quant;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CadastroUsuarioDaoImpl other = (CadastroUsuarioDaoImpl) obj;
        if (this.quant != other.quant) {
            return false;
        }
        if (!Arrays.deepEquals(this.funcionarios, other.funcionarios)) {
            return false;
        }
        return true;
    }
    
    

}
