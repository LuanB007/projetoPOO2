/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.control;

import br.edu.ifpb.model.Comanda;
import br.edu.ifpb.model.Funcionario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luan
 */
public class ComandaDaoImpl implements ComandaDao {
    
    private File file;
    
    public ComandaDaoImpl(){
        file = new File("Comandas");
        
        if(!file.exists()) try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CadastroUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean existeComanda(int mesa) throws IOException, ClassNotFoundException{
        Set<Comanda> comandas = getComandas();
        return comandas.stream().anyMatch((c) -> (c.getNumMesa() == mesa));
    }
    
    @Override
    public boolean salvarComanda(Comanda comanda)  throws IOException, ClassNotFoundException{
        Set<Comanda> comandas = getComandas();
        int mesa = comanda.getNumMesa();
        if(existeComanda(mesa)) return false;
        else if(comandas.add(comanda)){
            atualizarArquivo(comandas);
            return true;
        } else return false;
    }
    
    @Override
    public boolean atualizarComanda(Comanda novaComanda, int mesaVelha)  throws IOException, ClassNotFoundException {
        Set<Comanda> comandas = getComandas();
        for (Comanda c: comandas){
            if(c.getNumMesa() == mesaVelha){
                comandas.remove(c);
                comandas.add(novaComanda);
                atualizarArquivo(comandas);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean removerComanda(int mesa) throws IOException, ClassNotFoundException{
        Set<Comanda> comandas = getComandas();
        for(Comanda c : comandas){
            if(c.getNumMesa() == mesa){
                comandas.remove(c);
                atualizarArquivo(comandas);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public Set<Comanda> getComandas() throws IOException, ClassNotFoundException{
        if(file.length()>0){
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            return (Set<Comanda>) in.readObject();
        }else{
            return new HashSet<>();
        }
    }
    
    private void atualizarArquivo(Set<Comanda> comandas) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(comandas);
    }
}
