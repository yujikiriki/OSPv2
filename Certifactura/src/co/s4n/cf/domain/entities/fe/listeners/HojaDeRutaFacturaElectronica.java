package co.s4n.cf.domain.entities.fe.listeners;

import java.util.ArrayList;

import co.s4n.cf.domain.entities.fe.states.expedida.events.FacturaExpedidaEvent;
import co.s4n.osp.EntityStateChangeListener;
import co.s4n.osp.events.DomainEvent;

/**
 * Certifactura
 * HojaDeRutaFacturaElectronica.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class HojaDeRutaFacturaElectronica extends EntityStateChangeListener
{
//------------------------------
//         Attributes
//------------------------------
	
//------------------------------
//        Constructors
//------------------------------

	/**
	 * @param interestingDomainEvents
	 */
	public HojaDeRutaFacturaElectronica( )
	{
		super( );
	}

//------------------------------
//          Methods
//------------------------------
	
	/* (non-Javadoc)
	 * @see co.s4n.osp.observer.Observer#update()
	 */
	@Override public void update( )
	{
		throw new UnsupportedOperationException( );
	}
	
	/* (non-Javadoc)
	 * @see co.s4n.osp.observer.Observer#update(java.util.ArrayList)
	 */
	@Override public void update( ArrayList< DomainEvent > events )
	{
		for ( DomainEvent domainEvent : events )
		{
			if( amIInterested( domainEvent ) )
				System.out.println( ( ( FacturaExpedidaEvent ) domainEvent ).getDto( ) );
				System.out.println( "HojaDeRutaFacturaElectronica ejecuta su función." );
		}
	}
	
//------------------------------
//      Private methods
//------------------------------

}
