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
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed to retrieve all instances of the StavkaUgovora domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllStavkaUgovora extends AbstractSO {

    /**
     * A list of StavkaUgovora instances retrieved from the database.
     * 
     * This ArrayList is populated during the execution of the SOGetAllStavkaUgovora class.
     */
    private ArrayList<StavkaUgovora> lista;

    /**
     * Validates that the provided AbstractDomainObject is an instance of the StavkaUgovora class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a StavkaUgovora instance.
     * @throws Exception if the provided object is not an instance of StavkaUgovora.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof StavkaUgovora)) {
            throw new Exception("Prosledjeni objekat nije instanca klase StavkaUgovor!");
        }
    }

    /**
     * Executes the operation to retrieve all StavkaUgovora instances from the database.
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the StavkaUgovora object (not used in this implementation).
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> stavkeUgovora = DBBroker.getInstance().select(ado);
        lista = (ArrayList<StavkaUgovora>) (ArrayList<?>) stavkeUgovora;
    }

    /**
     * Retrieves the list of StavkaUgovora instances obtained from the database.
     *
     * @return ArrayList of StavkaUgovora instances retrieved from the database.
     */
    public ArrayList<StavkaUgovora> getLista() {
        return lista;
    }
}
