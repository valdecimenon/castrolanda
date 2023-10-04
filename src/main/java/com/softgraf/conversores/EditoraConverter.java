package com.softgraf.conversores;

import com.softgraf.entity.Editora;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

@FacesConverter(value = "editoraConverter", forClass = Editora.class)
public class EditoraConverter implements Converter<Long>{

	/*
	 * quando o botão salvar é clicado esta função é chamada recebendo uma String
	 * contendo o id da Editora selecionada que será convertido em Long
	 */
	@Override
	public Long getAsObject(FacesContext context, UIComponent component, String id) {
		if (id != null) {
			System.out.println("Função getAsObject() = " + id);
			return Long.parseLong(id);
		}
		
		return null;
	}

	/*
	 * quando a lista de editoras é carregada, o id de cada Editora será salvo no próprio
	 * componente p:selectOneMenu, para ser recuperado quando o botão Salvar for clicado
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Long id) {
		if (id != null) {
			System.out.println("Função getAsString() = " + id);
			return id.toString();
		}
		
		return null;
	}

}
