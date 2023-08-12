package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The Paket class represents a company package in the system.
 * 
 * Extends the AbstractDomainObject {@link AbstractDomainObject}. It defines specific attributes and methods for
 * managing packages data, including database mapping.
 * 
 * @see AbstractDomainObject
 * @author Irena Randjelovic
 */
public class Paket extends AbstractDomainObject {

	/**
	 * The ID of the package.
	 */
    private Long paketID;
    
    /**
     * The name of the package.
     */
    private String nazivPaketa;
    
    /**
     * The price of the package.
     */
    private double cenaPaketa;

    /**
     * Returns a String representation of the package, including its name and price.
     *
     * @return The package's name and price.
     */
    @Override
    public String toString() {
        return nazivPaketa + " (Cena: " + cenaPaketa + "din)";
    }

    /**
     * Constructor for creating a Paket instance with specified attributes.
     *
     * @param paketID     The ID of the package.
     * @param nazivPaketa The name of the package.
     * @param cenaPaketa  The price of the package.
     */
    public Paket(Long paketID, String nazivPaketa, double cenaPaketa) {
        this.paketID = paketID;
        this.nazivPaketa = nazivPaketa;
        this.cenaPaketa = cenaPaketa;
    }

    /**
     * Default constructor for creating an empty Paket instance.
     */
    public Paket() {
    }

    // Abstract methods implementation
    @Override
    public String nazivTabele() {
        return " Paket ";
    }

    @Override
    public String alijas() {
        return " p ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<AbstractDomainObject>();

        while (rs.next()) {
            Paket p = new Paket(rs.getLong("PaketID"),
                    rs.getString("NazivPaketa"), rs.getDouble("CenaPaketa"));

            lista.add(p);
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
        return " PaketID = " + paketID;
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
     * Get the ID of the package.
     *
     * @return The ID of the package.
     */
    public Long getPaketID() {
        return paketID;
    }

    /**
     * Set the ID of the package.
     *
     * @param paketID The ID to set for the package.
     */
    public void setPaketID(Long paketID) {
        this.paketID = paketID;
    }

    /**
     * Get the name of the package.
     *
     * @return The name of the package.
     */
    public String getNazivPaketa() {
        return nazivPaketa;
    }

    /**
     * Set the name of the package.
     *
     * @param nazivPaketa The name to set for the package.
     */
    public void setNazivPaketa(String nazivPaketa) {
        this.nazivPaketa = nazivPaketa;
    }

    /**
     * Get the price of the package.
     *
     * @return The price of the package.
     */
    public double getCenaPaketa() {
        return cenaPaketa;
    }

    /**
     * Set the price of the package.
     *
     * @param cenaPaketa The price to set for the package.
     */
    public void setCenaPaketa(double cenaPaketa) {
        this.cenaPaketa = cenaPaketa;
    }

}

