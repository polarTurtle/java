package com.cache.cachingstring;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@ComponentScan("com.cache.cachingstring")
@AutoConfigureMockMvc
public class PlainWebTest {
	
	@Autowired
	CacheImplementation queueCache;

	@Autowired
	MockMvc mvc;

	@LocalServerPort
	private int port;

	@Test
	void contextLoads() {
	}

	@Test
	public void contextLoad() throws Exception {
		assertNotNull(queueCache);
		assertNotNull(port);
	}
	
	@Test
	public void defaultMessage() {
		mvc.perform(get)
		.andExpect(status().isOk());
		
		this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hello, World")));
	}

}
