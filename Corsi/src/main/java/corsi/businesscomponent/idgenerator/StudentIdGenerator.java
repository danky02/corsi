package corsi.businesscomponent.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import corsi.architetture.dao.DAOConstants;
import corsi.architetture.dao.DAOException;
import corsi.architetture.dbaccess.DABccess;

public class StudentIdGenerator implements DAOConstants {
	private static Connection conn;
	private static StudentIdGenerator idGen;
	private Statement stmt;
	private ResultSet rs;
	
	private StudentIdGenerator() {
		
	}
	
	public static StudentIdGenerator getInstance() {
		if(idGen == null)
			idGen = new StudentIdGenerator();
		return idGen;
	}
	
	public long getNextId() throws DAOException, ClassNotFoundException, IOException {
		long id = 0;
		try {
		 	conn = DABccess.getConnection();
		 	stmt = conn.createStatement();
		 	rs = stmt.executeQuery(SELECT_STUDENT_SEQ);
		 	rs.next();
		 	id = rs.getLong(1);
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
}
