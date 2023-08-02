package com.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class BoottestdemoappApplicationTests {
private Calculator calculator=new Calculator();
	@Test
	void contextLoads() {
	}

	@Test
	@Disabled //if we dont want to test this particular method then we use this annotation
	void testSum(){
		//expected Result
		int expectedResult=17;
		//actual result
		int actualResult=calculator.doSum(12,3,2);

		assertThat(actualResult).isEqualTo(expectedResult);

	}
	@Test
	void testProduct(){
		int expectedResult=6;
		int actualResult=calculator.doProduct(3,2);
		assertThat(actualResult).isEqualTo(expectedResult);

	}
    @Test
	void testCompareNums(){
		Boolean actualResult=calculator.compareTwoNumbers(3,3);
		assertThat(actualResult).isTrue();
	}

}
