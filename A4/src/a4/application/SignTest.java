package a4.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SignTest {
	Spaces sp = new Spaces(4,2);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSign() {
		Sign sn = new Sign();
		assertTrue(sn.getSignStatus()==SignStatus.vacancy);
	}
	@Test
	public void testRefreshSign(){
		Sign sn = new Sign();
		sn.refreshSign(sp);
		assertTrue(sn.getSignStatus()==SignStatus.vacancy);
		sp.setNumSpaces(1);
		sn.refreshSign(sp);
		assertTrue(sn.getSignStatus()==SignStatus.full);
	}
}
