/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.clanCRTima;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.ClanCRTima;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed to retrieve all instances of the ClanCRTima domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllClanCRTima extends AbstractSO {

    /**
     * A list of ClanCRTima instances retrieved from the database.
     * 
     * This ArrayList is populated during the execution of the SOGetAllClanCRTima class.
     */
    private ArrayList<ClanCRTima> lista;

    /**
     * Validates that the provided AbstractDomainObject is an instance of the ClanCRTima class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be a ClanCRTima instance.
     * @throws Exception if the provided object is not an instance of ClanCRTima.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ClanCRTima)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ClanCRTima!");
        }
    }

    /**
     * Executes the operation to retrieve all ClanCRTima instances from the database.
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the ClanCRTima object (not used in this implementation).
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> clanovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<ClanCRTima>) (ArrayList<?>) clanovi;
    }

    /**
     * Retrieves the list of ClanCRTima instances obtained from the database.
     *
     * @return ArrayList of ClanCRTima instances retrieved from the database.
     */
    public ArrayList<ClanCRTima> getLista() {
        return lista;
    }
}
