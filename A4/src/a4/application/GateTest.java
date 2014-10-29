package a4.application;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GateTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGate() {
		Gate g = new Gate(GateType.exit);
		assertTrue(g.getGateOpenStatus()==false);
		assertTrue(g.getType()==GateType.exit);
	}
	@Test
	public void testCloseGate(){
		Gate g = new Gate(GateType.exit);
		g.closeGate();
		assertTrue(g.getGateOpenStatus()==false);	
	}
	@Test
	public void testOpenGate(){
		Gate g = new Gate(GateType.exit);
		g.openGate();
		assertTrue(g.getGateOpenStatus()==true);	
	}
}
