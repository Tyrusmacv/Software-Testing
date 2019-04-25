
import mujavatest.BubbleSort;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;

import java.io.ByteArrayOutputStream;

import java.io.IOException;

import java.io.InputStream;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;

import java.io.PipedInputStream;


import java.util.Scanner;

 

import org.hamcrest.core.AllOf;
import org.junit.After;
import org.junit.Before;

import org.junit.Test;


public class BubbleSortTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBubbleSort() {
		int[] aee = {1,2,4,8,9};
		assertEquals(aee, BubbleSort{2,4,9,1,8});
	}



	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

}
