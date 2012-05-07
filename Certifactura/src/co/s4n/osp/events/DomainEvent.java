package co.s4n.osp.events;

import java.util.Calendar;
import java.util.Date;

import com.google.common.base.Objects;

import co.s4n.osp.observer.IMessage;

/**
 * CertifacturaOSP
 * DomainEvent.java
 * @author yuji
 * May 1, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public abstract class DomainEvent implements IMessage
{
//------------------------------
//        Attributes
//------------------------------
	
	private Date occured;
	private Date notified;
	private String name;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public DomainEvent( String name )
	{
		super( );
		this.occured = Calendar.getInstance( ).getTime( );
		this.name = name;
	}
	
//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @return
	 */
	public String getName( )
	{
		return name;
	}
	
	/**
	 * @return
	 */
	public Date getOccured( )
	{
		return occured;
	}

	/**
	 * @return
	 */
	public Date getNotified( )
	{
		return notified;
	}

	/**
	 * @param notified
	 */
	public void setNotified( Date notified )
	{
		this.notified = notified;
	}

	/**
	 * @param otherEvent
	 * @return
	 */
	public boolean isTheSame( DomainEvent otherEvent )
	{
		return otherEvent.name.equals( this.name );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode()
	{
		return Objects.hashCode( occured, notified );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals( Object obj )
	{
		if( obj instanceof DomainEvent )
		{
			final DomainEvent other = ( DomainEvent ) obj;
			return Objects.equal( occured, other.occured ) &&
				Objects.equal( notified, other.notified );
		}
		return Boolean.FALSE;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString( )
	{
		return Objects.toStringHelper( this )
			.add( "Occured: ", occured )
			.add( "Notified: ", notified )
			.toString( );
	}

//------------------------------
//       Private methods
//------------------------------

}




