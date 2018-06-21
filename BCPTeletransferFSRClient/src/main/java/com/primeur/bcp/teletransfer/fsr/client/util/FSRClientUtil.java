package com.primeur.bcp.teletransfer.fsr.client.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.primeur.bcp.teletransfer.common.util.ParseUtil;
import com.primeur.spmfts.filebox.domain.MetadataValue;

public class FSRClientUtil {
	
	public static MetadataValue createMetadataValue(String metadataName, String value){
		MetadataValue metadataValue = new MetadataValue();
		metadataValue.setMetadataName(metadataName);
		metadataValue.setValue(value);
		return metadataValue;
	}
	
	public static MetadataValue createMetadataValue(String metadataName, Date dateValue, SimpleDateFormat format){
		MetadataValue metadataValue = new MetadataValue();
		metadataValue.setMetadataName(metadataName);
		metadataValue.setValue(ParseUtil.dateToString(dateValue, format));
		return metadataValue;
	}
	
	public static MetadataValue createMetadataValue(String metadataName, char value){
		MetadataValue metadataValue = new MetadataValue();
		metadataValue.setMetadataName(metadataName);
		metadataValue.setValue(value);
		return metadataValue;
	}
	
	public static MetadataValue createMetadataValue(String metadataName, int value){
		MetadataValue metadataValue = new MetadataValue();
		metadataValue.setMetadataName(metadataName);
		metadataValue.setValue(value);
		return metadataValue;
	}
}
