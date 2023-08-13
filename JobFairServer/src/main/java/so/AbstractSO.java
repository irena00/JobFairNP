/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import db.DBBroker;
import domen.AbstractDomainObject;
import java.sql.SQLException;

/**
 * This abstract class provides a template for executing system operations on domain objects.
 * 
 * Subclasses must implement the validate and execute methods to define specific behavior.
 * The templateExecute method ensures that validation is performed, the operation is executed,
 * and changes are committed or rolled back in case of an exception.
 * 
 * @author Irena Randjelovic
 */
public abstract class AbstractSO {
    
	/**
     * Validates the given AbstractDomainObject before executing the operation.
     * Subclasses should provide custom validation logic.
     *
     * @param ado The AbstractDomainObject to be validated.
     * @throws Exception if validation fails or an error occurs during validation.
     */
    protected abstract void validate(AbstractDomainObject ado) throws Exception;
    
    /**
     * Executes the operation on the given AbstractDomainObject.
     * Subclasses should provide custom logic for performing the operation.
     *
     * @param ado The AbstractDomainObject on which the operation is to be executed.
     * @throws Exception if the operation fails or an error occurs during execution.
     */
    protected abstract void execute(AbstractDomainObject ado) throws Exception;

    /**
     * Executes the template for the operation on the given AbstractDomainObject.
     * This method ensures that validation is performed, the operation is executed,
     * and changes are committed or rolled back in case of an exception.
     *
     * @param ado The AbstractDomainObject on which the operation is to be executed.
     * @throws Exception if validation, execution, or committing changes fails.
     */
    public void templateExecute(AbstractDomainObject ado) throws Exception {
        try {
            validate(ado); 
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    /**
     * Commits changes to the database.
     * This method should be called after a successful operation execution.
     *
     * @throws SQLException if there's an error during the commit operation.
     */
    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    /**
     * Rolls back changes in case of an exception during the operation execution.
     *
     * @throws SQLException if there's an error during the rollback operation.
     */
    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
