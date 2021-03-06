package UM.malykhin.nure;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {


	private static final int YEAR = Calendar.YEAR - 2000;
	private static final int DAY_OF_MONTH = 9;
	private User user;
	private Date dateOfBirth;
	protected void setUp() throws Exception {
		super.setUp();
		user = new User();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(YEAR, Calendar.SEPTEMBER, DAY_OF_MONTH);
		dateOfBirth = calendar.getTime();
	}
	public void testGetFullName()
	{
		user.setFirstName("Oleksandr");
		user.setLastName("Malykhin");
		assertEquals("Malykhin, Oleksandr", user.getFullName());
	}
	public void testGetAge()

	{
		user.setDateOfBirth(dateOfBirth);
		assertEquals(19, user.getAge());
	}
	public void testGetFullInformation()
	{
		user.setFirstName("Oleksandr");
		user.setLastName("Malykhin");
		user.setEmail("Oleksandr@gmail.com");
		user.setPhone("+380123123123");
		user.setContry("Ukraine");
		user.setAdress("Kharkiv.X.X");
		assertEquals("Oleksandr, Malykhin Ukraine Kharkiv.X.X +380123123123, Oleksandr@gmail.com", user.getFullInformation());
	}
	public void  testGetContact()
	{
		user.setFirstName("Oleksandr");
		user.setLastName("Malykhin");
		user.setPhone("+380123123123");
		user.setEmail("Oleksandr@gmail.com");
		assertEquals("Oleksandr, Malykhin +380123123123, Oleksandr@gmail.com", user.getContact());
	}
}
