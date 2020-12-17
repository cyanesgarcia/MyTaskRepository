/*package com.dar.everisdarmytasksms.spike;


import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

class JsonAssertTest {
	String actualResponse = "{\"id\":1,\"task_status\":\"Pending\",\"description\":\"Backend, microservicios con Spring boot.\"}";

	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"task_status\":\"Pending\",\"description\":\"Backend, microservicios con Spring boot.\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}

	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"task_status\":\"Pending\"}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id: 1, task_status: Pending}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}

}
*/