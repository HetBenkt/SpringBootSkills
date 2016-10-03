package nl.bos.services.npo;

import java.io.IOException;

import nl.bos.services.npo.api.NPOHits;
import nl.bos.services.npo.api.NPOSearchListResponse;
import retrofit2.Response;

public class NPOService {
	NPOApi npoApi;

	public NPOService(NPOApi npoApi) {
		this.npoApi = npoApi;
	}

	public NPOHits searchItems(String query) {
		NPOHits result = null;

		try {
			Response<NPOSearchListResponse> response = npoApi.searchList(query).execute();
			result = response.body().getHits();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		return result;
	}
}
