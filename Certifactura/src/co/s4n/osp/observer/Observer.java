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
	
	public void update( );
	public void update( ArrayList< T > events );
	
//------------------------------
//      Private methods
//------------------------------

}
