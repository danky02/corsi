package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Professor;

public class ProfessorBC {
	private Connection conn;
	private ProfessorDAO pDAO;

	public ProfessorBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
		pDAO = ProfessorDAO.getFactory();
	}

	public void create(Professor professor) throws DAOException {
		try {
			pDAO.create(conn, professor);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void update(Professor professor) throws DAOException {
		try {
			pDAO.update(conn, professor);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteByCode(long code) throws DAOException {
		try {
			pDAO.deleteByCode(conn, code);
		} finally {
			DBAccess.closeConnection();

		}
	}

	public Professor getByCode(long code) throws DAOException {
		try {
			return pDAO.getByCode(conn, code);
		} finally {
			DBAccess.closeConnection();

		}
	}

	public List<Professor> getAll() {
		List<Professor> professorList = new ArrayList<>();
		professorList = pDAO.getAll();
		return professorList;
	}

}
