package cscie55.hw5.rentals;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

	//tests the account creation functionality
	@Test
	public void testAccountCreation() {
		Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		assertEquals(brendanAccount.toString(),"Brendan Murphy bMurphy@gmail.com");
	}

	//tests that hasOpenRental returns true with a new rental
	@Test
	public void testAddRental() throws VideoException{
		Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
		Video forrestGump = new Video("Forrest Gump", 1995);
		LocalDate dueDate = LocalDate.of(2018, 11, 20);
		VideoRental rental = new VideoRental(forrestGump, mikeAccount,dueDate);
		assertEquals(mikeAccount.getOpenRentals().size(), 1);
	}

	//tests that hasOpenRental returns false with no rentals
	@Test
	public void testNoOpenRentals() throws VideoException{
		Account tomAccount = new Account("Tom", "Murphy", "tMurphy@gmail.com");
		Video braveHeart = new Video("Brave Heart", 1995);
		assertEquals(tomAccount.getOpenRentals().size(), 0);
	}

	//tests that settleRentals adds the returned video to closed rentals list
	@Test
	public void testSettleRental() throws VideoException{
		Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
		LocalDate dueDate = LocalDate.of(2018, 11, 20);
		Video forrestGump = new Video("Forrest Gump", 1995);
		VideoRental rental = new VideoRental(forrestGump, mikeAccount,dueDate);
		mikeAccount.settleRentals();
		assertEquals(mikeAccount.getClosedRentals().size(), 1);
	}

	//tests that equals method returns false with different accounts
	@Test
	public void testEqualsNegative(){
		Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
		assertFalse(brendanAccount.equals(mikeAccount));
	}

	//tests that equals method returns true with same accounts
	@Test
	public void testEqualsPositive(){
		Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		Account brendanAccountClone = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		assertTrue(brendanAccount.equals(brendanAccountClone));
	}
}