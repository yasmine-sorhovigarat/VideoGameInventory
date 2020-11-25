package com.sorhovigarat.videogame.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.sorhovigarat.videogame.model.VideoGame;
import com.sorhovigarat.videogame.service.VideoGameService;

public class VideoGameServletTest {

	@Test
	public void filterByIdTest() {
		VideoGameService videoGameService = new VideoGameService();
		ArrayList<VideoGame> videoGameList = videoGameService.getFilteredVideoGamesById("9999");
		assertTrue(videoGameList.size() == 0);
	}

}
