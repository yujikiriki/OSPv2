package co.s4n.cf.domain.entities.fe.states.expedida;

import java.util.ArrayList;

import co.s4n.cf.domain.entities.fe.states.expedida.events.FacturaExpedidaEvent;
import co.s4n.cf.domain.entities.fe.states.expedida.events.FacturaExpedidaFOEvent;
import co.s4n.osp.dto.DataTransferObject;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.state.EntityState;
import co.s4n.osp.state.StateEventsFactory;

/**
 * CertifacturaOSP
 * FacturaElectronicaEventFactory.java
 * @author yuji
 * May 4, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class FacturaElectronicaExpedidaFactory implements StateEventsFactory
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
	public FacturaElectronicaExpedidaFactory( )
	{
		super( );
	}

//------------------------------
//          Methods 
//------------------------------
	
	/* (non-Javadoc)
	 * @see co.s4n.osp.state.StateEventsFactory#getEventsFor(co.s4n.cf.dtos.DataTransferObject)
	 */
	@Override public ArrayList< DomainEvent > getEventsFor( EntityState entityState, DataTransferObject facturaElectronicaDTO )
	{
		ArrayList< DomainEvent > events = new ArrayList< DomainEvent >( );
		events.add( new FacturaExpedidaEvent( facturaElectronicaDTO ) );
		return events;
	}

	/* (non-Javadoc)
	 * @see co.s4n.osp.state.StateEventsFactory#getFailoverEventsFor(co.s4n.cf.dtos.DataTransferObject)
	 */
	@Override public ArrayList< DomainEvent > getFailoverEventsFor( EntityState entityState, DataTransferObject facturaElectronicaDTO )
	{
		ArrayList< DomainEvent > failOverevents = new ArrayList< DomainEvent >( );
		failOverevents.add( new FacturaExpedidaFOEvent( ) );
		return failOverevents;
	}

//------------------------------
//      Private methods
//------------------------------
	
}
