/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.paket;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Paket;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllPaket extends AbstractSO {

    private ArrayList<Paket> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Paket)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Paket!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> paketi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Paket>) (ArrayList<?>) paketi;
    }

    public ArrayList<Paket> getLista() {
        return lista;
    }

}
