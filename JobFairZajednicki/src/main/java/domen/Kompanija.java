package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Kompanija class represents a company in the system.
 * 
 * Extends the AbstractDomainObject {@link AbstractDomainObject}. It defines specific attributes and methods for
 * managing company data, including database mapping.
 * 
 * @see AbstractDomainObject
 * @author Irena Randjelovic
 */
public class Kompanija extends AbstractDomainObject {

	/**
	 * The ID of the company.
	 */
    private Long kompanijaID;
    
    /**
     * The Tax Identification Number (PIB) of the company.
     */
    private String PIB;
    
    /**
     * The name of the company.
     */
    private String nazivKompanije;
    
    /**
     * The address of the company.
     */
    private String adresa;
    
    /**
     * The industry sector of the company.
     */
    private String granaPrivrede;
    
    /**
     * The team member representing the company.
     */
    private ClanCRTima clanCRTima;

    /**
     * Returns a String representation of the company, including the team member's name.
     *
     * @return The company's name with the team member's name.
     */
    @Override
    public String toString() {
        return nazivKompanije + " (Clan CR tima: " + clanCRTima + ")";
    }

    /**
     * Constructor for creating a Kompanija instance with specified attributes.
     *
     * @param kompanijaID       The ID of the company.
     * @param PIB               The Tax Identification Number (PIB) of the company.
     * @param nazivKompanije    The name of the company.
     * @param adresa            The address of the company.
     * @param granaPrivrede     The industry sector of the company.
     * @param clanCRTima        The team member representing the company.
     * @throws IllegalArgumentException If any of the provided attributes is null, blank, or invalid.
     */
    public Kompanija(Long kompanijaID, String PIB, String nazivKompanije, String adresa, String granaPrivrede, ClanCRTima clanCRTima) {
    	if (kompanijaID == null || PIB == null || PIB.trim().isEmpty() || nazivKompanije == null || nazivKompanije.trim().isEmpty()
                || adresa == null || adresa.trim().isEmpty() || granaPrivrede == null || granaPrivrede.trim().isEmpty()
                || clanCRTima == null) {
            throw new IllegalArgumentException("Invalid data for Kompanija");
        }
        this.kompanijaID = kompanijaID;
        this.PIB = PIB;
        this.nazivKompanije = nazivKompanije;
        this.adresa = adresa;
        this.granaPrivrede = granaPrivrede;
        this.clanCRTima = clanCRTima;
    }

    /**
     * Default constructor for creating an empty Kompanija instance.
     */
    public Kompanija() {
    }

    // Abstract methods implementation
    @Override
    public String nazivTabele() {
        return " Kompanija ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " JOIN CLANCRTIMA CR ON (CR.CLANID = K.CLANID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<AbstractDomainObject>();

        while (rs.next()) {
            ClanCRTima cr = new ClanCRTima(rs.getLong("ClanID"),
                    rs.getString("ImeClana"), rs.getString("PrezimeClana"),
                    rs.getString("Email"), rs.getString("Telefon"));

            Kompanija k = new Kompanija(rs.getLong("kompanijaID"), rs.getString("PIB"),
                    rs.getString("naziv"), rs.getString("adresa"),
                    rs.getString("granaPrivrede"), cr);

            lista.add(k);
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
        return " kompanijaID = " + kompanijaID;
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
     * Get the ID of the company.
     *
     * @return The ID of the company.
     */
    public Long getKompanijaID() {
        return kompanijaID;
    }

    /**
     * Set the ID of the company.
     *
     * @param kompanijaID The ID to set for the company.
     */
    public void setKompanijaID(Long kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    /**
     * Get the Tax Identification Number (PIB) of the company.
     *
     * @return The PIB (Tax Identification Number) of the company.
     */
    public String getPIB() {
        return PIB;
    }

    /**
     * Set the Tax Identification Number (PIB) of the company.
     *
     * @param PIB The PIB (Tax Identification Number) to set for the company. Must not be null or blank.
     * @throws IllegalArgumentException If the provided PIB is null or blank.
     */
    public void setPIB(String PIB) {
        if (PIB == null || PIB.trim().isEmpty()) {
            throw new IllegalArgumentException("PIB cannot be null or blank.");
        }
        this.PIB = PIB;
    }

    /**
     * Get the name of the company.
     *
     * @return The name of the company.
     */
    public String getNazivKompanije() {
        return nazivKompanije;
    }

    /**
     * Set the name of the company.
     *
     * @param nazivKompanije The name to set for the company. Must not be null or blank.
     * @throws IllegalArgumentException If the provided name is null or blank.
     */
    public void setNazivKompanije(String nazivKompanije) {
        if (nazivKompanije == null || nazivKompanije.trim().isEmpty()) {
            throw new IllegalArgumentException("Naziv kompanije cannot be null or blank.");
        }
        this.nazivKompanije = nazivKompanije;
    }

    /**
     * Get the address of the company.
     *
     * @return The address of the company.
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Set the address of the company.
     *
     * @param adresa The address to set for the company. Must not be null or blank.
     * @throws IllegalArgumentException If the provided address is null or blank.
     */
    public void setAdresa(String adresa) {
        if (adresa == null || adresa.trim().isEmpty()) {
            throw new IllegalArgumentException("Adresa cannot be null or blank.");
        }
        this.adresa = adresa;
    }

    /**
     * Get the industry sector of the company.
     *
     * @return The industry sector of the company.
     */
    public String getGranaPrivrede() {
        return granaPrivrede;
    }

    /**
     * Set the industry sector of the company.
     *
     * @param granaPrivrede The industry sector to set for the company. Must not be null or blank.
     * @throws IllegalArgumentException If the provided industry sector is null or blank.
     */
    public void setGranaPrivrede(String granaPrivrede) {
        if (granaPrivrede == null || granaPrivrede.trim().isEmpty()) {
            throw new IllegalArgumentException("Grana privrede cannot be null or blank.");
        }
        this.granaPrivrede = granaPrivrede;
    }	

    /**
     * Get the team member representing the company.
     *
     * @return The team member representing the company.
     */
    public ClanCRTima getClanCRTima() {
        return clanCRTima;
    }

    /**
     * Set the team member representing the company.
     *
     * @param clanCRTima The team member to set for the company.
     */
    public void setClanCRTima(ClanCRTima clanCRTima) {
        this.clanCRTima = clanCRTima;
    }
}