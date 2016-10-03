package nl.bos.services.youtube;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import nl.bos.services.youtube.api.SearchListResponse;
import nl.bos.services.youtube.api.YouTubeVideo;
import retrofit2.Response;

public class YouTubeService {
	YouTubeApi youTubeApi;

	public YouTubeService(YouTubeApi youTubeApi) {
		this.youTubeApi = youTubeApi;
	}

	public List<YouTubeVideo> searchVideos(String query) {
		List<YouTubeVideo> result = Collections.emptyList();

		try {
			Response<SearchListResponse> response = youTubeApi.searchList(query).execute();
			result = response.body().getItems();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		return result;
	}
}
