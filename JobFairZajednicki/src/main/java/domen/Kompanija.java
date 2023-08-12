package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class Kompanija extends AbstractDomainObject {

    private Long kompanijaID;
    private String PIB;
    private String nazivKompanije;
    private String adresa;
    private String granaPrivrede;
    private ClanCRTima clanCRTima;

    @Override
    public String toString() {
        return nazivKompanije + " (Clan CR tima: " + clanCRTima + ")";
    }

    public Kompanija(Long kompanijaID, String PIB, String nazivKompanije, String adresa, String granaPrivrede, ClanCRTima clanCRTima) {
        this.kompanijaID = kompanijaID;
        this.PIB = PIB;
        this.nazivKompanije = nazivKompanije;
        this.adresa = adresa;
        this.granaPrivrede = granaPrivrede;
        this.clanCRTima = clanCRTima;
    }

    public Kompanija() {
    }

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

    public Long getKompanijaID() {
        return kompanijaID;
    }

    public void setKompanijaID(Long kompanijaID) {
        this.kompanijaID = kompanijaID;
    }

    public String getPIB() {
        return PIB;
    }

    public void setPIB(String PIB) {
        this.PIB = PIB;
    }

    public String getNazivKompanije() {
        return nazivKompanije;
    }

    public void setNazivKompanije(String nazivKompanije) {
        this.nazivKompanije = nazivKompanije;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGranaPrivrede() {
        return granaPrivrede;
    }

    public void setGranaPrivrede(String granaPrivrede) {
        this.granaPrivrede = granaPrivrede;
    }

    public ClanCRTima getClanCRTima() {
        return clanCRTima;
    }

    public void setClanCRTima(ClanCRTima clanCRTima) {
        this.clanCRTima = clanCRTima;
    }
}