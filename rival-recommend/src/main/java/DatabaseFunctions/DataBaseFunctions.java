package DatabaseFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import Model.Movie;

public class DataBaseFunctions {
	
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/movies_movielens?useTimezone=true&serverTimezone=UTC&useSSL=false", "root", "kyugin");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Movie getMovie(Long movieId) {
		
		Movie movie = null;

		try {
			Connection conn = getConnection();
			String query = "select * from `movies_movielens`.`movie` as m where m.idMovieLens = ?";
			// NodeUtil.print(query);
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setLong(1, movieId);
			ResultSet rs = ps.executeQuery();
			while (rs != null && rs.next()) {
				movie = new Movie (rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getInt(5), rs.getInt(6));
			}
			closeQuery(conn, ps);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return movie;

	}
	
	public void insertRecommendation(Long userId, Long moveId, double score) {
		Connection conn = getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO `movies_movielens`.`recommendation` (`userId`, `movieId`, `score`) VALUES (?,?,?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setLong(1,userId);
			ps.setLong(2, moveId);
			ps.setDouble(3, score);
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void closeQuery(Connection conn, PreparedStatement ps) {
		try {
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
/*
	public void insereFilme(String name, String country, String varAbstract, String budget, String  releaseDate, String runtime, String alternateTitle, String starring , String director , String producer) {
		Connection conn = getConnection();
		PreparedStatement ps = null;

		String query = "INSERT INTO `movie` (`name`, `country`, `abstract`, `budget`, `releaseDate`, `runtime`, `alternateTitle`, `starring`, `director`, `producer`) VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, country);
			ps.setString(3, varAbstract);
			ps.setString(4, budget);
			ps.setString(5, releaseDate);
			ps.setString(6, runtime);
			ps.setString(7, alternateTitle);
			ps.setString(8, starring);
			ps.setString(9, director);
			ps.setString(10, producer);
			ps.execute();
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
*/
}
