package co.s4n.osp.exceptions;

/**
 * EntityWithStates
 * BusinessException
 * @author Yuji Kiriki.
 * Nov 23, 2010
 */
public class BusinessException extends RuntimeException
{
//------------------------------
//        Attributes
//------------------------------
	
	private static final long serialVersionUID = -8420691883045752871L;

//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public BusinessException( )
	{
		super( );
	}

	/**
	 * Constructor
	 */
	public BusinessException( String arg0 )
	{
		super( arg0 );
	}

	/**
	 * Constructor
	 */
	public BusinessException( Throwable arg0 )
	{
		super( arg0 );
	}

	/**
	 * Constructor
	 */
	public BusinessException( String arg0, Throwable arg1 )
	{
		super( arg0, arg1 );
	}

}




