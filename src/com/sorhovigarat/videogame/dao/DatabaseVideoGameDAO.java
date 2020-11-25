package com.sorhovigarat.videogame.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sorhovigarat.videogame.model.VideoGame;
import com.sorhovigarat.videogame.util.DBConnection;


public class DatabaseVideoGameDAO {
	public ArrayList<VideoGame> getAllVideoGames() {
		
		String sqlQuery = "SELECT * "
				+ "FROM videogames";
	
		ArrayList<VideoGame> videoGames = new ArrayList<>();
		
		try (Connection connection = DBConnection.getConnection()) {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sqlQuery);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String platform = rs.getString(3);
				boolean isFinished = rs.getBoolean(4);
				
				VideoGame videoGame = new VideoGame(id, title, platform, isFinished);
				
				videoGames.add(videoGame);
			}
			
			return videoGames;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return videoGames;
	}
	
	/**
	 * @return VideoGame or null
	 */
	public VideoGame insertVideoGame(VideoGame videoGame) {
		
		try (Connection connection = DBConnection.getConnection()) {
			String sqlQuery = "INSERT INTO videogames(title, platform, isfinished) "
					+ "VALUES(?, ?, ?)";

			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			String title = videoGame.getTitle();
			String platform = videoGame.getPlatform();
			boolean isFinished = videoGame.isFinished();
			
			
//			pstmt.setString(1, videoGame.getTitle());
//			pstmt.setString(2, videoGame.getPlatform());
//			pstmt.setDouble(3, videoGame.getPrice());
//			pstmt.setBoolean(4, videoGame.isFinished());
			
			pstmt.setString(1, title);
			pstmt.setString(2, platform);
			pstmt.setBoolean(3, isFinished);
			
			pstmt.executeUpdate();
			
			
			//return new VideoGame(pstmt.getGeneratedKeys().getInt(1), videoGame.getTitle(), videoGame.getPlatform(), videoGame.isFinished());
			return new VideoGame(videoGame.getTitle(), videoGame.getPlatform(), videoGame.isFinished());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		//return new VideoGame(videoGame.getTitle(), videoGame.getPlatform(), videoGame.isFinished());
	}

	public boolean updateVideoGame(int id, String title, String platform, boolean isFinished) {
		try (Connection connection = DBConnection.getConnection()) {
			String sqlQuery = "UPDATE videogames "
					+ "SET title = ?, platform = ?, isfinished = ? "
					+ "WHERE videogameid = ?";

			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
		
			pstmt.setString(1, title);
			pstmt.setString(2, platform);
			pstmt.setBoolean(3, isFinished);
			pstmt.setInt(4, id);
			
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteVideoGame(int id) {
		try (Connection connection = DBConnection.getConnection()) {
			String sqlQuery = "Delete from videogames "
					+ "WHERE videogameid = ?";

			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
		
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;
	}

	public ArrayList<VideoGame> getFilteredVideoGamesByIsFinished(String filterValue) {
		
		String sqlQuery = "SELECT * "
				+ "FROM videogames "
				+ "WHERE isFinished = ?";
			
		ArrayList<VideoGame> videoGames = new ArrayList<>();
		
		try (Connection connection = DBConnection.getConnection()) {
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			pstmt.setBoolean(1, Boolean.parseBoolean(filterValue));
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String platform = rs.getString(3);
				boolean isFinished = rs.getBoolean(4);
				
				VideoGame videoGame = new VideoGame(id, title, platform, isFinished);
				
				videoGames.add(videoGame);
			}			
			return videoGames;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}

	public ArrayList<VideoGame> getFilteredVideoGamesById(String filterid) {
		String sqlQuery = "SELECT * "
				+ "FROM videogames "
				+ "WHERE videogameid = ?";
			
		ArrayList<VideoGame> videoGames = new ArrayList<>();
		
		try (Connection connection = DBConnection.getConnection()) {
			PreparedStatement pstmt = connection.prepareStatement(sqlQuery);
			
			pstmt.setInt(1, Integer.parseInt(filterid));
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String title = rs.getString(2);
				String platform = rs.getString(3);
				boolean isFinished = rs.getBoolean(4);
				
				VideoGame videoGame = new VideoGame(id, title, platform, isFinished);
				
				videoGames.add(videoGame);
			}			
			return videoGames;
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return null;
	}
}
