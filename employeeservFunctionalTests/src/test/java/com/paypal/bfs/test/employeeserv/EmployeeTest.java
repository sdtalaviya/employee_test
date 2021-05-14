package com.paypal.bfs.test.employeeserv;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.paypal.bfs.test.employeeserv.api.model.DateOfBirth;
import com.paypal.bfs.test.employeeserv.util.EmployeeErrors;
import com.paypal.bfs.test.employeeserv.util.EmployeeValidationsUtil;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeTest {
	
	@Test
	public void testDateOfBirths() {
		DateOfBirth dob = new DateOfBirth();
		dob.setDate(45);
		dob.setMonth(12);
		dob.setYear(1991);
		Assert.assertEquals(EmployeeErrors.DOB_INVALID.getErrorMessage(), EmployeeValidationsUtil.isValidDate(dob));
		
		dob.setDate(20);
		Assert.assertNull(EmployeeValidationsUtil.isValidDate(dob));
		
		dob.setYear(2050);
		Assert.assertEquals(EmployeeErrors.DOB_FUTURE.getErrorMessage(), EmployeeValidationsUtil.isValidDate(dob));
		Assert.assertEquals(EmployeeErrors.DOB_NULL.getErrorMessage(), EmployeeValidationsUtil.isValidDate(null));
	}
	
	@Test
	public void testName() {
		Assert.assertEquals(EmployeeErrors.FIRST_NAME.getErrorMessage(), EmployeeValidationsUtil
				.isValidName(null, EmployeeErrors.FIRST_NAME));
		Assert.assertEquals(EmployeeErrors.FIRST_NAME.getErrorMessage(), EmployeeValidationsUtil
				.isValidName("", EmployeeErrors.FIRST_NAME));
		Assert.assertEquals(EmployeeErrors.FIRST_NAME.getErrorMessage(), EmployeeValidationsUtil
				.isValidName("bvsvbhj868vdsv", EmployeeErrors.FIRST_NAME));

		//more than 255 chars - should throw error.
		Assert.assertEquals(EmployeeErrors.FIRST_NAME.getErrorMessage(), EmployeeValidationsUtil
				.isValidName("bvbvsvbhj868hj868vdsvbvsvbh868vdsvbvsvbhj868vdsvbvsvbhj868vdsvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsvbvsvbhj868vdsv", EmployeeErrors.FIRST_NAME));
		Assert.assertNull(EmployeeValidationsUtil.isValidName("Omkar", EmployeeErrors.FIRST_NAME));
	}
	
	@Test
	public void testCity() {
		Assert.assertEquals(EmployeeErrors.ADDRESS_CITY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCityOrState(null, EmployeeErrors.ADDRESS_CITY));
		Assert.assertEquals(EmployeeErrors.ADDRESS_CITY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCityOrState("", EmployeeErrors.ADDRESS_CITY));
		Assert.assertEquals(EmployeeErrors.ADDRESS_CITY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCityOrState("bvsvbhj868vdsv", EmployeeErrors.ADDRESS_CITY));
		// max 100 char allowed.
		Assert.assertEquals(EmployeeErrors.ADDRESS_CITY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCityOrState("adfakqlsdjflkasjdflkajdfklajldksfjlkasdjflkajdsfljaldjflaksdjflajdasdjflkasdjflkjasadsfsdfsdfdfjlasdf", EmployeeErrors.ADDRESS_CITY));
		Assert.assertNull(EmployeeValidationsUtil.isValidCityOrState("Thane", EmployeeErrors.ADDRESS_CITY));
	}
	
	@Test
	public void testConutry() {
		Assert.assertEquals(EmployeeErrors.ADDRESS_CONUTRY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCountry(null));
		Assert.assertEquals(EmployeeErrors.ADDRESS_CONUTRY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCountry(""));
		Assert.assertEquals(EmployeeErrors.ADDRESS_CONUTRY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCountry("bvsvbhj868vdsv"));
		// max 60 char allowed.
		Assert.assertEquals(EmployeeErrors.ADDRESS_CONUTRY.getErrorMessage(), EmployeeValidationsUtil
				.isValidCountry("adskjfhajddasdfasdfasdfksdhfjkasdhfkjashdfjkhaskjdfhkasdfasdf"));
		Assert.assertNull(EmployeeValidationsUtil.isValidCountry("India"));
	}
	
	@Test
	public void testZipCode() {
		Assert.assertEquals(EmployeeErrors.ADDRESS_ZIP_CODE.getErrorMessage(), EmployeeValidationsUtil
				.isValidZipCode(null));
		Assert.assertEquals(EmployeeErrors.ADDRESS_ZIP_CODE.getErrorMessage(), EmployeeValidationsUtil
				.isValidZipCode(""));
		//non-digits not allowed
		Assert.assertEquals(EmployeeErrors.ADDRESS_ZIP_CODE.getErrorMessage(), EmployeeValidationsUtil
				.isValidZipCode("bvsvbhj868vdsv"));
		Assert.assertEquals(EmployeeErrors.ADDRESS_ZIP_CODE.getErrorMessage(), EmployeeValidationsUtil
				.isValidZipCode("40014"));
		
		// max 20 allowed
		Assert.assertEquals(EmployeeErrors.ADDRESS_ZIP_CODE.getErrorMessage(), EmployeeValidationsUtil
				.isValidZipCode("121212121212121212121"));
		Assert.assertNull(EmployeeValidationsUtil.isValidZipCode("400615"));
	}
	
}
