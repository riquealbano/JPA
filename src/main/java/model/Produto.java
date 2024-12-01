package model;

// Bibliotecas utilizadas
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
	@Id // entidade de Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera um valor de identidade (Id)
	private Long id;
	private String nome;
	private Double preco;
	
	
	// Todos os gets e sets
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	
	public void setPreco(Double preco) {
		this.preco = preco;
	}
}
