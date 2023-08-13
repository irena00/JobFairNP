/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.administrator;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Administrator;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * It is designed to retrieve all instances of the Administrator domain object from the database.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOGetAllAdministrator extends AbstractSO {

	/**
	 * A list of Administrator instances retrieved from the database.
	 * 
	 * This ArrayList is populated during the execution of the SOGetAllAdministrator class.
	 */
    private ArrayList<Administrator> lista;

    /**
     * Validates that the provided AbstractDomainObject is an instance of the Administrator class.
     *
     * @param ado The AbstractDomainObject to be validated, expected to be an Administrator instance.
     * @throws Exception if the provided object is not an instance of Administrator.
     */
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Administrator)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Administrator!");
        }
    }

    /**
     * Executes the operation to retrieve all Administrator instances from the database.
     * The retrieved instances are stored in the 'lista' field of this class.
     *
     * @param ado The AbstractDomainObject representing the Administrator object.
     * @throws Exception if there's an error during the database operation.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> administratori = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Administrator>) (ArrayList<?>) administratori;
    }

    /**
     * Retrieves the list of Administrator instances obtained from the database.
     *
     * @return ArrayList of Administrator instances retrieved from the database.
     */
    public ArrayList<Administrator> getLista() {
        return lista;
    }

}
