package com.softgraf.primavera.data.dto;

import com.softgraf.primavera.entity.Produto;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

//DTO = Transfer Data Object = objeto para transferência de dados
// é uma classe somente leitura
public record ProdutoRecordDTO(
		
		@NotBlank(message = "Descrição do produto é obrigatório") 
		String descricao, 
		
		@DecimalMin(value = "0.0", inclusive = false, message = "Preço abaixo do mínimo")
		@DecimalMax(value = "9999.0", message = "Preço acima do máximo")
		Float preco, 
		
		@NotNull(message = "Quantidade é obrigatório")
		@Min(1)
		@Max(9999)
		Integer quantidade, 
		
		String urlImagem
) {

	
	// converte ProdutoRecordDTO em Produto Entity
	public Produto  toProduto() {
		return new Produto(descricao, preco, quantidade, urlImagem);
	}
	
}
