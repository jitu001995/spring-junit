package com.jk.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jk.controller.ItemController;
import com.jk.model.Item;
import com.jk.service.ItemBusinessService;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	 
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService;
	
	@Test
	public void HelloWorld_Basic() throws Exception {
		when(businessService.retrieveHarCodedItem()).thenReturn(
				new Item(2,"Item2",20,20)
				);
		
		RequestBuilder request = MockMvcRequestBuilders.get("/service")
				                  .accept(MediaType.APPLICATION_JSON);	
	     MvcResult result = mockMvc.perform(request)
	    		 .andExpect(status().isOk())
	    		 .andExpect(content().json("{id:2,name:Item2,price:20,quantity:20}"))
	    		 .andReturn();
	           
	         //JSONAssert.assertEquals(xpected,result.getResponse().getContentAsString(),false);
	      
	     //verify "hello world"
	     //assertEquals("hello world", result.getResponse().getContentAsString());
	}
	
	//Testing service method
	
	@Test
	public void retrieveAllItems_baic() throws Exception {
		when(businessService.retrieveAllItem()).thenReturn(
				Arrays.asList(new Item(101,"Item1",100,10),
						new Item(102,"Item2",200,20))
				
				);
		
		RequestBuilder request = MockMvcRequestBuilders
				                 .get("/getAll")
				                 .accept(MediaType.APPLICATION_JSON);
		                          
	    MvcResult  result = mockMvc.perform(request)
	    		            .andExpect(status().isOk())
	    		            .andExpect(content().json("[{id:101,name:Item1,price:100},{id:102,name:Item2,price:200}]"))
	    		            .andReturn();
				    
	}

}
