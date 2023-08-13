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
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed for updating an existing Ugovor (contract) instance in the database, including its associated stavke (items).
 * 
 * @see AbstractSO
 * @author Irena Randjelovic	
 */
public class SOUpdateUgovor extends AbstractSO {

	/**
     * Validates that the provided AbstractDomainObject is an instance of the Ugovor class
     * and enforces specific business rules for contract update.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a Ugovor instance.
     * @throws Exception if the provided object is not an instance of Ugovor or if the contract does not meet the specified business rules.
     */
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

    /**
     * Executes the operation to update an existing Ugovor instance in the database,
     * including updating associated stavke (items) and handling the addition and deletion of stavke.
     *
     * @param ado The AbstractDomainObject representing the Ugovor object to be updated in the database.
     * @throws Exception if there's an error during the database update process or handling stavke.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        // izmenimo ugovor
        DBBroker.getInstance().update(ado);
        Ugovor u = (Ugovor) ado;
        
        // obrisemo stare stavke
               DBBroker.getInstance().delete(u.getStavkeUgovora().get(0));

        // dodamo nove
        for (StavkaUgovora stavkaUgovora : u.getStavkeUgovora()) {
            DBBroker.getInstance().insert(stavkaUgovora);
        }
    }

}
