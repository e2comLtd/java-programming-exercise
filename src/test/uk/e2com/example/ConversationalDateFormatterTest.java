package uk.e2com.example;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit Test class for {@link #ConversationalDateFormatter}
 * @author Ivan Rigoni - e2com Limited
 * @version v0.1  (12/04/14)
 *
 */
public class ConversationalDateFormatterTest {

	ConversationalDateFormatter classUnderTest;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		 classUnderTest = new ConversationalDateFormatter();
	}

	@Test
	public void testMidnight() {
		assertEquals("midnight",classUnderTest.format("00:00"));
	}
	@Test
	public void testFivePastMidnight() {
		assertEquals("five past midnight",classUnderTest.format("00:05"));
	}
	@Test
	public void testJustAfterMidnight() {
		assertEquals("just after midnight",classUnderTest.format("00:01"));
	}
	@Test
	public void quarterToMidnight() {
		assertEquals("quarter to midnight",classUnderTest.format("23:45"));
	}

}
