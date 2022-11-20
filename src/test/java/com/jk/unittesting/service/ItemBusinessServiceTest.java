package com.jk.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jk.model.Item;
import com.jk.repo.ItemRepository;
import com.jk.service.ItemBusinessService;

//@ExtendWith(MockitoJUnitRunner.class)
@DataJpaTest
public class ItemBusinessServiceTest {
   
	@InjectMocks
	private ItemBusinessService business;
	
	@Mock
	private ItemRepository repository;
	
	@Test
	public void getAllDataFromServiceTest() {
		when(repository.findAll()).thenReturn(
				Arrays.asList(new Item(101,"Item1",100,10),
						new Item(102,"Item2",200,20))
				);
	
		List<Item> items = business.retrieveAllItem();
		assertEquals(1000,items.get(0).getValuel());
		assertEquals(4000,items.get(1).getValuel());
	}
}
