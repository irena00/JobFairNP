package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClanCRTima extends AbstractDomainObject{
	private Long clanID;
    private String imeClana;
    private String prezimeClana;
    private String email;
    private String telefon;

    @Override
    public String toString() {
        return imeClana + " " + prezimeClana;
    }

    public ClanCRTima(Long clanID, String imeClana, String prezimeClana, String email, String telefon) {
        this.clanID = clanID;
        this.imeClana = imeClana;
        this.prezimeClana = prezimeClana;
        this.email = email;
        this.telefon = telefon;
    }

    public ClanCRTima() {
    }

    @Override
    public String nazivTabele() {
        return " ClanCRTima ";
    }

    @Override
    public String alijas() {
        return " cr ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<AbstractDomainObject>();

        while (rs.next()) {
            ClanCRTima cr = new ClanCRTima(rs.getLong("ClanID"),
                    rs.getString("ImeClana"), rs.getString("PrezimeClana"),
                    rs.getString("Email"), rs.getString("Telefon"));

            lista.add(cr);
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
        return " ClanID = " + clanID;
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

    public Long getClanID() {
        return clanID;
    }

    public void setClanID(Long clanID) {
        this.clanID = clanID;
    }

    public String getImeClana() {
        return imeClana;
    }

    public void setImeClana(String imeClana) {
        this.imeClana = imeClana;
    }

    public String getPrezimeClana() {
        return prezimeClana;
    }

    public void setPrezimeClana(String prezimeClana) {
        this.prezimeClana = prezimeClana;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

}
