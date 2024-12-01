package dao;

// Todas as bibliotecas
import model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("produtoPU");
	
	// Método sem retorno que cria um produto novo
	public void criar(Produto produto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	// Método que mostra os produtos criados
	public Produto ler(long id) {
		EntityManager em = emf.createEntityManager();
		Produto produto = em.find(Produto.class, id);
		em.close();
		return produto;
	}
	
	// Cria uma lista e consegue chamar para mostrar na tabela
	public List<Produto> ListarTodos() {
		EntityManager em = emf.createEntityManager();
		List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
		em.close();
		return produtos;
	}
	
	// Atualizar informação relacionado ao produto
	public void atualizar (Produto produto) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(produto);
		em.getTransaction().commit();
		em.close();
	}
	
	// Excluir algum produto
	public void excluir (Long id) {
		EntityManager em = emf.createEntityManager();
		Produto produto = em.find(Produto.class, id);
		if(produto != null) {
			em.getTransaction().begin();
			em.remove(produto);
			em.getTransaction().commit();
		}
		em.close();
	}
}
