package com.example.demo.model.request;

import com.example.demo.commons.utils.InvalidInputException;

public class UpdateDTO {
	
	 private String id;
	
	private String referencia;
	private String estatus;
	public UpdateDTO() {
	}
	public UpdateDTO(String id, String referencia, String estatus) {
	
		this.id = id;
		this.referencia = referencia;
		this.estatus = estatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	
	
       
}

