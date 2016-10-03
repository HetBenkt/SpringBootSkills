package nl.bos.services.youtube;

import nl.bos.services.youtube.api.SearchListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YouTubeApi {
	public String YOUTUBE_API_URL = "https://www.googleapis.com/youtube/v3/";

	@GET("search?part=snippet&type=video")
	Call<SearchListResponse> searchList(@Query("q") String q);
}
