//package com.prajyot.product;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.DynamicPropertyRegistry;
//import org.springframework.test.context.DynamicPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.testcontainers.containers.MongoDBContainer;
//import org.testcontainers.junit.jupiter.Container;
//import org.testcontainers.utility.DockerImageName;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.prajyot.product.dto.CreateProductRequest;
//import com.prajyot.product.repository.ProductRepository;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//class ProductServiceApplicationTests {
//
//	@Autowired
//	private ProductRepository repository;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//	private ObjectMapper mapper;
//
//	@Container
//	static MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo"));
//
//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
//		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//	}
//
//	static {
//		mongoDBContainer.start();
//	}
//
//	@Test
//	void contextLoads() throws JsonProcessingException, Exception {
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create").contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(getProductRequest()))).andExpect(status().isCreated());
//		assertEquals("iphone 13", repository.findByModel("iphone 13").getModel());
//	}
//
//	private CreateProductRequest getProductRequest() {
//		return CreateProductRequest.builder().name("Mobile").brandName("Apple").category("Electronics")
//				.model("iphone 13").price(Double.valueOf("120000")).build();
//	}
//
//	private CreateProductRequest getProductRequest2() {
//		return CreateProductRequest.builder().name("Mobile").brandName("Apple").category("Electronics")
//				.model("iphone 14").price(Double.valueOf("140000")).build();
//	}
//
//	@Test
//	void TestFindAll() throws JsonProcessingException, Exception {
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create").contentType(MediaType.APPLICATION_JSON)
//				.content(mapper.writeValueAsString(getProductRequest2()))).andExpect(status().isCreated())
//				.andDo(result -> mockMvc.perform(
//						MockMvcRequestBuilders.get("/api/product/all-Products").contentType(MediaType.APPLICATION_JSON))
//						.andExpect(status().isOk()));
//		assertEquals(getProductRequest2().getModel(), repository.findByModel("iphone 14").getModel());
//	}
//}
