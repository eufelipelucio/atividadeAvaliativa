import java.util.ArrayList;

public class Print {
	
	public void bemVindo() {
		System.out.println("---------Bem-Vindo-------");	
		System.out.println();
	}
	
	public void iniciar() {
		System.out.println();
		System.out.println("-----------Menu----------");
		System.out.println("----- DIGITE SUA OPÇÃO --");
		System.out.println("1 -> ADICIONAR PRODUTO --");
		System.out.println("2 -> EDITAR PRODUTO -----");
		System.out.println("3 -> EXCLUI PRODUTO -----");
		System.out.println("4 -> LISTAR PRODUTOS ----");
		System.out.println("5 -> FINALIZAR PROGRAMA -");
	}
	public void imprimeProduto(Produto produtoSelecionado) {
        System.out.println("Nome do produto selecionado : " +  produtoSelecionado.getDescricao() );
        System.out.println("Preço do produto selecionado : " + produtoSelecionado.getPreco());
        System.out.println("Estoque do produto selecionado : " + produtoSelecionado.getPreco());
        System.out.println("-------------------------");
        System.out.println();
	}
	public void imprimeProdutos(ArrayList<Produto> produtos){
        System.out.println("----Lista De Produtos----");
        for(int i = 0; i < produtos.size();i++) {
        	System.out.println("Id: " + produtos.get(i).getId());
            System.out.println("Nome: " + produtos.get(i).getDescricao());
            System.out.println("Valor: " + produtos.get(i).getPreco());
            System.out.println("Estoque: " + produtos.get(i).getEstoque());
            System.out.println("-------------------------");
        }
        System.out.println();
    }
	 public void fecharPrograma(){
	        System.out.println("Programa Encerrado");
	    }
	public void retorno(String retorno) {
		System.out.println(retorno);
		System.out.println("-------------------------");
	}
}
