package model.entity;

public class Produto {
	

	private int id;
	private String nome;
	private float preco;
	private short codigo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public short getCodigo() {
		return codigo;
	}
	public void setCodigo(short codigo) {
		this.codigo = codigo;
	}
	public Produto(String nome, float preco, short codigo) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.codigo = codigo;
	}
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", codigo=" + codigo + "]";
	}
	
}


	
