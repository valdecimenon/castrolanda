package br.coop.castrolanda.farmacia.model;

// java bean
public class Item {

	private static int i = 0;
	private int numero;
	private int qtdeProduto;                                                                                                
	private Produto produto;

	// construtor padrão
	public Item() {

	}

	public Item(Produto produto, int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
		this.produto = produto;
		this.numero = ++i;  // 1  
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQtdeProduto() {
		return qtdeProduto;
	}

	public void setQtdeProduto(int qtdeProduto) {
		this.qtdeProduto = qtdeProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	// regra de negócio
	public float getValorItem() {
		return qtdeProduto * produto.getPrecoUnitario();
	}

}
