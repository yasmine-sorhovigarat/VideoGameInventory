package com.sorhovigarat.videogame.model;

public class VideoGame {

		private int id;
		private String title;
		private String platform;
		private boolean isFinished;
		
		public VideoGame() {
			super();
		}
		
		public VideoGame(String title, String platform, boolean isFinished)
		{
			this.title = title;
			this.platform = platform;
			this.isFinished = isFinished;
		}
		
		public VideoGame(int id, String title, String platform, boolean isFinished)
		{
			this.id = id;
			this.title = title;
			this.platform = platform;
			this.isFinished = isFinished;
		}
				
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getPlatform() {
			return platform;
		}
		public void setPlatform(String platform) {
			this.platform = platform;
		}
		public boolean isFinished() {
			return isFinished;
		}
		public void setFinished(boolean isFinished) {
			this.isFinished = isFinished;
		}
		@Override
		public String toString(){
			return "Id: " + this.id + ". Title: " + this.title + ". Platform: " + this.platform + ". Is finished: " + this.isFinished;
		}
}
