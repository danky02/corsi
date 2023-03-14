package corsi.businesscomponent;

import java.io.IOException;
import java.sql.Connection;

import corsi.architecture.dao.AdminDAO;
import corsi.architecture.dao.DAOException;
import corsi.architecture.dbaccess.DBAccess;
import corsi.businesscomponent.model.Admin;

public class AdminBC {
	private Connection conn;
	private AdminDAO aDAO;

	public AdminBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
		aDAO = AdminDAO.getFactory();
	}

	public void update(Admin admin) throws DAOException {
		try {
			aDAO.update(conn, admin);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public void deleteByCode(long code) throws DAOException {
		try {
			aDAO.deleteByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
	}

	public Admin getByCode(long code) throws DAOException {
		try {
			return aDAO.getByCode(conn, code);
		} finally {
			DBAccess.closeConnection();
		}
	
	}

}
