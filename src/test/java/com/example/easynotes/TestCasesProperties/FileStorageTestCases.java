package com.example.easynotes.TestCasesProperties;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Path;

import org.aspectj.lang.annotation.Before;
import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMultipartHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import com.example.easynotes.controller.FileController;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@AutoConfigureWebMvc

class FileStorageTestCases {
	@Autowired
	private WebApplicationContext webapp;

	@Autowired
	FileController filecontroller;
	private MockMvc mockmvc;

	@Before(value = "")
	public void setUp() {
		mockmvc = MockMvcBuilders.webAppContextSetup(webapp).build();
	}

	@Test
	public void firstUploadWordsTest() throws Exception {
		  FileInputStream fis = new FileInputStream("F:/1Risk.txt");
		    MockMultipartFile multipartFile = new MockMultipartFile("file", fis);
		filecontroller.uploadFile(multipartFile);
//		MockMultipartHttpServletRequestBuilder multipartRequest =
//			      MockMvcRequestBuilders.multipart("/UploadFiles");
	}

}
