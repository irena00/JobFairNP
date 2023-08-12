package transfer;

import java.io.Serializable;

public class KlijentskiZahtev implements Serializable{
	private int operacija;
    private Object data;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operation, Object data) {
        this.operacija = operation;
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

}
