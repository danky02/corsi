package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import corsi.architecture.dao.DAOException;
import corsi.architecture.dao.ProfessorDAO;
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
			Professor professor = pDAO.getByCode(conn, code);
			pDAO.delete(conn, professor);
		} finally {
			DBAccess.closeConnection();

		}
	}

	public Professor getByCode(long code) throws DAOException {
		Professor result = null;
		try {
			result =  pDAO.getByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
		
		return result;
	}

	public List<Professor> getAll() throws DAOException {
		List<Professor> professorList = null;
		try {
			professorList = pDAO.getAll(conn);			
		} finally {
			DBAccess.closeConnection();			
		}
		
		return professorList;
	}

}
