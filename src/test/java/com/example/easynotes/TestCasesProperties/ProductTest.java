/**
 * 
 */
package com.example.easynotes.TestCasesProperties;

import java.io.UnsupportedEncodingException;

import org.aspectj.lang.annotation.Before;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.easynotes.controller.FileController;
import com.example.easynotes.controller.ProductController;

/**
 * @author Electem2
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureWebMvc
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class ProductTest {
	@Autowired
	ProductController productcontrller;
	@Autowired
	private WebApplicationContext webapp;

	@Autowired
	FileController filecontroller;
	private MockMvc mockmvc;

	@Before(value = "")
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webapp).build();
	}
public void fetchById()
{
	int productId=(int)1;
	RequestBuilder rb= MockMvcRequestBuilders.get("/productapi/products/{id}")
			.accept(MediaType.APPLICATION_JSON_VALUE);
	MvcResult result;
	try {
		result = mockmvc.perform(rb).andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("Result = " +result.getResponse().getContentAsString());
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}
}
