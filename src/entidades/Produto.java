package entidades;

public class Produto {

	private String nome;
	private Double valor;
	private Integer quantidade;
	
	public Produto() {
	}
	
	public Produto(String nome, double valor, int quantidade) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Double valorTotal() {
		return this.valor * this.quantidade;
	}
	
	@Override
	public String toString() {
		return this.nome + "," + this.valorTotal();
	}
}
