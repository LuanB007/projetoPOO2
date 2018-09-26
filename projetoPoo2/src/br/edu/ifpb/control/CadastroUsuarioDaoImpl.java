package br.edu.ifpb.control;

import br.edu.ifpb.model.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * Essa classe contém os métodos necessários para fazer o CRUD de usuário(funcionário).
 * @author Luan
 */
public class CadastroUsuarioDaoImpl implements CadastroUsuarioDao {
    
    private File file;
    
    /**
     * Contrutor do arquivo de funcionários.
     */
    public CadastroUsuarioDaoImpl() {
        file = new File("FuncionariosUsuarios");
    }
    
    public boolean existeFuncionario(String cpf) throws IOException, ClassNotFoundException{
        Set<Funcionario> funcionarios = getFuncionarios();
        return funcionarios.stream().anyMatch((f) -> (f.getCpf().equals(cpf)));
    }
    
    /**
     * Método usado para verificar a autenticação do usuário.
     * @param user o usuario
     * @param pass a senha
     * @return true ou false
     */
    @Override
    public boolean autentica(String user, String pass) throws IOException, ClassNotFoundException{
        Set<Funcionario> funcionarios = getFuncionarios();
        return funcionarios.stream().anyMatch((f) -> (f.getUsuario().equals(user) && f.getSenha().equals(pass)));
    }
    
    /**
     * Método usado para salvar o funcionário na lista.
     * @param funcionario objeto funcionário.
     * @return true ou false
     */
    @Override
    public boolean salvar(Funcionario funcionario) throws IOException, ClassNotFoundException{
        Set<Funcionario> funcionarios = getFuncionarios();
        
        if(funcionarios.add(funcionario)){
            atualizarArquivo(funcionarios);
            return true;
        } else return false;
    }
        
    /**
     * Método usado para deletar um funcionário.
     * @param cpf CPF do funcionário.
     * @return true ou false
     */
    @Override
    public boolean deletar(String cpf) throws IOException, ClassNotFoundException{
        Set<Funcionario> funcionarios = getFuncionarios();
        for(Funcionario f : funcionarios){
            if(f.getCpf().equals(cpf)){
                funcionarios.remove(f);
                atualizarArquivo(funcionarios);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que atualiza os dados de um funcionário já presente na lista.
     * @param funcionario objeto funcionário com as informações atualizadas.
     * @param cpf CPF do funcionário.
     * @return 
     */
    @Override
    public boolean atualizar(Funcionario funcionario, String cpf) throws IOException, ClassNotFoundException {
        Set<Funcionario> funcionarios = getFuncionarios();
        for (Funcionario f: funcionarios){
            if(f.getCpf().equals(cpf)){
                funcionarios.remove(f);
                funcionarios.add(funcionario);
                atualizarArquivo(funcionarios);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Set<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))){
            if(file.length()>0){
                return (Set<Funcionario>) in.readObject();
            }else{
                return new HashSet<>();
            }
        }
    }
    
    private void atualizarArquivo(Set<Funcionario> funcionarios) throws IOException {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(funcionarios);
            } 
    }
}
