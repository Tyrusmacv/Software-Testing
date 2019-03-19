package test;

import org.junit.Test;

import new1.money;

import static org.junit.Assert.*;

public class calculateTest {

	
	@Test
	public void testmoney(){
		assertEquals(false,new money().check(29));
		assertEquals(false,new money().check(46));
		assertEquals(true,new money().check(17));
		assertEquals(true,new money().check(67));
		assertEquals(false,new money().check(167));
		assertEquals(false,new money().check(-8));
	}



}
