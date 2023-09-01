package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Represents a contract (Ugovor) in the system. 
 * 
 * A contract associates with a meeting, a company, and may have multiple contract items (stavkeUgovora).
 * This class extends the AbstractDomainObject class and implements methods for
 * database interaction.
 * 
 * @see AbstractDomainObject
 * @author Irena Randjelovic
 */
public class Ugovor extends AbstractDomainObject {

	/**
     * The unique identifier for the contract.
     */
    private Long ugovorID;

    /**
     * The student organization involved in the contract.
     */
    private Udruzenje udruzenje;

    /**
     * The total cost of the contract.
     */
    private double ukupnaCena;

    /**
     * The date when the contract was concluded.
     */
    private Date datumZakljucenja;

    /**
     * The meeting associated with the contract.
     */
    private Sastanak sastanak;

    /**
     *  The package associated with the contract.
     */
    private Paket paket;

    /**
     * The list of contract items (stavkeUgovora) associated with the contract.
     */
    private ArrayList<StavkaUgovora> stavkeUgovora;

    /**
     * Constructs a new Ugovor object with the specified attributes.
     *
     * @param ugovorID         The unique identifier for the contract.
     * @param udruzenje        The student organization involved in the contract.
     * @param ukupnaCena       The total cost of the contract.
     * @param datumZakljucenja The date when the contract was concluded.
     * @param sastanak         The meeting associated with the contract.
     * @param paket            The package associated with the company and contract.
     * @param stavkeUgovora    The list of contract items (stavkeUgovora) associated with the contract.
     * @throws IllegalArgumentException If any of the provided attributes are invalid.
     */
    public Ugovor(Long ugovorID, Udruzenje udruzenje, double ukupnaCena, Date datumZakljucenja, Sastanak sastanak, Paket paket, ArrayList<StavkaUgovora> stavkeUgovora) {
        if (ugovorID == null || ugovorID < 0) {
            throw new IllegalArgumentException("UgovorID cannot be null or negative.");
        }
        if (udruzenje == null) {
            throw new IllegalArgumentException("Udruzenje cannot be null.");
        }
        if (datumZakljucenja == null) {
            throw new IllegalArgumentException("DatumZakljucenja cannot be null.");
        }
        if (sastanak == null) {
            throw new IllegalArgumentException("Sastanak cannot be null.");
        }
        if (paket == null) {
            throw new IllegalArgumentException("Paket cannot be null.");
        }
        this.ugovorID = ugovorID;
        this.udruzenje = udruzenje;
        this.ukupnaCena = ukupnaCena;
        this.datumZakljucenja = datumZakljucenja;
        this.sastanak = sastanak;
        this.paket = paket;
        this.stavkeUgovora = stavkeUgovora;
    }

    /**
     * Default constructor. Creates an empty Ugovor object.
     */
    public Ugovor() {
    }

    @Override
    public String nazivTabele() {
        return " Ugovor ";
    }

    @Override
    public String alijas() {
        return " u ";
    }

