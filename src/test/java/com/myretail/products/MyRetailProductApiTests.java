package com.myretail.products;

import com.myretail.products.model.PriceDetails;
import com.myretail.products.model.ProductDetailsResponse;
import com.myretail.products.model.ProductPriceRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MyRetailProductDetailsApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyRetailProductApiTests {

	@LocalServerPort
	private int port;

	private String PRODUCT_DETAILS_URL = "/product-details/products/";
	private String PRODUCT_ID = "13860428";
	private String INVALID_PRODUCT_ID = "13860.428";
	ProductPriceRequest request = new ProductPriceRequest();
	@Before
	public void setUp(){
		RestAssured.port = this.port;
		request.setCurrencyCode("USD");
		request.setValue(new BigDecimal("25.78"));
	}

	@Test
	public void testRetrieveProductDetails_WithSuccessCriteria() {
		RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.get(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void testRetrieveProductDetails_WithInvalidProductId_ExpectException() {
		RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.get(PRODUCT_DETAILS_URL + INVALID_PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("reasonCode", equalTo(HttpStatus.BAD_REQUEST.name()));
	}

	@Test
	public void testRetrieveProductDetails_WithEmptyProductId_ExpectException() {
		RestAssured.given()
				.contentType(ContentType.JSON)
				.when()
				.get(PRODUCT_DETAILS_URL)
				.then()
				.statusCode(HttpStatus.NOT_FOUND.value())
				.body(Matchers.containsString("HTTP Status 404 – Not Found"));
	}

	@Test
	public void testUpdateProductDetails_WithSuccessCriteria() {
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(request)
				.put(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void testUpdateProductDetails_WithEmptyRequestBody_ExpectException() {
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(new ProductPriceRequest())
				.put(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("reasonCode", equalTo(HttpStatus.BAD_REQUEST.name()));
	}

	@Test
	public void testUpdateProductDetails_WithEmptyProductId_ExpectException() {
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(request)
				.put(PRODUCT_DETAILS_URL)
				.then()
				.statusCode(HttpStatus.NOT_FOUND.value())
				.body(Matchers.containsString("HTTP Status 404 – Not Found"));
	}

	@Test
	public void testUpdateProductDetails_WithInvalidFormatOfRequestBody_ExpectException() {
		ProductDetailsResponse productDetails = new ProductDetailsResponse();
		productDetails.setName("Test");
		productDetails.setPriceDetails(new PriceDetails());
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(productDetails)
				.put(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("reasonCode", equalTo(HttpStatus.BAD_REQUEST.name()));
	}

	@Test
	public void testUpdateProductDetails_WithValidFormatOfRequestBody_EmptyCurrencyCode_ExpectException() {
		request.setCurrencyCode("");
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(request)
				.put(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("reasonCode", equalTo(HttpStatus.BAD_REQUEST.name()));
	}

	@Test
	public void testUpdateProductDetails_WithValidFormatOfRequestBody_InvalidCurrencyCode_ExpectException() {
		request.setCurrencyCode("USDN");
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(request)
				.put(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("reasonCode", equalTo(HttpStatus.BAD_REQUEST.name()));
	}

	@Test
	public void testUpdateProductDetails_WithValidFormatOfRequestBody_InvalidPriceValue_ExpectException() {
		request.setValue(new BigDecimal("12334343234234.4342342342"));
		RestAssured.given().when()
				.contentType(ContentType.JSON)
				.body(request)
				.put(PRODUCT_DETAILS_URL + PRODUCT_ID)
				.then()
				.statusCode(HttpStatus.BAD_REQUEST.value())
				.body("reasonCode", equalTo(HttpStatus.BAD_REQUEST.name()));
	}
}
