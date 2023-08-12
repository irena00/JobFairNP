/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.stavkaUgovora;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.StavkaUgovora;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOGetAllStavkaUgovora extends AbstractSO {

    private ArrayList<StavkaUgovora> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaUgovora)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaUgovora!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> stavkeUgovora = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaUgovora>) (ArrayList<?>) stavkeUgovora;
    }

    public ArrayList<StavkaUgovora> getLista() {
        return lista;
    }

}
