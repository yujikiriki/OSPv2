import org.junit.Test;

import co.s4n.cf.domain.entities.fe.FacturaElectronica;
import co.s4n.cf.domain.entities.fe.FacturaElectronicaModule;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Certifactura
 * Test_FacturaElectronica_Expedicion.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class Test_FacturaElectronica_Expedicion
{
//------------------------------
//         Test Methods
//------------------------------

	@Test
	public void testExpedir( )
	{
		Injector injector = Guice.createInjector( new FacturaElectronicaModule( ) );
		FacturaElectronica fe = injector.getInstance( FacturaElectronica.class );
		fe.expedir( );
	}

}
