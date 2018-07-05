package com.bcp.teletransfer.entity;

import lombok.Data;

public @Data class Usuario {
	
	private String chrCodigoUsuario;
	private String vchNombreUsuario;	
	private String vchDireccion;
	private String vchFrecuenciaUso;
	private String vchTelefono;
	private String vchFax;
	private String vchResponsable;
	private String vchEMail;
	private String chrTipoDocIdentidad;
	private String chrDocumento;
	private String vchProvincia;
	private String vchDistrito;
	private String vchDepartamento;	
	private String intVolumenPromedio;
		 	
}
