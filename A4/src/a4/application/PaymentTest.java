package a4.application;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PaymentTest {
	PaymentType paymentType= PaymentType.cash;
	double amountDue=45;
	double originalAmountDue;
	Date paymentDate;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPayment() {
		Payment p = new Payment(amountDue, paymentType);
		assertTrue(p.getAmountDue()==45);
		assertTrue(p.getOriginalAmountDue()==45);
	}
}
