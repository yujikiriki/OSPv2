/**
 * 
 */
package co.s4n.osp.observer;

import java.util.ArrayList;

/**
 * Certifactura
 * Observer.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public interface Observer< T >
{
//------------------------------
//          Methods
//------------------------------
	
	/**
	 * Update the state of the observer
	 */
	public void update( );
	
	/**
	 * Use the associated events to update the state of the observer
	 * @param events
	 */
	public void update( ArrayList< T > events );
	
}
