import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BackPackTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMain() {
		fail("Not yet implemented");
	}

	@Test
	public void testBackPack_Solution() {
		int[][] arre = {{0,0,4,4,4,4,4,4,4,4},{0,0,4,5,5,5,9,9,9,9},{0,0,4,5,6,6,9,10,11,11}};
		assertEquals(arre, BackPack_Solution(10,3, {3, 4, 5},{4, 5, 6});
	}

}
