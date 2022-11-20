package com.jk.unittesting.controller.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
   
	String actualResponse = "{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":20}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse="{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":20}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
	
	@Test
	public void jsonAssert_StrictFalse() throws JSONException {
		String expectedResponse="{\"id\":1,\"name\":\"ball\",\"price\":10,\"quantity\":20}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	
	@Test
	public void jsonAssert_WithoutEscapseCharacters() throws JSONException {
		String expectedResponse="{id:1,name:ball,price:10,quantity:20}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
	}
} 
 