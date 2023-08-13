/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.login;

import db.DBBroker;
import domen.AbstractDomainObject;
import domen.Administrator;
import java.util.ArrayList;
import so.AbstractSO;

/**
 * This class represents a specific implementation of the AbstractSO (Abstract Service Object) pattern.
 * 
 * It is designed for handling the login process, attempting to authenticate administrators.
 * 
 * @see AbstractSO
 * @author Irena Randjelovic
 */
public class SOLogin extends AbstractSO {
    
    /**
     * The administrator who is successfully logged in after authentication.
     * 
     * This attribute is populated during the execution of the SOLogin class if the login is successful.
     */
    Administrator ulogovani;

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
     * Executes the operation to authenticate an administrator based on the provided credentials.
     * If a matching administrator is found, the 'ulogovani' attribute is populated with the authenticated administrator.
     *
     * @param ado The AbstractDomainObject representing the Administrator object (used for login credentials).
     * @throws Exception if there's an error during the authentication process or if the credentials are invalid.
     */
    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        Administrator a = (Administrator) ado;

        ArrayList<Administrator> administratori
                = (ArrayList<Administrator>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Administrator administrator : administratori) {
            if (administrator.getUsername().equals(a.getUsername())
                    && administrator.getPassword().equals(a.getPassword())) {
                ulogovani = administrator;
                return;
            }
        }

        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
    }

    /**
     * Retrieves the logged-in administrator after a successful login.
     *
     * @return The Administrator instance of the successfully authenticated administrator.
     */
    public Administrator getUlogovani() {
        return ulogovani;
    }
}
