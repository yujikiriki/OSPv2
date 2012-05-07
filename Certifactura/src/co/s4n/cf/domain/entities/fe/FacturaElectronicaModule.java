package co.s4n.cf.domain.entities.fe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import co.s4n.cf.domain.entities.fe.annotations.IdDocumentoElectronico;
import co.s4n.cf.domain.entities.fe.states.eliminada.FacturaConservadaState;
import co.s4n.cf.domain.entities.fe.states.expedida.FacturaElectronicaExpedidaFactory;
import co.s4n.cf.domain.entities.fe.states.expedida.FacturaExpedidaState;
import co.s4n.osp.annotations.EventFactory;
import co.s4n.osp.annotations.Observers;
import co.s4n.osp.annotations.PossibleStates;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.observer.Observer;
import co.s4n.osp.state.EntityState;
import co.s4n.osp.state.StateEventsFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

/**
 * CertifacturaOSP
 * DocumentoElectronicoModule.java
 * @author yuji
 * Apr 30, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class FacturaElectronicaModule extends AbstractModule
{
	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override protected void configure( )
	{
//		bind( EntityState.class ).to( FacturaExpedidaState.class );
	}

	/**
	 * @return The unique id for the {@link FacturaElectronica}
	 */
	@Provides @IdDocumentoElectronico String provideDocumentoElectronicoId( )
	{
		return UUID.randomUUID( ).toString( );
	}
		
	/**
	 * @return The possible {@link EntityState}s for {@link FacturaElectronica}
	 */
	@Provides @PossibleStates ArrayList< EntityState > providePossibleStates( )
	{
		ArrayList< EntityState > possibleStates = new ArrayList< EntityState >( );
		possibleStates.add( new FacturaExpedidaState( ) );
		possibleStates.add( new FacturaConservadaState( ) );
		return possibleStates;
	}
	
	@Provides @EventFactory HashMap< EntityState, StateEventsFactory > provideEventFactories( )
	{
		HashMap< EntityState, StateEventsFactory > factories = new HashMap< EntityState, StateEventsFactory >( );
		factories.put( new FacturaExpedidaState( ) , new FacturaElectronicaExpedidaFactory( ) );
		return factories;
	}
	
	/**
	 * @return The {@link FacturaElectronica} observers
	 */
	@Provides @Observers ArrayList< Observer< DomainEvent > > provideObservers( )
	{
		return new ArrayList< Observer< DomainEvent > >( );
	}
}
