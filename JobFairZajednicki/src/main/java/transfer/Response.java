package transfer;

import java.io.Serializable;

import transferUtil.ResponseStatus;

/**
 * The Response class represents a response, implementing the Serializable
 * interface.
 * 
 * It contains the response object, exception and response status.
 * 
 * @see Serializable
 * @author Irena Randjelovic
 */
public class Response implements Serializable{
	/**
	 * The data contained in the response.
	 */
	private Object data;
	
	/*
	 * An exception associated with the response, if any.
	 */
    private Exception exc;
    
    /**
     * The status of the response.
     */
    private ResponseStatus responseStatus;

    /**
     * Default constructor for creating an empty Response instance.
     */
    public Response() {
    }

    /**
     * Constructor for creating a Response instance with specified data, exception,
     * and response status.
     *
     * @param data           The data to be included in the response.
     * @param exc            The exception associated with the response, if any.
     * @param responseStatus The status of the response.
     */
    public Response(Object data, Exception exc, ResponseStatus responseStatus) {
        this.data = data;
        this.exc = exc;
        this.responseStatus = responseStatus;
    }

    /**
     * Get the data contained in the response.
     *
     * @return The data in the response.
     */
    public Object getData() {
        return data;
    }

    /**
     * Set the data to be included in the response.
     *
     * @param data The data to be included in the response.
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * Get the exception associated with the response, if any.
     *
     * @return The exception associated with the response, or null if no exception.
     */
    public Exception getException() {
        return exc;
    }

    /**
     * Set the exception associated with the response.
     *
     * @param exc The exception to be associated with the response.
     */
    public void setException(Exception exc) {
        this.exc = exc;
    }

    /**
     * Get the status of the response.
     *
     * @return The status of the response.
     */
    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    /**
     * Set the status of the response.
     *
     * @param responseStatus The status to be set for the response.
     */
    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
