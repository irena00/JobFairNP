package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 * Sastanak class represents a meeting in the system.
 * 
 * Extends the AbstractDomainObject {@link AbstractDomainObject}. It represents meeting between Company and our administrator.
 * 
 * @see AbstractDomainObject
 * @author Irena Randjelovic
 */
public class Sastanak extends AbstractDomainObject {

	/**
	 * The ID of the meeting.
	 */
    private Long sastanakID;
    
    /**
     * The date and time of the meeting.
     */
    private Date datumVreme;
    
    /**
     * The topic of the meeting.
     */
    private String tema;
    
    /**
     * The location of the meeting.
     */
    private String lokacija;
    
    /**
     * The company associated with the meeting.
     */
    private Kompanija kompanija;
    
    /**
     * The administrator organizing the meeting.
     */
    private Administrator administrator;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Checks if this Sastanak is equal to another object. Two Sastanak objects are
     * considered equal if their sastanakID attributes are equal.
     *
     * @param obj The object to compare with this Sastanak.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sastanak other = (Sastanak) obj;
        if (!Objects.equals(this.sastanakID, other.sastanakID)) {
            return false;
        }
        return true;
    }

    /**
     * Returns a string representation of the Sastanak, including the company and
     * the formatted date and time of the meeting.
     *
     * @return The string representation of the Sastanak.
     */
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return kompanija + " [Datum: " + sdf.format(datumVreme) + "]";
    }

    /**
     * Creates a new instance of the Sastanak class with specified attributes.
     *
     * @param sastanakID     The ID of the meeting.
     * @param datumVreme     The date and time of the meeting.
     * @param tema           The topic of the meeting.
     * @param lokacija       The location of the meeting.
     * @param kompanija      The company associated with the meeting.
     * @param administrator   The administrator organizing the meeting.
     */
    public Sastanak(Long sastanakID, Date datumVreme, String tema, String lokacija, Kompanija kompanija, Administrator administrator) {
        this.sastanakID = sastanakID;
        this.datumVreme = datumVreme;
        this.tema = tema;
        this.lokacija = lokacija;
        this.kompanija = kompanija;
        this.administrator = administrator;
    }

    /**
     * Creates a new instance of the Sastanak class.
     */
    public Sastanak() {
    }

    // Abstract methods implementation
    @Override
    public String nazivTabele() {
        return " Sastanak ";
    }

    @Override
    public String alijas() {
        return " s ";
    }

    @Override
    public String join() {
        return " JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = S.ADMINISTRATORID) "
                + "JOIN KOMPANIJA K ON (K.KOMPANIJAID = S.KOMPANIJAID) "
                + "JOIN CLANCRTIMA CR ON (CR.CLANID = K.CLANID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<AbstractDomainObject>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            ClanCRTima cr = new ClanCRTima(rs.getLong("ClanID"),
                    rs.getString("ImeClana"), rs.getString("PrezimeClana"),
                    rs.getString("Email"), rs.getString("Telefon"));

            Kompanija k = new Kompanija(rs.getLong("kompanijaID"), rs.getString("PIB"),
                    rs.getString("naziv"), rs.getString("adresa"),
                    rs.getString("granaPrivrede"), cr);

            Sastanak s = new Sastanak(rs.getLong("sastanakID"), rs.getTimestamp("datumVreme"),
                    rs.getString("tema"), rs.getString("lokacija"), k, a);

            lista.add(s);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumVreme, tema, lokacija, kompanijaID, administratorID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " sastanakID = " + sastanakID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', '" + tema + "', "
                + "'" + lokacija + "', " + kompanija.getKompanijaID() + ", "
                + administrator.getAdministratorID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " datumVreme = '" + new Timestamp(datumVreme.getTime()) + "', "
                + "tema = '" + tema + "', "
                + "lokacija = '" + lokacija + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

    /**
     * Get the ID of the meeting.
     *
     * @return The ID of the meeting.
     */
    public Long getSastanakID() {
        return sastanakID;
    }

    /**
     * Set the ID of the meeting.
     *
     * @param sastanakID The ID to set for the meeting.
     */
    public void setSastanakID(Long sastanakID) {
        this.sastanakID = sastanakID;
    }

    /**
     * Get the date and time of the meeting.
     *
     * @return The date and time of the meeting.
     */
    public Date getDatumVreme() {
        return datumVreme;
    }

    /**
     * Set the date and time of the meeting.
     *
     * @param datumVreme The date and time to set for the meeting.
     */
    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    /**
     * Get the topic of the meeting.
     *
     * @return The topic of the meeting.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Set the topic of the meeting.
     *
     * @param tema The topic to set for the meeting.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Get the location of the meeting.
     *
     * @return The location of the meeting.
     */
    public String getLokacija() {
        return lokacija;
    }

    /**
     * Set the location of the meeting.
     *
     * @param lokacija The location to set for the meeting.
     */
    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    /**
     * Get the company associated with the meeting.
     *
     * @return The company associated with the meeting.
     */
    public Kompanija getKompanija() {
        return kompanija;
    }

    /**
     * Set the company associated with the meeting.
     *
     * @param kompanija The company to set for the meeting.
     */
    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    /**
     * Get the administrator organizing the meeting.
     *
     * @return The administrator organizing the meeting.
     */

    public Administrator getAdministrator() {
        return administrator;
    }

    /**
     * Set the administrator organizing the meeting.
     *
     * @param administrator The administrator to set for the meeting.
     */
    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
