package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class Ugovor extends AbstractDomainObject {

    private Long ugovorID;
    private String udruzenje;
    private double ukupnaCena;
    private Date datumZakljucenja;
    private Sastanak sastanak;
    private Paket paket;
    private ArrayList<StavkaUgovora> stavkeUgovora;

    public Ugovor(Long ugovorID, String udruzenje, double ukupnaCena, Date datumZakljucenja, Sastanak sastanak, Paket paket, ArrayList<StavkaUgovora> stavkeUgovora) {
        this.ugovorID = ugovorID;
        this.udruzenje = udruzenje;
        this.ukupnaCena = ukupnaCena;
        this.datumZakljucenja = datumZakljucenja;
        this.sastanak = sastanak;
        this.paket = paket;
        this.stavkeUgovora = stavkeUgovora;
    }

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

            Ugovor u = new Ugovor(rs.getLong("ugovorID"), rs.getString("udruzenje"),
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

    public Long getUgovorID() {
        return ugovorID;
    }

    public void setUgovorID(Long ugovorID) {
        this.ugovorID = ugovorID;
    }

    public String getUdruzenje() {
        return udruzenje;
    }

    public void setUdruzenje(String udruzenje) {
        this.udruzenje = udruzenje;
    }

    public double getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(double ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Date getDatumZakljucenja() {
        return datumZakljucenja;
    }

    public void setDatumZakljucenja(Date datumZakljucenja) {
        this.datumZakljucenja = datumZakljucenja;
    }

    public Sastanak getSastanak() {
        return sastanak;
    }

    public void setSastanak(Sastanak sastanak) {
        this.sastanak = sastanak;
    }

    public Paket getPaket() {
        return paket;
    }

    public void setPaket(Paket paket) {
        this.paket = paket;
    }

    public ArrayList<StavkaUgovora> getStavkeUgovora() {
        return stavkeUgovora;
    }

    public void setStavkeUgovora(ArrayList<StavkaUgovora> stavkeUgovora) {
        this.stavkeUgovora = stavkeUgovora;
    }

}
