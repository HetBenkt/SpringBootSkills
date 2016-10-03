package nl.bos.services.youtube.api;

public class YouTubeVideo {
	private YouTubeVideoId id;
	private YouTubeVideoSnippet snippet;

	public YouTubeVideoId getId() {
		return id;
	}

	public void setId(YouTubeVideoId id) {
		this.id = id;
	}

	public YouTubeVideoSnippet getSnippet() {
		return snippet;
	}

	public void setSnippet(YouTubeVideoSnippet snippet) {
		this.snippet = snippet;
	}
}
