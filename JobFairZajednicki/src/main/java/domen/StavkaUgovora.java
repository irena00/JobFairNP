package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Represents a contract item (StavkaUgovora) in the system, which is associated with a contract (Ugovor).
 * 
 * This class extends the AbstractDomainObject class and implements methods for
 * database interaction.
 *
 * @see AbstractDomainObject
 * @author Korisnik
 */
public class StavkaUgovora extends AbstractDomainObject {

	/**
	 * The contract (Ugovor) to which this item belongs.
	 */
    private Ugovor ugovor;
    
    /**
     * The ordinal number of the contract item.
     */
    private int rbStavke;
    
    /**
     * The description/name of the contract item.
     */
    private String nazivStavke;
    
    /**
     * The price/cost of the contract item.
     */
    private double cenaStavke;

    /**
     * Constructs a new StavkaUgovora object with the specified attributes.
     *
     * @param ugovor The contract (Ugovor) to which this item belongs.
     * @param rbStavke The ordinal number of the contract item.
     * @param nazivStavke The description/name of the contract item.
     * @param cenaStavke The price/cost of the contract item.
     */
    public StavkaUgovora(Ugovor ugovor, int rbStavke, String opisStavke, double cenaStavke) {
        this.ugovor = ugovor;
        this.rbStavke = rbStavke;
        this.nazivStavke = opisStavke;
        this.cenaStavke = cenaStavke;
    }

    /**
     * Default constructor. Creates an empty StavkaUgovora object.
     */
    public StavkaUgovora() {
    }

    //Abstract methods implementation
    @Override
    public String nazivTabele() {
        return " StavkaUgovora ";
    }

    @Override
    public String alijas() {
        return " su ";
    }

    @Override
    public String join() {
        return " JOIN UGOVOR U ON (U.UGOVORID = SU.UGOVORID) "
                + "JOIN PAKET P ON (P.PAKETID = U.PAKETID) "
                + "JOIN SASTANAK S ON (S.SASTANAKID = U.SASTANAKID) "
                + "JOIN ADMINISTRATOR A ON (A.ADMINISTRATORID = S.ADMINISTRATORID) "
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

            Paket p = new Paket(rs.getLong("PaketID"),
                    rs.getString("NazivPaketa"), rs.getDouble("CenaPaketa"));

            ClanCRTima cr = new ClanCRTima(rs.getLong("ClanID"),
                    rs.getString("ImeClana"), rs.getString("PrezimeClana"),
                    rs.getString("Email"), rs.getString("Telefon"));

            Kompanija k = new Kompanija(rs.getLong("kompanijaID"), rs.getString("PIB"),
                    rs.getString("naziv"), rs.getString("adresa"),
                    rs.getString("granaPrivrede"), cr);

            Sastanak s = new Sastanak(rs.getLong("sastanakID"), rs.getTimestamp("datumVreme"),
                    rs.getString("tema"), rs.getString("lokacija"), k, a);

            Ugovor u = new Ugovor(rs.getLong("ugovorID"), rs.getString("udruzenje"),
                    rs.getDouble("ukupnaCena"), rs.getDate("datumZakljucenja"), s, p, null);

            StavkaUgovora su = new StavkaUgovora(u, rs.getInt("rbStavke"),
                    rs.getString("nazivStavke"), rs.getDouble("cenaStavke"));

            lista.add(su);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ugovorID, rbStavke, nazivStavke, cenaStavke) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ugovorID = " + ugovor.getUgovorID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + ugovor.getUgovorID() + ", " + rbStavke + ", "
                + "'" + nazivStavke + "', " + cenaStavke + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE U.UGOVORID = " + ugovor.getUgovorID();
    }

    /**
     * Gets the contract (Ugovor) to which this item belongs.
     *
     * @return The contract (Ugovor) associated with this contract item.
     */
    public Ugovor getUgovor() {
        return ugovor;
    }

    /**
     * Sets the contract (Ugovor) to which this item belongs.
     *
     * @param ugovor The contract (Ugovor) to associate with this contract item.
     */
    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    /**
     * Gets the ordinal number of the contract item.
     *
     * @return The ordinal number of the contract item.
     */
    public int getRbStavke() {
        return rbStavke;
    }

    /**
     * Sets the ordinal number of the contract item.
     *
     * @param rbStavke The ordinal number to set for the contract item.
     */
    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    /**
     * Gets the description/name of the contract item.
     *
     * @return The description/name of the contract item.
     */
    public String getNazivStavke() {
        return nazivStavke;
    }

    /**
     * Sets the description/name of the contract item.
     *
     * @param nazivStavke The description/name to set for the contract item.
     */
    public void setNazivStavke(String nazivStavke) {
        this.nazivStavke = nazivStavke;
    }

    /**
     * Gets the price/cost of the contract item.
     *
     * @return The price/cost of the contract item.
     */
    public double getCenaStavke() {
        return cenaStavke;
    }

    /**
     * Sets the price/cost of the contract item.
     *
     * @param cenaStavke The price/cost to set for the contract item.
     */
    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

}
