package co.s4n.osp.state;

import java.util.ArrayList;

import co.s4n.cf.dtos.DataTransferObject;
import co.s4n.osp.events.DomainEvent;

/**
 * CertifacturaOSP
 * StateEventsFactory.java
 * @author yuji
 * May 4, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public interface StateEventsFactory
{
	/**
	 * @param state
	 * @return The events generated within the state
	 */
	public ArrayList< DomainEvent > getEventsFor( DataTransferObject dto );
	
	/**
	 * @param state
	 * @return The events required to get back to the last state 
	 */
	public ArrayList< DomainEvent > getFailoverEventsFor( DataTransferObject dto );
}
