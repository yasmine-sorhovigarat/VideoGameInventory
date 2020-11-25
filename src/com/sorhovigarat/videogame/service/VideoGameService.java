package com.sorhovigarat.videogame.service;

import java.util.ArrayList;

import com.sorhovigarat.videogame.dao.DatabaseVideoGameDAO;
import com.sorhovigarat.videogame.model.VideoGame;

public class VideoGameService {
	private DatabaseVideoGameDAO videoGameDAO;
	
	public VideoGameService() {
		this.videoGameDAO = new DatabaseVideoGameDAO();
	}
	
	public VideoGameService(DatabaseVideoGameDAO videoGameDAO) {
		this.videoGameDAO = videoGameDAO;
	}
	
	public ArrayList<VideoGame> getAllVideoGames() {
		return videoGameDAO.getAllVideoGames();
	}
	
	public VideoGame insertVideoGame(VideoGame videoGame){
		
		return videoGameDAO.insertVideoGame(videoGame);
	}

	public boolean updateVideoGame(int id, String title, String platform, boolean isFinished) {
		return videoGameDAO.updateVideoGame(id, title, platform, isFinished);
	}

	public boolean deleteVideoGame(int id) {
		return videoGameDAO.deleteVideoGame(id);
	}

	public ArrayList<VideoGame> getFilteredVideoGamesByIsFinished(String filterValue) {
		return videoGameDAO.getFilteredVideoGamesByIsFinished(filterValue);
	}

	public ArrayList<VideoGame> getFilteredVideoGamesById(String id) {
		return videoGameDAO.getFilteredVideoGamesById(id);
	}	
}
