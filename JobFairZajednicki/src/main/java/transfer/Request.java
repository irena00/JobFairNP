package transfer;

import java.io.Serializable;

/**
 * The Request class represents a request to perform an operation, implementing
 * the Serializable interface.
 *
 * <p>
 * It contains information about the operation to be performed and the
 * associated object.
 * </p>
 *
 * @see Serializable
 * @author Irena Randjelovic
 */

public class Request implements Serializable{
	
	/**
	 * The operation associated with the request.
	 */
	private int operacija;

	/**
	 * The data associated with the request.
	 */
    private Object data;

    /**
	 * Constructs an empty Request object.
	 */
    public Request() {
    }

    /**
     * Constructs a new Request object with the specified operation and data.
     *
     * @param operation The operation code that defines the type of operation for the request.
     * @param data The data associated with the request, which can be of any object type.
     */
    public Request(int operation, Object data) {
        this.operacija = operation;
        this.data = data;
    }
    
    /**
	 * Returns the operation of the request.
	 *
	 * @return The operation.
	 */
    public Object getData() {
        return data;
    }
    
    /**
	 * Sets the operation of the request.
	 *
	 * @param operation The operation to be set.
	 */
    public int getOperacija() {
        return operacija;
    }
    
    /**
	 * Returns the data associated with the request.
	 *
	 * @return The associated data.
	 */
    public void setData(Object data) {
        this.data = data;
    }
    
    /**
	 * Returns the data associated with the request.
	 *
	 * @return The associated data.
	 */
    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

}
