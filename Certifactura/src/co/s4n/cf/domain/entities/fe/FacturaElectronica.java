package co.s4n.cf.domain.entities.fe;

import java.util.ArrayList;
import java.util.Date;

import co.s4n.cf.domain.entities.fe.annotations.IdDocumentoElectronico;
import co.s4n.cf.domain.entities.fe.states.eliminada.FacturaConservadaState;
import co.s4n.cf.domain.entities.fe.states.expedida.FacturaExpedidaState;
import co.s4n.cf.infrastructure.mappers.FacturaElectronica2DTO;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.EntityWithStates;
import co.s4n.osp.exceptions.ActualStateException;
import co.s4n.osp.exceptions.BusinessException;
import co.s4n.osp.exceptions.ObserverUpdateFailed;
import co.s4n.osp.state.EntityState;

import com.google.inject.Inject;

/**
 * CertifacturaOSP
 * DocumentoElectronico.java
 * @author yuji
 * Apr 30, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class FacturaElectronica extends EntityWithStates
{
//------------------------------
//        Attributes
//------------------------------
	
	private String idCliente;
	private Date fechaExpedicion;
	private Date fechaConservacion;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 * @param id
	 */
	@Inject	public FacturaElectronica( @IdDocumentoElectronico String id )
	{
		super( id );
	}

//------------------------------
//         Methods
//------------------------------
	
	/**
	 * Desc.
	 */
	public void expedir( )
	{
		System.out.println( "Documento electrónico creado." );
		setState( new FacturaExpedidaState( ) );
	}
	
	/**
	 * Desc.
	 */
	public void conservar( )
	{
		System.out.println( "Documento electrónico eliminado." );
		setState( new FacturaConservadaState( ) );
	}
	
	/**
	 * @return El id del cliente
	 */
	public String getIdCliente( )
	{
		return idCliente;
	}

	/**
	 * @return La fecha de expedición de la factura
	 */
	public Date getFechaExpedicion( )
	{
		return fechaExpedicion;
	}

	/**
	 * @return La fecha de conservación de la factura
	 */
	public Date getFechaConservacion( )
	{
		return fechaConservacion;
	}
	
//------------------------------
//       Private methods
//------------------------------

	/* (non-Javadoc)
	 * @see co.s4n.osp.EntityWithStates#setState(co.s4n.osp.EntityState)
	 */
	protected void setState( EntityState newState ) throws BusinessException
	{
		/* Invariant check */
		if( newState.equals( this.state ) )
			throw new ActualStateException( );
		
		/* Notify the observers */
		try
		{
			ArrayList< DomainEvent > events = getEventFactories( ).get( newState ).getEventsFor( FacturaElectronica2DTO.map( this ) );
			notifyObservers( events );
		}
		catch ( ObserverUpdateFailed e ) 
		{
			e.printStackTrace( );
			ArrayList< DomainEvent > failoverEvents = getEventFactories( ).get( newState ).getFailoverEventsFor( FacturaElectronica2DTO.map( this ) );
			notifyObservers( failoverEvents );
		}
		
		/* If everything runs fine, update the state */
		this.state = newState;
	}
}