package transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequestTest {

	private Request request;

	@BeforeEach
	public void setUp() {
		int operation = 1;
		Object obj = "object";
		request = new Request(operation, obj);
	}

	@AfterEach
	public void tearDown() {
		request = null;
	}

	@Test
	public void testGetOperacija() {
		int result = request.getOperacija();

		assertEquals(1, result); 
	}

	@Test
	public void testSetOperacija() {
		int newOperation = 2; 
		request.setOperacija(newOperation);

		int result = request.getOperacija();
		assertEquals(2, result); 
	}

	@Test
	public void testGetData() {
		Object result = request.getData();

		assertEquals("object", result);
	}

	@Test
	public void testSetData() {
		Object newObj = 123;

		request.setData(newObj);

		Object result = request.getData();
		assertEquals(123, result);
	}

	@Test
	public void testToString() {
		String expected = "Request{operacija=" + 1 + ", data=object}"; 
		String result = request.toString();

		assertEquals(expected, result);
	}
}
