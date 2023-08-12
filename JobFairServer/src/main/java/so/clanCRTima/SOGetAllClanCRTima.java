/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clanCRTima;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.ClanCRTima;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllClanCRTima extends AbstractSO {

    private ArrayList<ClanCRTima> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ClanCRTima)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ClanCRTima!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> clanovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<ClanCRTima>) (ArrayList<?>) clanovi;
    }

    public ArrayList<ClanCRTima> getLista() {
        return lista;
    }

}
