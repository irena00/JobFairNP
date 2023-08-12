/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sastanak;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Sastanak;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOAddSastanak extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Sastanak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Sastanak!");
        }

        Sastanak s = (Sastanak) ado;

        if (!s.getDatumVreme().after(new Date())) {
            throw new Exception("Datum i vreme sastanka mora biti u buducnosti!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }

}
