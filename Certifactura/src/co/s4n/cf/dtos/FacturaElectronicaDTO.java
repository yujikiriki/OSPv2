package co.s4n.cf.dtos;

import static com.google.common.base.Preconditions.checkNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import co.s4n.cf.domain.entities.fe.FacturaElectronica;
import co.s4n.osp.dto.DataTransferObject;

import com.google.common.base.Objects;


/**
 * Certifactura
 * FacturaElectronicaDTO.java
 * @author yuji
 * May 7, 2012
 * Copyright (C) 2012 Yuji Kiriki 
 * Licensed under the MIT License (MIT)
 */
public class FacturaElectronicaDTO implements DataTransferObject
{
//------------------------------
//         Attributes
//------------------------------

	private static final long serialVersionUID = 8914176552782031949L;
	private String idCliente;
	private String fechaExpedicion;
	private String fechaConservacion;
	private String estado;
	
//------------------------------
//        Constructors
//------------------------------

	/**
	 * @param idCliente
	 * @param fechaExpedicion
	 * @param fechaConservacion
	 */
	public FacturaElectronicaDTO( FacturaElectronica fe )
	{
		super( );
		this.idCliente = fe.getIdCliente( );
		System.out.println( fe );
		setEstado( fe );
		setFechaExpedicion( fe.getFechaExpedicion( ) );
		setFechaConservacion( fe.getFechaConservacion( ) );
		
	}

	/**
	 * @param fe
	 */
	private void setEstado( FacturaElectronica fe )
	{
		this.estado = checkNotNull( fe.getState( ), "El estado de la factura electronica se encuentra vacío." ).toString( ); 
	}

//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @param fechaExpedicion2
	 */
	private void setFechaConservacion( Date fechaConservacion )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		if( fechaConservacion != null )
			this.fechaConservacion = sdf.format( fechaConservacion );
	}
	
	/**
	 * @param date
	 */
	private void setFechaExpedicion( Date fechaExpedicion )
	{
		SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd" );
		this.fechaExpedicion = sdf.format( checkNotNull( fechaExpedicion, "La fecha de expedición de la factura es vacía." ) );
	}

	/**
	 * @return
	 */
	public String getIdCliente( )
	{
		return idCliente;
	}

	/**
	 * @return
	 */
	public String getFechaExpedicion( )
	{
		return fechaExpedicion;
	}
	
	/**
	 * @return
	 */
	public String getFechaConservacion( )
	{
		return fechaConservacion;
	}
	
	/**
	 * @return
	 */
	public String getEstado( )
	{
		return estado;
	}
	
	@Override public int hashCode()
	{
		return Objects.hashCode( idCliente );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals( Object obj )
	{
		if( obj instanceof FacturaElectronicaDTO )
		{
			final FacturaElectronicaDTO other = ( FacturaElectronicaDTO  ) obj;
			return Objects.equal( idCliente, other.idCliente );
		}
		return Boolean.FALSE;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString( )
	{
		return Objects.toStringHelper( this )
			.add( "idCliente: ", idCliente )
			.add( "estado: ", estado )
			.add( "fechaExpedicion: ", fechaExpedicion )
			.add( "fechaConservacion", fechaConservacion )
			.toString( );
	}	
//------------------------------
//      Private methods
//------------------------------
}
