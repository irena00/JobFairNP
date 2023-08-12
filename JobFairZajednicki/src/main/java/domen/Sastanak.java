package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Korisnik
 */
public class Sastanak extends AbstractDomainObject {

    private Long sastanakID;
    private Date datumVreme;
    private String tema;
    private String lokacija;
    private Kompanija kompanija;
    private Administrator administrator;

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        return kompanija + " [Datum: " + sdf.format(datumVreme) + "]";
    }

    public Sastanak(Long sastanakID, Date datumVreme, String tema, String lokacija, Kompanija kompanija, Administrator administrator) {
        this.sastanakID = sastanakID;
        this.datumVreme = datumVreme;
        this.tema = tema;
        this.lokacija = lokacija;
        this.kompanija = kompanija;
        this.administrator = administrator;
    }

    public Sastanak() {
    }

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

    public Long getSastanakID() {
        return sastanakID;
    }

    public void setSastanakID(Long sastanakID) {
        this.sastanakID = sastanakID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public Kompanija getKompanija() {
        return kompanija;
    }

    public void setKompanija(Kompanija kompanija) {
        this.kompanija = kompanija;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

}
