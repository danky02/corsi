package test.corsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import corsi.architecture.dao.DAOException;
import corsi.architecture.dao.ProfessorDAO;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Professor;

@TestMethodOrder(OrderAnnotation.class)
class ProfessorDAOTest {

	private static ProfessorDAO pDAO;
	private static Connection conn;
	private static Professor professor;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		professor = new Professor();
		professor.setCode(12L);
		professor.setName("Giacomo");
		professor.setSurname("Verdi");
		professor.setCv("curriculum");

	}

	@Test
	@Order(0)
	void testUpdate() {
		try {
			System.out.println("inizio Aggiornamento");
			professor.setName("Jessica");
			professor.setSurname("Rossi");
			professor.setCv("curriculum2");
			professor.setCode(81L);
			ProfessorDAO.getFactory().update(conn, professor);
			System.out.println("fine aggiornamento");
			System.out.println(ProfessorDAO.getFactory().getByCode(conn, 81L));
		} catch (Exception exc) {
			exc.printStackTrace();
			fail("Update fallito: " + exc.getMessage());
		}
	}

	@Test
	@Order(1)
	void testGetByCode() {
		try {
			System.out.println("inizio getByCode");
			ProfessorDAO.getFactory().getByCode(conn, 81L);
			System.out.println(ProfessorDAO.getFactory().getByCode(conn, 81L));
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("getByCode fallito: " + exc.getMessage());
		}

	}

	@Test
	@Order(2)
	void testGetAll() {
		try {
			List<Professor> professors = ProfessorDAO.getFactory().getAll(conn);
			assertNotNull(professors);
			System.out.println("eseguito il getAll");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("getAll fallito: " + exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			ProfessorDAO.getFactory().delete(conn, professor);
			System.out.println("Eliminato articolo");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: " + exc.getMessage());

		}
	}
}