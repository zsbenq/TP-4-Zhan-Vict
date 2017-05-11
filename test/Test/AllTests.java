package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Copy_test.class, Event_test.class, Fakedatabase_test.class, Hold_test.class, MainController_test.class,
		Order_test.class, Patron_test.class, Payment_test.class, Receipt_test.class, Rentalline_test.class,
		SaleLineItem_test.class, Store_test.class, Textbook_test.class, Worker_test.class })
public class AllTests {

}
