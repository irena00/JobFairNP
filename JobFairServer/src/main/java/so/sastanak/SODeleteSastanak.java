/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sastanak;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Sastanak;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * It is designed for deleting an existing Sastanak (meeting) instance from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SODeleteSastanak extends AbstractSO {

	 /**
     * Validates that the provided AbstractDomainObject is an instance of the Sastanak class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a Sastanak instance.
     * @throws Exception if the provided object is not an instance of Sastanak.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Sastanak)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Sastanak!");
        }
    }

    /**
     * Executes the operation to delete an existing Sastanak instance from the database.
     *
     * @param ado The AbstractDomainObject representing the Sastanak object to be deleted from the database.
     * @throws Exception if there's an error during the database deletion process.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
