package corsi.businesscomponent;

import corsi.architetture.dao.DAOException;
import corsi.architetture.dbaccess.DABccess;


public class ProfessorBC {
	
	private Connection conn;
	private ProfessorDAO pDAO;
	
	
	public ProfessorBC() throws DAOException {
		try {
			pDAO.create(conn, ProfessorDAO);
		} finally {
			DABccess.closeConnection();
		}
	}
}
