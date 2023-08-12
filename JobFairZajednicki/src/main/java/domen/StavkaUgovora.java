package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Korisnik
 */
public class StavkaUgovora extends AbstractDomainObject {

    private Ugovor ugovor;
    private int rbStavke;
    private String nazivStavke;
    private double cenaStavke;

    public StavkaUgovora(Ugovor ugovor, int rbStavke, String opisStavke, double cenaStavke) {
        this.ugovor = ugovor;
        this.rbStavke = rbStavke;
        this.nazivStavke = opisStavke;
        this.cenaStavke = cenaStavke;
    }

    public StavkaUgovora() {
    }

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

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    public int getRbStavke() {
        return rbStavke;
    }

    public void setRbStavke(int rbStavke) {
        this.rbStavke = rbStavke;
    }

    public String getNazivStavke() {
        return nazivStavke;
    }

    public void setNazivStavke(String nazivStavke) {
        this.nazivStavke = nazivStavke;
    }

    public double getCenaStavke() {
        return cenaStavke;
    }

    public void setCenaStavke(double cenaStavke) {
        this.cenaStavke = cenaStavke;
    }

}
