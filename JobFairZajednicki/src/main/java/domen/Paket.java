package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Paket extends AbstractDomainObject {

    private Long paketID;
    private String nazivPaketa;
    private double cenaPaketa;

    @Override
    public String toString() {
        return nazivPaketa + " (Cena: " + cenaPaketa + "din)";
    }

    public Paket(Long paketID, String nazivPaketa, double cenaPaketa) {
        this.paketID = paketID;
        this.nazivPaketa = nazivPaketa;
        this.cenaPaketa = cenaPaketa;
    }

    public Paket() {
    }

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

    public Long getPaketID() {
        return paketID;
    }

    public void setPaketID(Long paketID) {
        this.paketID = paketID;
    }

    public String getNazivPaketa() {
        return nazivPaketa;
    }

    public void setNazivPaketa(String nazivPaketa) {
        this.nazivPaketa = nazivPaketa;
    }

    public double getCenaPaketa() {
        return cenaPaketa;
    }

    public void setCenaPaketa(double cenaPaketa) {
        this.cenaPaketa = cenaPaketa;
    }

}

