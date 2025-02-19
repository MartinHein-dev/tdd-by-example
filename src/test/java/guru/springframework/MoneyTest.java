package guru.springframework;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

public class MoneyTest {
	
	@Test
	void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15), five.times(3));
		
		Money fiveF = Money.franc(5);
		assertEquals(Money.franc(10), fiveF.times(2));
		assertEquals(Money.franc(15), fiveF.times(3));
	}
	
	@Test
	void testEquality() {
		assertEquals(Money.dollar(5), Money.dollar(5));
		assertNotEquals(Money.dollar(5), Money.dollar(8));
		assertEquals(Money.franc(5), Money.franc(5));
		assertNotEquals(Money.dollar(5), Money.franc(5));
	}
	
	
	@Test
	void testCurrency() {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());
	}
	
	@Test
	void testSimpleAddition() {
		Money five =  Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}
	
}
