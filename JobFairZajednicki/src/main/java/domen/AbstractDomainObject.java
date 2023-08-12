package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The AbstractDomainObject class serves as a base class for domain objects in your application.
 * 
 * It defines abstract methods that need to be implemented by subclasses to provide necessary
 * information about the domain object's structure, database mapping, and operations.
 *
 * This class implements the Serializable interface, allowing instances to be serialized and deserialized.
 * 
 * @author Irena Randjelovic
 */
public abstract class AbstractDomainObject implements Serializable{
	
	/**
     * Abstract method that returns the name of the database table associated with the domain object.
     *
     * @return The name of the database table.
     */
	public abstract String nazivTabele();
	
	/**
     * Abstract method that returns the alias for the domain object's table in SQL queries.
     *
     * @return The alias for the table.
     */
    public abstract String alijas();
    
    /**
     * Abstract method that returns the SQL join clause for the domain object, if needed for querying.
     *
     * @return The SQL join clause.
     */
    public abstract String join();
    
    /**
     * Abstract method that constructs a list of domain objects from a ResultSet.
     *
     * @param rs The ResultSet containing the data.
     * @return A list of domain objects constructed from the ResultSet.
     * @throws SQLException If a database access error occurs.
     */
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;
    
    /**
     * Abstract method that returns the column names for the INSERT SQL statement.
     *
     * @return The column names for the INSERT statement.
     */
    public abstract String koloneZaInsert();
    
    /**
     * Abstract method that returns the value for the primary key used in INSERT statements.
     *
     * @return The value for the primary key.
     */
    public abstract String vrednostZaPrimarniKljuc();
    
    /**
     * Abstract method that returns the values for the INSERT SQL statement.
     *
     * @return The values for the INSERT statement.
     */
    public abstract String vrednostiZaInsert();
    
    /**
     * Abstract method that returns the values for the UPDATE SQL statement.
     *
     * @return The values for the UPDATE statement.
     */
    public abstract String vrednostiZaUpdate();
    
    /**
     * Abstract method that defines the WHERE condition for queries.
     *
     * @return The WHERE condition for queries.
     */
    public abstract String uslov();
}
