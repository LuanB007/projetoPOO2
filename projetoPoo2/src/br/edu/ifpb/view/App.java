package br.edu.ifpb.view;

import br.edu.ifpb.control.CadastroUsuarioDao;
import br.edu.ifpb.control.CadastroUsuarioDaoImpl;
import br.edu.ifpb.model.Funcionario;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Luan
 */
public class App {
    public static void main(String[] args){
        //para teste
        Funcionario admin = new Funcionario("administrador", "000.000.000-1", "admin@admin.com", "(83)9.0000-0000", LocalDate.of(1997, 2, 1), "gerencia", "usuario", "senha");
        Funcionario admin2 = new Funcionario("administrador2", "000.000.000-2", "admin2@admin.com", "(83)9.0000-0002", LocalDate.of(1994, 5, 15), "gerencia", "usuario2", "senha2");
        CadastroUsuarioDao usuario = new CadastroUsuarioDaoImpl();
        usuario.salvar(admin2);
        usuario.salvar(admin);
        Scanner ler = new Scanner(System.in); 
        //login. Iniciando Sistema.
        System.out.println("Digite o usuario:");
        String user = ler.next();
        System.out.println("Digite a senha:");
        String pass = ler.next();
        //Verificando se o usuário pertence aos funcionarios da lista.
        if(usuario.autentica(user, pass)) {
            System.out.println("bem vindo!");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar novo funcionario;");
            System.out.println("2 - Atualizar funcionario;");
            System.out.println("3 - Remover funcionario;");
            System.out.println("4 - Listar todos os funcionarios.");
            System.out.println("0 - Sair");
        }else System.out.println("Usuario ou senha inválido!");
       
    }
}
