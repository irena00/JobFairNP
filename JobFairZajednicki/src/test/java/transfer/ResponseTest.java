package transfer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import transferUtil.ResponseStatus;

class ResponseTest {

	private Response response;
	private final Object testData = "testData";
	private final Exception testException = new Exception("Test exception");
	private final ResponseStatus testResponseStatus = ResponseStatus.Success;

	@BeforeEach
	public void setUp() {
		response = new Response(testData, testException, testResponseStatus);
	}

	@AfterEach
	public void tearDown() {
		response = null;
	}

	@Test
	public void testGetData() {
		Object result = response.getData();

		assertEquals(testData, result);
	}

	@Test
	public void testSetData() {
		Object newData = 123;

		response.setData(newData);

		Object result = response.getData();
		assertEquals(newData, result);
	}

	@Test
	public void testGetException() {
		Exception result = response.getException();

		assertEquals(testException, result);
	}

	@Test
	public void testSetException() {
		Exception newException = new Exception("New test exception");

		response.setException(newException);

		Exception result = response.getException();
		assertEquals(newException, result);
	}

	@Test
	public void testGetResponseStatus() {
		ResponseStatus result = response.getResponseStatus();

		assertEquals(testResponseStatus, result);
	}

	@Test
	public void testSetResponseStatus() {
		ResponseStatus newResponseStatus = ResponseStatus.Error; 

		response.setResponseStatus(newResponseStatus);

		ResponseStatus result = response.getResponseStatus();
		assertEquals(newResponseStatus, result);
	}
}