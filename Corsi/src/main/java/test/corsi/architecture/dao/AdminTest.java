package test.corsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import corsi.architecture.dao.AdminDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Admin;

@TestMethodOrder(OrderAnnotation.class)
class AdminTest {
	private static Connection conn;
	private static Admin admin;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
	}

	@Test
	@Order(1)
	void testUpdate() {
		try {
			System.out.println(AdminDAO.getFactory().getByCode(conn, 69420));
			admin = new Admin();
			admin.setAdminCode(69420);
			admin.setAdminName("Giovanni");
			admin.setAdminSurname("Grasso");
			admin.setAdminUsername("SoggyKey6086");
			AdminDAO.getFactory().update(conn, admin);
			System.out.println("aggiornato Admin");
			System.out.println(AdminDAO.getFactory().getByCode(conn, 69420));
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Update fallito: " + exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetByCode() {
		try {
			System.out.println("inizio getByCode");
			AdminDAO.getFactory().getByCode(conn, 69420);
			System.out.println(AdminDAO.getFactory().getByCode(conn, 69420));
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("getByCode fallito: " + exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
//			AdminDAO.getFactory().deleteByCode(conn, 69420);
			System.out.println("Eliminato articolo");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());

		}
	}
}