package com.sorhovigarat.videogame.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sorhovigarat.videogame.model.VideoGame;
import com.sorhovigarat.videogame.service.VideoGameService;
/**
 * Servlet implementation class VideoGameServlet
 */
public class VideoGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private VideoGameService videoGameService = new VideoGameService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoGameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isFinished = request.getParameter("isFinished");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		
		if(isFinished == null && id == null)
		{	
			ArrayList<VideoGame> videoGameList = videoGameService.getAllVideoGames();
			for(int i = 0; i < videoGameList.size(); i++)
			{
				out.println(videoGameList.get(i).toString());
			}	
		}
		else if(isFinished != null) {
			ArrayList<VideoGame> videoGameList = videoGameService.getFilteredVideoGamesByIsFinished(isFinished);
			if(videoGameList.size() > 0)
			{
				for(int i = 0; i < videoGameList.size(); i++)
				{
					out.println(videoGameList.get(i).toString());
				}
			}
			else
			{
				out.println("No video games found with those filters.");
			}
		}
		else if(id != null)
		{
			ArrayList<VideoGame> videoGameList = videoGameService.getFilteredVideoGamesById(id);
			if(videoGameList.size() > 0)
			{
				for(int i = 0; i < videoGameList.size(); i++)
				{
					out.println(videoGameList.get(i).toString());
				}
			}
			else
			{
				out.println("No video games found with those filters.");
			}
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String platform = request.getParameter("platform");
		Boolean isFinished = Boolean.parseBoolean(request.getParameter("isFinished"));
		
		if(videoGameService.insertVideoGame(new VideoGame(title, platform, isFinished)) != null)
				{
			response.getWriter().append("Video game added.");
				}
		else {
			response.getWriter().append("Video game not added.");
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String platform = request.getParameter("platform");
		Boolean isFinished = Boolean.parseBoolean(request.getParameter("isFinished"));
		
		if(videoGameService.updateVideoGame(id, title, platform, isFinished))
		{
			response.getWriter().append("Video game updated");
		}
		else {
			response.getWriter().append("Video game not updated");
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		if(videoGameService.deleteVideoGame(id))
		{
			response.getWriter().append("Video game deleted");
		}
		else {
			response.getWriter().append("Video game not deleted");
		}
	}

}
