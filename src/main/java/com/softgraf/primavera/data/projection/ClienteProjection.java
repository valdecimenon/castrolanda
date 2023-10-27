package com.softgraf.primavera.data.projection;

// isto é uma projeção do Spring Data
public interface ClienteProjection {

	Long getId();
	
	String getNome();
	
	String getEmail();
}