    @Override
    public String join() {
        return " JOIN PAKET P ON (P.PAKETID = U.PAKETID) "
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

            Udruzenje udruzenje = Udruzenje.valueOf(rs.getString("udruzenje"));

            Ugovor u = new Ugovor(rs.getLong("ugovorID"), udruzenje,
                    rs.getDouble("ukupnaCena"), rs.getDate("datumZakljucenja"), s, p, null);

            lista.add(u);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (udruzenje, ukupnaCena, datumZakljucenja, sastanakID, paketID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ugovorID = " + ugovorID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + udruzenje + "', " + ukupnaCena + ", "
                + "'" + new java.sql.Date(datumZakljucenja.getTime()) + "', "
                + sastanak.getSastanakID() + ", " + paket.getPaketID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " ukupnaCena = " + ukupnaCena + ", "
                + "paketID = " + paket.getPaketID() + ", "
                + "datumZakljucenja = '" + new java.sql.Date(datumZakljucenja.getTime()) + "' ";
    }

    @Override
    public String uslov() {
        if (sastanak == null) {
            return "";
        }
        return " WHERE S.SASTANAKID = " + sastanak.getSastanakID();
    }

    /**
     * Gets the unique identifier of the contract (ugovorID).
     * 
     * @return The ugovorID of the contract.
     */
    public Long getUgovorID() {
        return ugovorID;
    }

    /**
     * Sets the unique identifier of the contract (ugovorID).
     * 
     * @param ugovorID The ugovorID to set for the contract.
     */
    public void setUgovorID(Long ugovorID) {
        this.ugovorID = ugovorID;
    }
    /**
     * Gets the student organization involved in the contract.
     * 
     * @return The student organization.
     */
    public Udruzenje getUdruzenje() {
        return udruzenje;
    }

    /**
     * Sets the student organization involved in the contract.
     *
     * @param udruzenje The student organization to set. Must not be null.
     * @throws IllegalArgumentException If the provided udruzenje is null.
     */
    public void setUdruzenje(Udruzenje udruzenje) {
        if (udruzenje == null) {
            throw new IllegalArgumentException("Udruzenje cannot be null.");
        }
        this.udruzenje = udruzenje;
    }

    /**
     * Gets the total cost of the contract.
     * 
     * @return The total cost of the contract.
     */
    public double getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * Sets the total cost of the contract.
     *
     * @param ukupnaCena The total cost to set for the contract. Must be non-negative.
     * @throws IllegalArgumentException If the provided ukupnaCena is negative.
     */
    public void setUkupnaCena(double ukupnaCena) {
        if (ukupnaCena < 0) {
            throw new IllegalArgumentException("UkupnaCena cannot be negative.");
        }
        this.ukupnaCena = ukupnaCena;
    }

    /**
     * Gets the date when the contract was concluded.
     * 
     * @return The date of contract conclusion.
     */
    public Date getDatumZakljucenja() {
        return datumZakljucenja;
    }

    /**
     * Sets the date when the contract was concluded.
     *
     * @param datumZakljucenja The date of contract conclusion to set. Must not be null.
     * @throws IllegalArgumentException If the provided datumZakljucenja is null.
     */
    public void setDatumZakljucenja(Date datumZakljucenja) {
        if (datumZakljucenja == null) {
            throw new IllegalArgumentException("DatumZakljucenja cannot be null.");
        }
        this.datumZakljucenja = datumZakljucenja;
    }

    /**
     * Gets the meeting associated with the contract.
     * 
     * @return The Sastanak (meeting) object associated with the contract.
     */
    public Sastanak getSastanak() {
        return sastanak;
    }

    /**
     * Sets the meeting associated with the contract.
     *
     * @param sastanak The Sastanak (meeting) object to associate with the contract.
     */
    public void setSastanak(Sastanak sastanak) {
        this.sastanak = sastanak;
    }
    /**
     * Gets the package associated with the contract.
     * 
     * @return The Paket (package) object associated with the contract.
     */
    public Paket getPaket() {
        return paket;
    }

    /**
     * Sets the package associated with the contract.
     *
     * @param paket The Paket (package) object to associate with the contract. Must not be null.
     * @throws IllegalArgumentException If the provided paket is null.
     */
    public void setPaket(Paket paket) {
        if (paket == null) {
            throw new IllegalArgumentException("Paket cannot be null.");
        }
        this.paket = paket;
    }

    /**
     * Gets the list of contract items (stavkeUgovora) associated with the contract.
     * 
     * @return The list of StavkaUgovora objects associated with the contract.
     */
    public ArrayList<StavkaUgovora> getStavkeUgovora() {
        return stavkeUgovora;
    }

    /**
     * Gets the list of contract items (stavkeUgovora) associated with the contract.
     * 
     * @return The list of StavkaUgovora objects associated with the contract.
     */
    public void setStavkeUgovora(ArrayList<StavkaUgovora> stavkeUgovora) {
        this.stavkeUgovora = stavkeUgovora;
    }

}
