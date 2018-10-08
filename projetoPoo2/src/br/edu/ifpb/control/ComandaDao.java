package br.edu.ifpb.control;

import br.edu.ifpb.model.Comanda;
import java.util.Set;

/**
 *
 * @author Luan
 */
public interface ComandaDao {
    
    public boolean salvarComanda(Comanda comanda);
    public boolean atualizarComanda(Comanda novaComanda, int mesaVelha);
    public boolean removerComanda(int mesa);
     public Set<Comanda> getComandas();
}
