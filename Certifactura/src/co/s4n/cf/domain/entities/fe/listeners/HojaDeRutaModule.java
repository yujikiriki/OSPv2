package co.s4n.cf.domain.entities.fe.listeners;

import java.util.ArrayList;

import co.s4n.cf.domain.entities.fe.FacturaElectronica;
import co.s4n.cf.domain.entities.fe.states.expedida.events.FacturaExpedidaEvent;
import co.s4n.osp.annotations.InterestingDomainEvents;
import co.s4n.osp.events.DomainEvent;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * Certifactura
 * HojaDeRutaModule.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class HojaDeRutaModule extends AbstractModule
{
//------------------------------
//         Attributes
//------------------------------
//------------------------------
//        Constructors
//------------------------------
//------------------------------
//          Methods
//------------------------------
	
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override protected void configure( )
	{
	}
	
//------------------------------
//      Provide methods
//------------------------------

	/**
	 * @return The {@link FacturaElectronica} observers
	 */
	@Provides @InterestingDomainEvents ArrayList< DomainEvent > provideInterestingEvents( )
	{
		ArrayList< DomainEvent > observers = new ArrayList< DomainEvent >( );
		observers.add( new FacturaExpedidaEvent( "FacturaExpedidaEvent" ) );
		return observers;
	}
}
