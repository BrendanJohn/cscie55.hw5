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
		new VideoRental(forrestGump, mikeAccount,dueDate);
		assertEquals( 1, mikeAccount.getOpenRentals().size());
	}

	//tests that hasOpenRental returns false with no rentals
	@Test
	public void testNoOpenRentals() throws VideoException{
		Account tomAccount = new Account("Tom", "Murphy", "tMurphy@gmail.com");
		assertEquals( 0, tomAccount.getOpenRentals().size());
	}

	//tests that settleRentals adds a returned video to closed rentals list
	@Test
	public void testSettleRentals() throws VideoException{
		Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
		LocalDate dueDate = LocalDate.of(2018, 11, 20);
		Video forrestGump = new Video("Forrest Gump", 1995);
		new VideoRental(forrestGump, mikeAccount,dueDate);
		mikeAccount.settleRentals();
		assertEquals( 1, mikeAccount.getClosedRentals().size());
	}

	//tests that settleRentals adds all returned video to closed rentals list
	@Test
	public void testSettleManyRentals() throws VideoException{
		Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
		LocalDate dueDate = LocalDate.of(2018, 11, 20);
		Video forrestGump = new Video("Forrest Gump", 1995);
		Video braveHeart = new Video("Brave Heart", 1995);
		new VideoRental(forrestGump, mikeAccount,dueDate);
		new VideoRental(braveHeart, mikeAccount,dueDate);
		mikeAccount.settleRentals();
		assertEquals( 2, mikeAccount.getClosedRentals().size());
	}

//	//tests that settleRental adds the returned video to closed rentals list
//	@Test
//	public void testSettleRental() throws VideoException{
//		Account billAccount = new Account("Bill", "Murphy", "billMurphy@gmail.com");
//		LocalDate dueDate = LocalDate.of(2018, 11, 20);
//		Video starWars = new Video("Star Wars", 1983);
//		VideoRental rental = new VideoRental(starWars, billAccount,dueDate);
//		billAccount.settleRental(rental);
//		assertEquals( 1, billAccount.getClosedRentals().size());
//	}

	//tests that settleRental does not function when wrong video passed in
	@Test
	public void testSettleRentalWrongVideo() throws VideoException{
		Account patAccount = new Account("Patrick", "Murphy", "pMurphy@gmail.com");
		LocalDate dueDate = LocalDate.of(2018, 11, 20);
		Video forrestGump = new Video("Forrest Gump", 1995);
		new Video("Brave Heart", 1995);
		new VideoRental(forrestGump, patAccount,dueDate);
		patAccount.settleRental("Brave Hear");
		assertEquals( 0, patAccount.getClosedRentals().size());
	}

	//tests that clear history deletes outstanding rentals
	@Test
	public void testClearHistory() throws VideoException{
		Account patAccount = new Account("Patrick", "Murphy", "pMurphy@gmail.com");
		LocalDate dueDate = LocalDate.of(2018, 11, 20);
		Video forrestGump = new Video("Forrest Gump", 1995);
		VideoRental rental = new VideoRental(forrestGump, patAccount,dueDate);
		patAccount.settleRental(rental);
		patAccount.clearHistory();
		assertEquals( 0, patAccount.getClosedRentals().size());
	}

	//tests that equals method returns false with different accounts
	@Test
	public void testEqualsNegativeScenario(){
		Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		Account mikeAccount = new Account("Mike", "Murphy", "mMurphy@gmail.com");
		assertFalse(brendanAccount.equals(mikeAccount));
	}

	//tests that equals method returns true with same accounts
	@Test
	public void testEqualsPositiveScenario(){
		Account brendanAccount = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		Account brendanAccountClone = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
		assertTrue(brendanAccount.equals(brendanAccountClone));
	}

//	//tests that hashcode returns 0 with one account
//	@Test
//	public void testHashCodeOneAccount(){
//		Account accountOne = new Account("Brendan", "Murphy", "bMurphy@gmail.com");
//		assertEquals( 0, accountOne.hashCode());
//	}
//
//	//tests thr return value of hashcode with a few accounts
//	@Test
//	public void testHashCodeManyAccount(){
//		Account accountTwo = new Account("Test1", "Murphy", "test@gmail.com");
//		Account accountThree = new Account("Test2", "Murphy", "test2@gmail.com");
//		Account accountFour = new Account("Test3", "Murphy", "test3@gmail.com");
//		assertEquals( 645651772, accountFour.hashCode());
//	}
}