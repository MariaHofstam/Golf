package lexicon.se.maria.Golf;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GolfTest {

	@Test
	public void test_getDistance() {
		double givenAngle = 45;
		double givenVelocity = 56;
		
		double expectedDistance = 320;
		
		assertEquals(expectedDistance, Golf.calculateDistance(givenVelocity, givenAngle), 0);
	}
}
	
	