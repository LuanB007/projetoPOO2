package br.edu.ifpb.view;

import br.edu.ifpb.control.CadastroUsuarioDao;
import br.edu.ifpb.control.CadastroUsuarioDaoImpl;
import br.edu.ifpb.model.Funcionario;
import java.time.LocalDate;

/**
 *
 * @author Luan
 */
public class App {
    public static void main(String[] args){
        
        Funcionario admin = new Funcionario("administrador", "000.000.000-1", "admin@admin.com", "(83)9.0000-0000", LocalDate.of(1997, 2, 1), "gerencia", "usuario", "senha");
        Funcionario admin2 = new Funcionario("administrador2", "000.000.000-2", "admin2@admin.com", "(83)9.0000-0002", LocalDate.of(1994, 5, 15), "gerencia", "usuario2", "senha2");
        
        System.out.println(admin.toString());
        System.out.println(admin2.toString());
        
        System.out.println(admin.equals(admin2));
        
        CadastroUsuarioDao cadastrar = new CadastroUsuarioDaoImpl();
        cadastrar.salvar(admin2);
    }
}
