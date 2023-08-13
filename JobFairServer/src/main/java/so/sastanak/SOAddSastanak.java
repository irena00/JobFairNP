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
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed for adding a new Sastanak (meeting) instance to the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOAddSastanak extends AbstractSO {

    /**
     * Validates that the provided AbstractDomainObject is an instance of the Sastanak class
     * and that the meeting's date and time are in the future.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a Sastanak instance.
     * @throws Exception if the provided object is not an instance of Sastanak or if the meeting's date and time are not in the future.
     */
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

    /**
     * Executes the operation to insert a new Sastanak instance into the database.
     *
     * @param ado The AbstractDomainObject representing the Sastanak object to be added to the database.
     * @throws Exception if there's an error during the database insertion process.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().insert(ado);
    }
}






