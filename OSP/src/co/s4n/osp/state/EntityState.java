package co.s4n.osp.state;

import com.google.common.base.Objects;

/**
 * EntityWithStates
 * IEntityState
 * @author Yuji Kiriki.
 * Nov 20, 2010
 */

public abstract class EntityState
{
//------------------------------
//        Attributes
//------------------------------
	
	protected String name;
	
//------------------------------
//        Constructors
//------------------------------
	
	/**
	 * Constructor
	 */
	public EntityState( String name )
	{
		super( );
		this.name = name;
	}
	
//------------------------------
//          Methods
//------------------------------
	
	/**
	 * @return The EventState name
	 */
	public String getName( )
	{
		return name;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override public int hashCode()
	{
		return Objects.hashCode( name );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override public boolean equals( Object obj )
	{
		if( obj instanceof EntityState )
		{
			final EntityState other = ( EntityState  ) obj;
			return Objects.equal( name, other.name );
		}
		return Boolean.FALSE;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override public String toString( )
	{
		return Objects.toStringHelper( this )
			.add( "", name )
			.toString( );
	}
	
//------------------------------
//       Private methods
//------------------------------

}




