/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.sastanak;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Sastanak;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed to retrieve all instances of the Sastanak domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllSastanak extends AbstractSO {

    /**
     * A list of Sastanak instances retrieved from the database.
     * 
     * This ArrayList is populated during the execution of the SOGetAllSastanak class.
     */
    private ArrayList<Sastanak> lista;

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
     * Executes the operation to retrieve all Sastanak instances from the database.
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the Sastanak object (not used in this implementation).
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> sastanci = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Sastanak>) (ArrayList<?>) sastanci;
    }

    /**
     * Retrieves the list of Sastanak instances obtained from the database.
     *
     * @return ArrayList of Sastanak instances retrieved from the database.
     */
    public ArrayList<Sastanak> getLista() {
        return lista;
    }
}
