package UM.malykhin.nure.db;

import junit.framework.TestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import UM.malykhin.nure.User;


public class HsqldbUserDaoTest extends TestCase{
	HsqldbUserDao dao;
	
	
	
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		dao = new HsqldbUserDao();
	}




	public void testCreate() {
		try {
			User user = new User();
			user.setFirstName("Sasha");
			user.setLastName("Malykhin");
			user.setDateOfBirth(new Date());
			assertNull(user.getId());
			user = dao.create(user);
			assertNotNull(user);
			assertNotNull(user.getId());
		} catch (DatabaseException e) {
			e.printStackTrace();
			fail(e.toString());
		}
	}
}