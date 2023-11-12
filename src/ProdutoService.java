import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoService {
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public String adicionarProduto(Produto produto) {
		try{
			for(Produto p : produtos) {
				if(p.getDescricao().equalsIgnoreCase(produto.getDescricao())) {
					return "Produto já cadastrado";
				}
			}
			produtos.add(produto);
			return "Produto adicionado com Sucesso";
		}catch(Exception e){
			return "Erro ao adicionar o produto";
		}
	}
	
	public String editarProduto(Integer id,Produto novoProduto) {
		int produto = 0;
		for(int i = 0; i < produtos.size();i++) {
			if(produtos.get(i).getId() == id) {
				produto = i;
			}
		}
		System.out.println("posicao prdouto " + produto);
		try{
			produtos.set(produto, novoProduto);
			return "Produto editado com Sucesso";
		}catch(Exception e){
			return "Erro ao editar o produto";
		}
	}
	public String removerProduto(String nome) {
		Produto produto = new Produto();
		for(Produto p : produtos) {
			if(nome.equalsIgnoreCase(produto.getDescricao())) {
				produto = p;
			}
		}
		try{
			produtos.remove(produto);
			return "Produto removido com Sucesso";
		}catch(Exception e){
			return "Erro ao remover produto";
		}
	}
	
	
	public ArrayList<Produto> listarProdutos() {
		return produtos;
	}
	
	public Produto selecionarProduto(int id) {
		return produtos.get(id);
	}
	public void lerArquivo(String arquivo){
		
		File file = new File(arquivo);
		Scanner reader = null;
		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		ArrayList<Produto> produtos = listarProdutos();
		while (reader.hasNextLine()) {
			String linha = reader.nextLine();
			int pI = linha.indexOf("id:");
			int pF = linha.indexOf("descricao:");

			Integer id = Integer.parseInt(linha.substring(pI + 3, pF).trim());
			pI = linha.indexOf("descricao:");
			pF = linha.indexOf("preco:");
			String descricao = linha.substring(pI + 10, pF).trim();
			pI = linha.indexOf("preco:");
			pF = linha.indexOf("estoque:");
			Double preco = Double.parseDouble(linha.substring(pI + 6, pF).trim());
			pI = linha.indexOf("estoque:");
			pF = linha.length();
			Integer estoque = Integer.parseInt(linha.substring(pI + 8, pF).trim());

			Produto produto = new Produto(id, descricao, preco, estoque);
			produtos.add(produto);
		}
	}
	
}
