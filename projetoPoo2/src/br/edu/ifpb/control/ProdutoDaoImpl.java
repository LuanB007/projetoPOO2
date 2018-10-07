package br.edu.ifpb.control;

import br.edu.ifpb.model.Produto;
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
 * Essa classe contém os métodos necessários para fazer o CRUD de produtos.
 * @author Luan
 */
public class ProdutoDaoImpl implements ProdutoDao {
    
    private File file;
    
    /**
     * Contrutor da lista de produtos.
     */
    public ProdutoDaoImpl() {
         file = new File("Produtos");
         
        if(!file.exists()) try {
            file.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CadastroUsuarioDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método usado para cadastrar o produto.
     * @param produto objeto produto.
     * @return true ou false.
     */
    @Override
    public boolean salvar(Produto produto) throws IOException, ClassNotFoundException {
        Set<Produto> produtos = getProdutos();
        if(produtos.add(produto)){
            atualizarArquivo(produtos);
            return true;
        } else return false;
    }
    
    /**
     * Método usado para remover um produto existente.
     * @param codigo código do produto cadastrado.
     * @return true ou false.
     */
    @Override
    public boolean deletar(long codigo) throws IOException, ClassNotFoundException{
        Set<Produto> produtos = getProdutos();
        for(Produto p : produtos){
            if(p.getCodigo() == codigo){
                produtos.remove(p);
                atualizarArquivo(produtos);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método utilizado para atualizar um produto existente.
     * @param produto o objeto produto com as informações atualizadas.
     * @param codigo código do produto cadastrado.
     * @return true ou false.
     */
    @Override
    public boolean atualizar(Produto produto, long codigo) throws IOException, ClassNotFoundException {
        Set<Produto> produtos = getProdutos();
        
        for (Produto p: produtos){
            if(p.getCodigo() == codigo){
                produtos.remove(p);
                produtos.add(produto);
                atualizarArquivo(produtos);
                return true;
            }
        }
        return false;
    }
    
    /**
     * Método que verifica se o produto está cadastrado.
     * @param codigo código do produto.
     * @return true ou false.
     */
    @Override
    public boolean existeProduto(long codigo) throws IOException, ClassNotFoundException {
        Set<Produto> produtos = getProdutos();
        return produtos.stream().anyMatch((p) -> (p.getCodigo() == codigo));
    }
    
    /**
     * Método utilizado para listar todos os produtos cadastrados.
     * @return uma lista de produtos.
     */
    @Override
    public Set<Produto> getProdutos() throws IOException, ClassNotFoundException {
            if(file.length()>0){
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                return (Set<Produto>) in.readObject();
            }else{
                return new HashSet<>();
            }
    }
    
    private void atualizarArquivo(Set<Produto> produtos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(produtos);
    }
}
