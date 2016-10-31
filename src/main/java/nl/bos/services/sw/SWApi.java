package nl.bos.services.sw;

import nl.bos.services.sw.api.SWSearchListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SWApi {
	public String SW_API_URL = "http://swapi.co/api/";

	@GET("planets")
	Call<SWSearchListResponse> searchList(@Query("page") long page);
}
