package a4.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RateTest {
	double flatRate = 50;
	double standardRate = 4;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRate() {
		Rate r = new Rate(standardRate, flatRate);
		assertTrue(r.getStandardRate()==4);
		assertTrue(r.getFlatRate()==50);
	}
	@Test
	public void testRateNull(){
		Rate r = new Rate();
		assertTrue(r.getStandardRate()==0);
		assertTrue(r.getFlatRate()==0);
	}
	@Test
	public void testSetStandardRate(){
		Rate r = new Rate();
		r.setStandardRate(10);
		assertTrue(r.getStandardRate()==10);
	}
	@Test
	public void testSetFlatRate(){
		Rate r = new Rate();
		r.setFlatRate(5);
		assertTrue(r.getFlatRate()==5);
	}

}
