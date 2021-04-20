import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CoordinatesPairTest {

	@Test
	public void sanityTest() {
		assertTrue(1 == 1);
		assertEquals(Rower.explore(new CoordinatesPair(1, 1), new CoordinatesPair(1, 1)), "");
	}

	@Test
	public void basicDirections() {
		assertEquals(Rower.explore(new CoordinatesPair(1, 2), new CoordinatesPair(1, 1)), "Up (1, 2)");
		assertEquals(Rower.explore(new CoordinatesPair(1, 0), new CoordinatesPair(1, 1)), "Down (1, 0)");
		assertEquals(Rower.explore(new CoordinatesPair(2, 1), new CoordinatesPair(1, 1)), "Right (2, 1)");
		assertEquals(Rower.explore(new CoordinatesPair(0, 1), new CoordinatesPair(1, 1)), "Left (0, 1)");
	}
	
	@Test
	public void complexTest() {
		assertEquals(Rower.explore(new CoordinatesPair(2, 2), new CoordinatesPair(1, 1)), "Right (2, 1)\nUp (2, 2)");
		assertEquals(Rower.explore(new CoordinatesPair(1, 3), new CoordinatesPair(1, 1)), "Up (1, 2)\nUp (1, 3)");
		assertEquals(Rower.explore(new CoordinatesPair(2, 3), new CoordinatesPair(1, 1)),
				"Right (2, 1)\nUp (2, 2)\nUp (2, 3)");
	}

}
