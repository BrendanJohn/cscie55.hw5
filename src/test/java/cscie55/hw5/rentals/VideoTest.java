package cscie55.hw5.rentals;

import org.junit.Test;

import static org.junit.Assert.*;

public class VideoTest {

	//tests the video creation functionality
	@Test
	public void testVideoCreation() throws VideoException{
		Video newVideo = new Video("E.T.", 1988);
		assertEquals("E.T.", newVideo.getTitle());
	}

	//tests the video to string functionality
	@Test
	public void testVideoToString() throws VideoException{
		Video newVideo = new Video("E.T.", 1988);
		assertEquals("E.T.: 1988 is AVAILABLE", newVideo.toString());
	}

	//tests the video availability
	@Test
	public void testVideoAvailability() throws VideoException{
		Video etVideo = new Video("E.T.", 1988);
		assertTrue(etVideo.isAvailable());
	}

	//tests the video unavailable
	@Test
	public void testVideoAvailabilityNegative() throws VideoException{
		Video etVideo = new Video("E.T.", 1988);
		etVideo.checkOut();
		assertFalse(etVideo.isAvailable());
	}

	//tests the video unavailable
	@Test
	public void testVideoIsNotAvailable() throws VideoException{
		Video etVideo = new Video("E.T.", 1988);
		etVideo.checkOut();
		assertTrue(etVideo.isNotAvailable());
	}

	//tests the video equals functionality
	@Test
	public void testVideoEquals() throws VideoException{
		Video etVideo = new Video("E.T.", 1988);
		Video etVideoDuplicate = new Video("E.T.", 1988);
		etVideo.checkOut();
		assertTrue(etVideo.equals(etVideoDuplicate));
	}

	//tests the video equals functionality negative case
	@Test
	public void testVideoEqualsNegative() throws VideoException{
		Video etVideo = new Video("E.T.", 1988);
		Video indianaJones = new Video("Indiana Jones", 1988);
		etVideo.checkOut();
		assertFalse(etVideo.equals(indianaJones));
	}

	//tests the video check in functionality
	@Test
	public void testVideoCheckIn() throws VideoException{
		Video etVideo = new Video("E.T.", 1988);
		etVideo.checkOut();
		etVideo.checkIn();
		assertTrue(etVideo.isAvailable());
	}

	//tests the video check in functionality negative case
	@Test
	public void testVideoCheckInNegative() throws VideoException{
		Video indianaJones = new Video("Indiana Jones", 1988);
		indianaJones.checkOut();
		indianaJones.checkIn();
		indianaJones.checkOut();
		assertTrue(indianaJones.isNotAvailable());
	}

	//tests the video remove from stock and add it back it
	@Test
	public void testAddFromStock() throws VideoException{
		Video empireStrikesBack = new Video("The Empire Strikes Back", 1980);
		empireStrikesBack.removeFromStock();
		empireStrikesBack.replaceToStock();
		assertTrue(empireStrikesBack.isAvailable());
	}

	//tests remove video from stock should be unavailable
//	@Test
//	public void testRemoveFromStock() throws VideoException{
//		Video empireStrikesBack = new Video("The Empire Strikes Back", 1980);
//		empireStrikesBack.removeFromStock();
//		assertTrue(empireStrikesBack.isNotAvailable());
//	}

		//tests the video creation functionality
//		@Test
//		public void testDuplicateTitle{
//			try  {
//				Video newVideo = new Video("E.T.", 1988);
//				fail();
//			}
//			catch (VideoException videoException){
//				//Expected
//			}
//		}
}
