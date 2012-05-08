/**
 * 
 */
package co.s4n.osp.observer;

import java.util.ArrayList;

import co.s4n.osp.annotations.Observers;
import co.s4n.osp.exceptions.BusinessException;

import com.google.inject.Inject;

/**
 * Certifactura
 * Observable.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public abstract class Observable< T >
{
//------------------------------
//         Attributes
//------------------------------

	@Inject	@Observers private ArrayList< Observer< T > > observers;

//------------------------------
//  Constructors
//------------------------------

	/**
	* Constructor
	*/
	public Observable( )
	{
		super( );
	}

//------------------------------
//    Methods
//------------------------------

	/**
	* Adds a new observer
	* @param observer
	*/
	public void addObserver( Observer< T > observer )
	{
		observers.add( observer );
	}

	/**
	* Notify observers
	* @throws BusinessException
	*/
	public void notifyObservers( ) throws BusinessException
	{
		for ( Observer< T > observer : observers )
			observer.update( );
	}

	/**
	* Notify observers using message
	* @param message
	* @throws BusinessException
	*/
	public void notifyObservers( ArrayList< T > events ) throws BusinessException
	{
		for ( Observer< T > observer : observers )
			observer.update( events );
	}

//------------------------------
// Private methods
//------------------------------
}
