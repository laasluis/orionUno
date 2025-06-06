package com.example.demo.model.request;

import com.example.demo.commons.utils.InvalidInputException;

public class UserDTO {
	
	 private String operacion;
	
	private String importe;
	private String cliente;
	private String secreto;
	
	
	public UserDTO() {
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		if (operacion == null || !operacion.matches("[a-zA-Z]+")) {
            throw new InvalidInputException("Error los datos de operacion deben de ser carcteres.");
        }

		this.operacion = operacion;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		 if (importe == null || !importe.matches("\\d+(\\.\\d{1,2})?")) {
	            throw new InvalidInputException("El importe debe ser numerico");
	        }
		this.importe = importe;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		 if (cliente == null || !cliente.matches("[a-zA-Z]+")) {
	            throw new InvalidInputException("Error los datos de cliente deben de ser carcteres.");
	        }
		this.cliente = cliente;
	}
	public String getSecreto() {
		return secreto;
	}
	public void setSecreto(String secreto) {
		this.secreto = secreto;
	}
    
       
}

