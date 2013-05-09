package com.ifrins.hipstacast.parser;

import org.junit.*;

public class DurationTest {

	@Test
	public void testDurationFormat1() {
		int actualDuration = ParserUtils.convertDurationToSeconds("10:00");
		int expectedDuration = 10 * 60;
		
		Assert.assertEquals("10:00 is 600s", expectedDuration, actualDuration);
	}
	
	@Test
	public void testDurationFormat2() {
		int actualDuration = ParserUtils.convertDurationToSeconds("1:10:00");
		int expectedDuration = (1 * 3600) + (10 * 60);
		
		Assert.assertEquals("1:10:00 is 4200s", expectedDuration, actualDuration);
	}
}
