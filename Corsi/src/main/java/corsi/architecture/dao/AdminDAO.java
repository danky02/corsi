package corsi.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import corsi.businesscomponent.model.Admin;

public class AdminDAO implements DAOConstants {

	public static AdminDAO getFactory() throws DAOException {
		return new AdminDAO();
	}

	public void deleteByCode(Connection conn, long code) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_ADMIN);
			ps.setLong(1, code);
			ps.execute();
			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void update(Connection conn, Admin entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_ADMIN);
			ps.setString(1, entity.getAdminName());
			ps.setString(2, entity.getAdminSurname());
			ps.setString(3, entity.getAdminUsername());
			ps.setLong(4, entity.getAdminCode());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Admin getByCode(Connection conn, long code) throws DAOException {
		Admin admin = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_ADMIN_BY_CODE);
			ps.setLong(1, code);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setAdminName(rs.getString(1));
				admin.setAdminSurname(rs.getString(2));
				admin.setAdminUsername(rs.getString(3));
				admin.setAdminCode(rs.getLong(4));

			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

		return admin;
	}

}
