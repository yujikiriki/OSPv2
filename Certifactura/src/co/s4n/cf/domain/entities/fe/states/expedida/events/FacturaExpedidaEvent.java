package co.s4n.cf.domain.entities.fe.states.expedida.events;

import co.s4n.cf.dtos.FacturaElectronicaDTO;
import co.s4n.osp.events.DomainEvent;


/**
 * Certifactura
 * FacturaExpedidaEvent.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class FacturaExpedidaEvent extends DomainEvent
{
//------------------------------
//         Attributes
//------------------------------
	
	private FacturaElectronicaDTO dto;

//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * @param name
	 */
	public FacturaExpedidaEvent( String name )
	{
		super( name );
	}

	/**
	 * @param dto
	 */
	public FacturaExpedidaEvent( FacturaElectronicaDTO dto )
	{
		super( "FacturaExpedidaEvent" );
		this.dto = dto;
	}
	
//------------------------------
//          Methods 
//------------------------------
	
	/**
	 * @return
	 */
	public FacturaElectronicaDTO getDto( )
	{
		return dto;
	}
}
