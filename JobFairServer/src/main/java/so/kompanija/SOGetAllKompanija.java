/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.kompanija;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Kompanija;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed to retrieve all instances of the Kompanija domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllKompanija extends AbstractSO {

    /**
     * A list of Kompanija instances retrieved from the database.
     * 
     * This ArrayList is populated during the execution of the SOGetAllKompanija class.
     */
    private ArrayList<Kompanija> lista;

    /**
     * Validates that the provided AbstractDomainObject is an instance of the Kompanija class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a Kompanija instance.
     * @throws Exception if the provided object is not an instance of Kompanija.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Kompanija)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Kompanija!");
        }
    }

    /**
     * Executes the operation to retrieve all Kompanija instances from the database.
     * 
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the Kompanija object (not used in this implementation).
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> kompanije = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Kompanija>) (ArrayList<?>) kompanije;
    }

    /**
     * Retrieves the list of Kompanija instances obtained from the database.
     *
     * @return ArrayList of Kompanija instances retrieved from the database.
     */
    public ArrayList<Kompanija> getLista() {
        return lista;
    }
}






