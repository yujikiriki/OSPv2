package co.s4n.cf.ifra.mappers;

import co.s4n.cf.domain.entities.fe.FacturaElectronica;
import co.s4n.cf.dtos.FacturaElectronicaDTO;

/**
 * Certifactura
 * FacturaElectronica2DTO.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class FacturaElectronica2DTO
{
//------------------------------
//         Attributes
//------------------------------
	
//------------------------------
//        Constructors
//------------------------------

	/**
	 * Constructor
	 */
	private FacturaElectronica2DTO( )
	{
		super( );
	}

//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @param 
	 * @return
	 */
	public static FacturaElectronicaDTO map( FacturaElectronica fe )
	{
		return new FacturaElectronicaDTO( fe );
	}
	
//------------------------------
//      Private methods
//------------------------------
}
