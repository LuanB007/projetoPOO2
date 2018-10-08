package br.edu.ifpb.control;

import br.edu.ifpb.model.Comanda;
import java.io.IOException;
import java.util.Set;

/**
 *
 * @author Luan
 */
public interface ComandaDao {
    
    public boolean existeComanda(int mesa) throws IOException, ClassNotFoundException;
    public boolean salvarComanda(Comanda comanda)  throws IOException, ClassNotFoundException;
    public boolean atualizarComanda(Comanda novaComanda, int mesaVelha)  throws IOException, ClassNotFoundException;
    public boolean removerComanda(int mesa) throws IOException, ClassNotFoundException;
     public Set<Comanda> getComandas() throws IOException, ClassNotFoundException;
}
