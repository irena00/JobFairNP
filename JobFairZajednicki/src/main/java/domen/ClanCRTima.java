package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * CR team member (ClanCRTima) class represents a team member in the system. 
 * 
 * Extends the AbstractDomainObject {@link AbstractDomainObject}. It defines specific attributes and methods for
 * managing team member data, including database mapping.
 * 
 * @see AbstractDomainObject
 * @author Irena Randjelovic
 */
public class ClanCRTima extends AbstractDomainObject{
	
	/**
	 * The ID of the team member.
	 */
	private Long clanID;
	
	/**
	 * The first name of the team member.
	 */
    private String imeClana;
    
    /**
     * The last name of the team member.
     */
    private String prezimeClana;
    
    /**
     * The email of the team member.
     */
    private String email;
    
    /**
     * The phone number of the team member.
     */
    private String telefon;

    
    @Override
    public String toString() {
        return imeClana + " " + prezimeClana;
    }

    /**
     * Constructor for creating a ClanCRTima instance with specified attributes.
     *
     * @param clanID       The ID of the team member.
     * @param imeClana     The first name of the team member.
     * @param prezimeClana The last name of the team member.
     * @param email        The email of the team member.
     * @param telefon      The phone number of the team member.
     */
    public ClanCRTima(Long clanID, String imeClana, String prezimeClana, String email, String telefon) {
        this.clanID = clanID;
        this.imeClana = imeClana;
        this.prezimeClana = prezimeClana;
        this.email = email;
        this.telefon = telefon;
    }

    /**
     * Default constructor for creating an empty ClanCRTima instance.
     */
    public ClanCRTima() {
    }

    @Override
    public String nazivTabele() {
        return " ClanCRTima ";
    }

    @Override
    public String alijas() {
        return " cr ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<AbstractDomainObject>();

        while (rs.next()) {
            ClanCRTima cr = new ClanCRTima(rs.getLong("ClanID"),
                    rs.getString("ImeClana"), rs.getString("PrezimeClana"),
                    rs.getString("Email"), rs.getString("Telefon"));

            lista.add(cr);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ClanID = " + clanID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

    /**
     * Get the team member's ID.
     *
     * @return The team member's ID.
     */
    public Long getClanID() {
        return clanID;
    }

    /**
     * Set the team member's ID.
     *
     * @param clanID The ID to set for the team member.
     */
    public void setClanID(Long clanID) {
        this.clanID = clanID;
    }

    /**
     * Get the team member's first name.
     *
     * @return The team member's first name.
     */
    public String getImeClana() {
        return imeClana;
    }

    /**
     * Set the team member's first name.
     *
     * @param imeClana The first name to set for the team member.
     */
    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    /**
     * Get the team member's last name.
     *
     * @return The team member's last name.
     */
    public String getPrezimeClana() {
        return prezimeClana;
    }

    /**
     * Set the team member's last name.
     *
     * @param prezimeClana The last name to set for the team member.
     */
    public void setPrezimeClana(String prezimeClana) {
        this.prezimeClana = prezimeClana;
    }

    /**
     * Get the team member's email.
     *
     * @return The team member's email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the team member's email.
     *
     * @param email The email to set for the team member.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the team member's phone number.
     *
     * @return The team member's phone number.
     */	
    public String getTelefon() {
        return telefon;
    }

    /**
     * Set the team member's phone number.
     *
     * @param telefon The phone number to set for the team member.
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
