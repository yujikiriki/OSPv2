package co.s4n.osp;

import java.util.ArrayList;

import co.s4n.osp.annotations.InterestingDomainEvents;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.observer.Observer;

import com.google.inject.Inject;

/**
 * Certifactura
 * EntityStateChangeListener.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public abstract class EntityStateChangeListener implements Observer< DomainEvent >
{
//------------------------------
//         Attributes
//------------------------------
	
	@Inject @InterestingDomainEvents private ArrayList< DomainEvent > interestingDomainEvents;
	
//------------------------------
//        Constructors
//------------------------------

	/**
	 * Constructor
	 */
	public EntityStateChangeListener( )
	{
		super( );
	}
	
//------------------------------
//          Methods
//------------------------------
	

	/**
	 * @return The interesting domain events for this listener
	 */
	public ArrayList< DomainEvent > getInterestingDomainEvents( )
	{
		return interestingDomainEvents;
	}
	
	/**
	 * @param domainEvent
	 * @return
	 */
	public Boolean amIInterested( DomainEvent domainEvent )
	{
		for ( DomainEvent interestingDomainEvent : this.interestingDomainEvents )
			if( interestingDomainEvent.isTheSame( domainEvent ) )
				return Boolean.TRUE;

		return Boolean.FALSE;
	}
	
//------------------------------
//      Private methods
//------------------------------
	
}
