package corsi.architecture.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import corsi.businesscomponent.model.Professor;

public class ProfessorDAO implements DAOConstants {

	private CachedRowSet rowSet;

	private ProfessorDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public static ProfessorDAO getFactory() throws DAOException {
		return new ProfessorDAO();

	}

	public void create(Connection conn, Professor entity) throws DAOException {
		try {
			rowSet.setCommand(SELECT_PROFESSOR);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateString(1, entity.getName());
			rowSet.updateString(2, entity.getSurname());
			rowSet.updateString(3, entity.getCv());
			rowSet.updateLong(4, entity.getCode());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	public void delete(Connection conn, Professor entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_PROFESSOR);
			ps.setLong(1, entity.getCode());
			ps.execute();
			conn.commit();

		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void update(Connection conn, Professor entity) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_PROFESSOR);
			ps.setString(1, entity.getName());
			ps.setString(2, entity.getSurname());
			ps.setString(3, entity.getCv());
			ps.setLong(4, entity.getCode());
			ps.execute();
			conn.commit();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Professor getByCode(Connection conn, Long id) throws DAOException {
		Professor professor = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_PROFESSOR_BY_CODE);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				professor = new Professor();
				professor.setName(rs.getString(1));
				professor.setSurname(rs.getString(2));
				professor.setCv(rs.getString(4));
				professor.setCode(rs.getLong(5));
			}
			rs.close();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		
		return professor;

	}

	public List<Professor> getAll(Connection conn) throws DAOException {
		List<Professor> professorList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rs = stmt.executeQuery(SELECT_PROFESSOR);
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setName(rs.getString(1));
				professor.setSurname(rs.getString(2));
				professor.setCv(rs.getString(3));
				professor.setCode(rs.getLong(4));
				professorList.add(professor);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return professorList;
	}

}