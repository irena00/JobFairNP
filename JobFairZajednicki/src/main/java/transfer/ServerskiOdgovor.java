package transfer;

import java.io.Serializable;

import transferUtil.ResponseStatus;

public class ServerskiOdgovor implements Serializable{
	private Object data;
    private Exception exc;
    private ResponseStatus responseStatus;

    public ServerskiOdgovor() {
    }

    public ServerskiOdgovor(Object data, Exception exc, ResponseStatus responseStatus) {
        this.data = data;
        this.exc = exc;
        this.responseStatus = responseStatus;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Exception getException() {
        return exc;
    }

    public void setException(Exception exc) {
        this.exc = exc;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }
}
