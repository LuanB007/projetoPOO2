package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
import java.util.Arrays;

/**
 *
 * @author Luan
 */
public class ProdutoDaoImpl implements ProdutoDao {
    private Produto[] produtos;
    private int quant;

    public ProdutoDaoImpl() {
    }

    public ProdutoDaoImpl(Produto[] produtos, int quant) {
        this.produtos = new Produto[10];
        this.quant = 0;
    }

        private void aumentarArray() {
        produtos = Arrays.copyOf(produtos, produtos.length*2);
    }

    private boolean isCheio() {
        return quant == produtos.length;
    }
    
    private int posicaoPorCodigo(long codigo){
        for(int i=0; i<quant;i++){
            if(produtos[i].getCodigo() == codigo ){
                return i;
            }
        }
        return -1;
    }
    
    public Produto buscarPorCodigo(long codigo){
        for(int i=0; i<quant; i++){
            if(produtos[i].getCodigo() == codigo){
                return produtos[i];
            }
        }
        return null;
    }
  
    @Override
    public boolean salvar(Produto produto) {
        if(isCheio()){
            aumentarArray();
        }

        if(buscarPorCodigo(produto.getCodigo()) == null){
            produtos[quant++] = produto;
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Produto[] listar() {
        return Arrays.copyOfRange(produtos, 0, quant);
    }

    @Override
    public boolean excluir(long codigo) {
        int i = posicaoPorCodigo(codigo);

        if(i>=0){
            for(int j=i; j<quant-1;j++){
                produtos[j] = produtos[j+1];
            }
            quant--;
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public boolean atualizar(Produto produto) {
        int i = posicaoPorCodigo(produto.getCodigo());

        if(i>=0){
            produtos[i] = produto;
            return true;
        }else{
            return false;
        }
    }
}
