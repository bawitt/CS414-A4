package a4.application;

import static org.junit.Assert.*;

import org.joda.time.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TicketTest {
	int id=5;
	Rate r = new Rate(4,100);

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testTicket() {
		//Rate r = new Rate(4,100);
		Ticket tn = new Ticket(id, r);
		assertTrue(tn.getID() == id);
		assertTrue(tn.getTicketStandardRate()==r.getStandardRate());
	}
	@Test
	public void testTicketNull() {
		Ticket tn = new Ticket();
		assertTrue(tn.getID()==-1);
	}
	@Test
	public void testGetDurationHours() {
		//Rate r = new Rate(4,100);
		Ticket tn = new Ticket(id, r);
		DateTime paymentDate = new DateTime();
		tn.setPaymentDate(paymentDate);
		assertTrue(tn.getDurationHours()==1);
	}
	@Test
	public void testGetAmountDue(){
		Ticket tn = new Ticket(id, r);
		DateTime paymentDate = new DateTime();
		tn.setPaymentDate(paymentDate);
		assertTrue(tn.getAmountDue()==(r.getStandardRate()*tn.getDurationHours()));
	}
}
