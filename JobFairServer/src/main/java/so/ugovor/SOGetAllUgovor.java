/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.ugovor;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Ugovor;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed to retrieve all instances of the Ugovor domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllUgovor extends AbstractSO {

    /**
     * A list of Ugovor instances retrieved from the database.
     * 
     * This ArrayList is populated during the execution of the SOGetAllUgovor class.
     */
    private ArrayList<Ugovor> lista;

    /**
     * Validates that the provided AbstractDomainObject is an instance of the Ugovor class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be an Ugovor instance.
     * @throws Exception if the provided object is not an instance of Ugovor.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Ugovor)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Ugovor!");
        }
    }

    /**
     * Executes the operation to retrieve all Ugovor instances from the database.
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the Ugovor object (not used in this implementation).
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ugovori = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Ugovor>) (ArrayList<?>) ugovori;
    }

    /**
     * Retrieves the list of Ugovor instances obtained from the database.
     *
     * @return ArrayList of Ugovor instances retrieved from the database.
     */
    public ArrayList<Ugovor> getLista() {
        return lista;
    }
}
