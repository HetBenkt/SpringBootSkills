package nl.bos.services.youtube.api;

import java.util.List;

public class SearchListResponse {
	private List<YouTubeVideo> items;

	public List<YouTubeVideo> getItems() {
		return items;
	}

	public void setItems(List<YouTubeVideo> items) {
		this.items = items;
	}
}
