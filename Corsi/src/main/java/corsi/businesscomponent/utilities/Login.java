package corsi.businesscomponent.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login implements DAOConstants {
	private Connection conn;
	
	public Login() throws ClassNotFoundException, SQLException,IOException {
		conn = DBAccess.getConnection();
	}

	public String getAdminPass(String username) throws SQLException{
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString(1);
			return null;
		} catch(SQLException sql) {
			sql.printStackTrace();
			System.out.println(sql.getMessage());
		}
	}
}