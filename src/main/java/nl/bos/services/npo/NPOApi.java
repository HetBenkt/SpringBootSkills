package nl.bos.services.npo;

import nl.bos.services.npo.api.NPOSearchListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NPOApi {
	public String NPO_API_URL = "http://backstage-api.npo.nl/v0/journalistiek/";

	@GET("search")
	Call<NPOSearchListResponse> searchList(@Query("query") String query);
}
