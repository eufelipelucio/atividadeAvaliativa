
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Atividade {
	private static String FILE = "file.txt";
	private static ProdutoService service = new ProdutoService();
	private static int opcao;
	private static Print menu = new Print();
	
	public static void main(String[] args) {
		String retorno = "";
		menu.bemVindo();
		service.lerArquivo(FILE);

		boolean continuar = true;
		while (continuar) {
			menu.iniciar();
			opcao = new Scanner(System.in).nextInt();
			switch (opcao) {
				case 1: {
					Integer id = Integer.parseInt(generateUniqueId());

					System.out.println("Digite nome do produto: ");
					String descricao = new Scanner(System.in).next();

					System.out.println("Digite o preço do produto: ");
					Double preco = new Scanner(System.in).nextDouble();

					System.out.println("Digite a quantidade em estoque do produto: ");
					Integer estoque = new Scanner(System.in).nextInt();

					Produto produto = new Produto(id, descricao, preco, estoque);
					retorno = service.adicionarProduto(produto);
					menu.retorno(retorno);
					break;
				}
				case 2: {
					System.out.println("Digite o id do produto que deseja editar: ");
					Integer id = new Scanner(System.in).nextInt();

					System.out.println("Digite o novo nome do produto: ");
					String descricao = new Scanner(System.in).next();

					System.out.println("Digite o novo preço do produto: ");
					Double preco = new Scanner(System.in).nextDouble();

					System.out.println("Digite a nova quantidade em estoque do produto: ");
					Integer estoque = new Scanner(System.in).nextInt();

					Produto produto = new Produto(id, descricao, preco, estoque);

					retorno = service.editarProduto(id, produto);
					menu.retorno(retorno);
					break;
				}

				case 3: {
					System.out.println("Digite o nome do produto que deseja excluir: ");
					String nome = new Scanner(System.in).next();
					retorno = service.removerProduto(nome);
					menu.retorno(retorno);
					break;
				}
				case 4: {
					menu.imprimeProdutos(service.listarProdutos());
					break;
				}
				default:
					continuar = false;
					menu.fecharPrograma();
					try {
						FileWriter writer = new FileWriter(FILE);
						for (Produto p : service.listarProdutos()) {
							writer.write(p.toString() + "\n");

						}
						writer.close();
					} catch (IOException e) {

						e.printStackTrace();
					}
					break;
			}

		}

	}

	// Gera id unico
	public static String generateUniqueId() {
		return String.valueOf(1000 + (int) (Math.random() * 9999));
	}
}
