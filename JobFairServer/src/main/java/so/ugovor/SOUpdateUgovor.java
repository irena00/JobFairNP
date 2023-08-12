/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ugovor;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.StavkaUgovora;
import domen.Ugovor;
import java.util.Date;
import so.AbstractSO;

/**
 *
 * @author PC
 */
public class SOUpdateUgovor extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Ugovor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ugovor!");
        }

        Ugovor u = (Ugovor) ado;

        if (u.getDatumZakljucenja().after(new Date())) {
            throw new Exception("Datum zakljucenja ugovora ne sme biti posle danasnjeg datuma!");
        }

        if (u.getStavkeUgovora().isEmpty()) {
            throw new Exception("Ugovor mora imati barem jednu stavku!");
        }
        
        for (StavkaUgovora stavkaUgovora : u.getStavkeUgovora()) {
            if (stavkaUgovora.getCenaStavke() < 10000 || stavkaUgovora.getCenaStavke() > 100000) {
                throw new Exception("Cena stavke mora biti izmedju 10000din i 100000din!");
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        // izmenimo ugovor
        DBBroker.getInstance().update(ado);

        Ugovor u = (Ugovor) ado;
        // obrisemo stare stavke
        // sledeca linija koda izvrsava naredbu
        // DELETE FROM STAVKAUGOVORA WHERE UGOVORID = nasID
        // cime se brisu SVE stavke naseg ugovora ODJEDNOM !!!
        DBBroker.getInstance().delete(u.getStavkeUgovora().get(0));

        // dodamo nove
        for (StavkaUgovora stavkaUgovora : u.getStavkeUgovora()) {
            DBBroker.getInstance().insert(stavkaUgovora);
        }
    }

}
