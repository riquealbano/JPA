package Main;

// Importa as 2 outras classes de outros 2 pacotes
import dao.ProdutoDao;
import model.Produto;

// Biblioteca utilizada
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		ProdutoDao produtoDao = new ProdutoDao();
		Scanner scanner = new Scanner (System.in);
		
		String continuar = "sim";
		while (continuar.equalsIgnoreCase("sim")) {
			
			// Cria um novo produto e o atribui um nome
			Produto produto = new Produto();
			System.out.print("Digite o nome do produto: ");
			produto.setNome(scanner.nextLine());
			
			// Instancia o preço do produto com nomeado
			System.out.print("Digite o nome do produto: ");
			produto.setPreco(scanner.nextDouble());
			scanner.nextLine();
			
			produtoDao.criar(produto);
			
			// Caso responda sim, o laço while irá se repetir mais uma vez
			// Assim cadastrando mais um produto até que a resposta seja diferente de "sim"
			System.out.print("Deseja adicionar outro produto? (sim/não): 	");
			continuar = scanner.nextLine();
		}
		
		// Ao fim ele lista todos os itens cadastrados
		System.out.print("\nLista de produtos no banco de dados: ");
		produtoDao.ListarTodos().forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco()));
		
		scanner.close();
	}
}
