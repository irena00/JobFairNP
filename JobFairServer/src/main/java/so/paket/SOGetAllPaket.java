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
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed to retrieve all instances of the Paket domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllPaket extends AbstractSO {

    /**
     * A list of Paket instances retrieved from the database.
     * 
     * This ArrayList is populated during the execution of the SOGetAllPaket class.
     */
    private ArrayList<Paket> lista;

    /**
     * Validates that the provided AbstractDomainObject is an instance of the Paket class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a Paket instance.
     * @throws Exception if the provided object is not an instance of Paket.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Paket)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Paket!");
        }
    }

    /**
     * Executes the operation to retrieve all Paket instances from the database.
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the Paket object (not used in this implementation).
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> paketi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Paket>) (ArrayList<?>) paketi;
    }

    /**
     * Retrieves the list of Paket instances obtained from the database.
     *
     * @return ArrayList of Paket instances retrieved from the database.
     */
    public ArrayList<Paket> getLista() {
        return lista;
    }
}
