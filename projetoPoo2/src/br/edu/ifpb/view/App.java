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
        //Verificando se .
        if(usuario.autentica(user, pass)) {
            int opcao;
            System.out.println("Bem vindo(a)!");
            do{
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Adicionar novo funcionario;");
                System.out.println("2 - Atualizar funcionario;");
                System.out.println("3 - Remover funcionario;");
                System.out.println("4 - Listar todos os funcionarios.");
                System.out.println("0 - Sair");
                opcao = ler.nextInt();
            
                switch(opcao){
                    case 1:
                        System.out.println("Adicione um novo funcionário! Insira os dados... ");
                        System.out.println("Nome: ");
                        String nome = ler.next();
                        System.out.println("Cpf: ");
                        String cpf = ler.next();
                        System.out.println("E-mail:");
                        String email = ler.next();
                        System.out.println("Telefone: ");
                        String telefone = ler.next();
                        System.out.println("Dia do nascimento: ");
                        int dia = ler.nextInt();
                        System.out.println("Mês do nascimento: ");
                        int mes = ler.nextInt();
                        System.out.println("Ano do nascimento: ");
                        int ano = ler.nextInt();
                        System.out.println("Setor: ");
                        String setor = ler.next();
                        System.out.println("Usuario: ");
                        String novoUser = ler.next();
                        System.out.println("Senha: ");
                        String novoPass = ler.next();
                        
                        Funcionario f = new Funcionario(nome, cpf, email, telefone, LocalDate.of(ano, mes, dia), setor, novoUser, novoPass);
                        usuario.salvar(f);
                        break;
                    case 2:
                        System.out.println("Insira o cpf do funcionario que deseja atualizar: ");
                        String velhoCpf = ler.next();
                        //verificando se existe algum funcionario com esse cpf.
                        if(usuario.existeFuncionario(velhoCpf)){
                            System.out.println("Atualize o funcionário! Insira os dados... ");
                            System.out.println("Nome: ");
                            String nome2 = ler.next();
                            System.out.println("Cpf: ");
                            String cpf2 = ler.next();
                            System.out.println("E-mail:");
                            String email2 = ler.next();
                            System.out.println("Telefone: ");
                            String telefone2 = ler.next();
                            System.out.println("Dia do nascimento: ");
                            int dia2 = ler.nextInt();
                            System.out.println("Mês do nascimento: ");
                            int mes2 = ler.nextInt();
                            System.out.println("Ano do nascimento: ");
                            int ano2 = ler.nextInt();
                            System.out.println("Setor: ");
                            String setor2 = ler.next();
                            System.out.println("Usuario: ");
                            String novoUser2 = ler.next();
                            System.out.println("Senha: ");
                            String novoPass2 = ler.next();
                            Funcionario f2 = new Funcionario(nome2, cpf2, email2, telefone2, LocalDate.of(ano2, mes2, dia2), setor2, novoUser2, novoPass2);
                            usuario.atualizar(f2, velhoCpf);
                        }else System.err.println("Funcionário inexistente");
                        break;
                    case 3:
                        System.out.println("Digite o cpf do funcionario que deseja remover:");
                        String cpf3 = ler.next();
                        if(usuario.existeFuncionario(cpf3)){
                            usuario.deletar(cpf3);
                            System.out.println("Funcionário deletado!");
                        }else System.err.println("Funcionário inexistente");
                        break;
                    case 4:
                        System.out.println(usuario.listar().toString());
                        break;
                    default:
                        System.out.println("Saindo do sistema...");
                    break;          
                }
            }while(opcao > 0 && opcao < 5);
        }else System.err.println("Usuario ou senha inválido!");
       
    }
}
