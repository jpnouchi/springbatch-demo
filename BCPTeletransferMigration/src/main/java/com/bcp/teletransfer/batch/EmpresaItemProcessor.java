package com.bcp.teletransfer.batch;

import static com.bcp.teletransfer.entity.Constant.countryPeru;
import static com.bcp.teletransfer.entity.Constant.space;
import static com.bcp.teletransfer.entity.Constant.statusActive;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;

import com.bcp.teletransfer.entity.Usuario;
import com.primeur.bcp.teletransfer.common.model.Company;

import lombok.val;

public class EmpresaItemProcessor implements ItemProcessor<Usuario,Company>{

	private static Map<String,String> mapDocType;

	static{
		mapDocType= new HashMap<String,String>();
		mapDocType.put("C","CE");
		mapDocType.put("B","CI");
		mapDocType.put("A","LE");
		mapDocType.put("D","PA");
		mapDocType.put("L","20");
	}
	
	public Company process(Usuario item) throws Exception {
		// TODO Auto-generated method stub
		val company = new Company();
		company.setCompanyCode(item.getChrCodigoUsuario());
		company.setCompanyName(item.getVchNombreUsuario());
		company.setDescription(item.getVchNombreUsuario());
		company.setCompanyAddress(item.getVchDireccion());
		company.setOfficeHours(item.getVchFrecuenciaUso());
		company.setTelephone(item.getVchTelefono());
		company.setFax(item.getVchFax());
		company.setResponsible(item.getVchResponsable());
		company.setResponsibleEmail(item.getVchEMail());
		company.setDocType(mapDocType.get(item.getChrTipoDocIdentidad()));
		company.setDocValue(item.getChrDocumento());
		company.setProvince(item.getVchProvincia());
		company.setDistrict(item.getVchDistrito());
		company.setDepartment(item.getVchDepartamento());
		company.setUseFrequency(item.getVchFrecuenciaUso());
		company.setAverageSentVol(item.getIntVolumenPromedio());
		
		company.setCountry(countryPeru);
		company.setStatus(statusActive);
		company.setContingency(true);
		company.setTechnicalResponsible(space);
		company.setTechnicalResponsibleEmail(space);
		return company;
	}

	
}
