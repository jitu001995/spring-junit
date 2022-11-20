package com.jk.unittesting.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.jk.model.Item;
import com.jk.repo.ItemRepository;


@DataJpaTest
public class ItemRepositoryTest {
     
	@Mock
	private ItemRepository repository;
	
	@Test
	public void testFindAll() {
		List<Item> items = repository.findAll();
	    assertEquals(2,items.size());
	}
	
}
