package co.s4n.osp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.s4n.osp.annotations.EventFactory;
import co.s4n.osp.annotations.PossibleStates;
import co.s4n.osp.events.DomainEvent;
import co.s4n.osp.exceptions.BusinessException;
import co.s4n.osp.observer.Observable;
import co.s4n.osp.state.EntityState;
import co.s4n.osp.state.StateEventsFactory;

import com.google.common.base.Objects;
import com.google.inject.Inject;

/**
 * CertifacturaOSP
 * EntityWithStates.java
 * @author yuji
 * May 1, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public abstract class EntityWithStates extends Observable< DomainEvent >
{
//------------------------------
//        Attributes
//------------------------------
	
	protected String id;
	protected EntityState state;
	@Inject @PossibleStates private ArrayList< EntityState > states;
	@Inject @EventFactory private HashMap< EntityState, StateEventsFactory > eventFactory;
	
//------------------------------
//        Constructors
//------------------------------

	/**
	 * Constructor
	 */
	public EntityWithStates( String id )
	{
		super( );
		this.id = id;
	}

//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @return The unique id
	 */
	public String getId( )
	{
		return id;
	}
	
	/**
	 * @param The valid states for this entity
	 */
	public void setPossibleStates( ArrayList< EntityState > states )
	{
		this.states = states;
	}
	
	/**
	 * @return The valid entity states
	 */
	public List< EntityState > getPossibleStates( )
	{
		return states;
	}

	/**
	 * @return The actual state of the entity
	 */
	public EntityState getState( )
	{
		return state;
	}
	
	/**
	 * @return the eventFactory
	 */
	public HashMap< EntityState, StateEventsFactory > getEventFactories( )
	{
		return eventFactory;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode()
	{
		return Objects.hashCode( id );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals( Object obj )
	{
		if( obj instanceof EntityWithStates )
		{
			final EntityWithStates other = ( EntityWithStates  ) obj;
			return Objects.equal( id, other.id ) &&
				Objects.equal( state, other.state ) &&
				Objects.equal( states, other.states );
		}
		return Boolean.FALSE;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString( )
	{
		return Objects.toStringHelper( this )
			.add( "Id: ", id )
			.add( "Actual state: ", state )
			.add( "States: ", states )
			.toString( );
	}	

//------------------------------
//       Private methods
//------------------------------
	
	/**
	 * @return The actual state of the entity.
	 * @throws BusinessException if the states is already set in the newState
	 */
	protected abstract void setState( EntityState newState ) throws BusinessException;

}





