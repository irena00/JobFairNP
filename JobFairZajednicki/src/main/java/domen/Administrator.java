package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Administrator class represents an administrator in the system.
 * 
 * Extends the AbstractDomainObject {@link AbstractDomainObject}. It defines specific attributes and methods for
 * managing administrator data, including database mapping.
 * 
 * @see AbstractDomainObject
 * @author Irena Randjelovic
 */
public class Administrator extends AbstractDomainObject{
	
	/**
	 * The ID of the administrator.
	 */
	private Long administratorID;
	
	/**
	 * The first name of the administrator.
	 */
    private String ime;
    
    /**
	 * The last name of the administrator.
	 */
    private String prezime;
    
    /**
	 * The username of the administrator.
	 */
    private String username;
    
    /**
	 * The password of the administrator.
	 */
    private String password;

    /**
	 * Default constructor
	 */
    public Administrator() {
    }

    /**
     * Constructor for creating an Administrator instance with specified attributes.
     *
     * @param administratorID The ID of the administrator.
     * @param ime             The first name of the administrator.
     * @param prezime         The last name of the administrator.
     * @param username        The username of the administrator.
     * @param password        The password of the administrator.
     */
    public Administrator(Long administratorID, String ime, String prezime, String username, String password) {
        this.administratorID = administratorID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    /**
     * Get the administrator's ID.
     *
     * @return The administrator's ID.
     */
    public Long getAdministratorID() {
        return administratorID;
    }

    /**
     * Set the administrator's ID.
     *
     * @param administratorID The ID to set for the administrator.
     */
    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }

    /**
     * Get the administrator's username.
     *
     * @return The administrator's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the administrator's username.
     * 
     * The username should not be null, blank, or contain only whitespace characters.
     *
     * @param username The username to set for the administrator.
     * @throws IllegalArgumentException If the provided username is null, blank, or contains only whitespace characters.
     */
    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null, blank, or contain only whitespace characters.");
        }
        this.username = username;
    }

    /**
     * Get the administrator's password.
     *
     * @return The administrator's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the administrator's password.
     * 
     * The password should not be null or blank.
     * 
     * @param password The password to set for the administrator.
     * @throws IllegalArgumentException If the provided password is null or blank.
     */
    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or blank.");
        }
        this.password = password;
    }
    
    /**
     * Get the administrator's first name.
     *
     * @return The administrator's first name.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Set the administrator's first name.
     *
     * @param ime The first name to set for the administrator.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Get the administrator's last name.
     *
     * @return The administrator's last name.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Set the administrator's last name.
     *
     * @param prezime The last name to set for the administrator.
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    
    /**
     * Returns a String representation of the administrator's full name.
     *
     * @return The administrator's full name.
     */
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    // Abstract methods implementation
    @Override
    public String nazivTabele() {
        return " administrator ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<AbstractDomainObject>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            lista.add(a);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Username, Password) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " AdministratorID = " + administratorID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + username + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "Username = '" + username + "', Password = '" + password + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }
}
