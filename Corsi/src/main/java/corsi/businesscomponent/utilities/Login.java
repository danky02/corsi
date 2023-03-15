package corsi.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import corsi.architecture.dao.DAOConstants;
import corsi.architecture.dbaccess.DBAccess;

public class Login implements DAOConstants {
	private Connection conn;
	
	public Login() throws ClassNotFoundException, SQLException,IOException {
		conn = DBAccess.getConnection();
	}

	public String getAdminPass(String username) throws SQLException{
		String pass = null;
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINCODE_BY_USERNAME);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				pass = rs.getString(1);
		} catch(SQLException sql) {
			sql.printStackTrace();
			System.out.println(sql.getMessage());
		}
		return pass;
	}
}