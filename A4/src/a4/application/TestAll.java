package a4.application;
 
import org.junit.runner.RunWith; 
import org.junit.runners.Suite; 
 
@RunWith(Suite.class) 
@Suite.SuiteClasses({ 
	CashPaymentTest.class, ElectronicPaymentTest.class, EmployeeTest.class, GarageTest.class, 
	GateTest.class, PaymentTest.class, RateTest.class, SignTest.class, SpacesTest.class, 
	TicketTest.class
}) 
public class TestAll  
{  	 
} 

