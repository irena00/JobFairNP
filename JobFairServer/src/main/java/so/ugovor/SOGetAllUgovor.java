/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ugovor;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Ugovor;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllUgovor extends AbstractSO {

    private ArrayList<Ugovor> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Ugovor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ugovor!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ugovori = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Ugovor>) (ArrayList<?>) ugovori;
    }

    public ArrayList<Ugovor> getLista() {
        return lista;
    }

}
