package nl.bos.services.sw;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import nl.bos.services.sw.api.SWResult;
import nl.bos.services.sw.api.SWSearchListResponse;
import retrofit2.Response;

public class SWService {
	SWApi swApi;

	public SWService(SWApi swApi) {
		this.swApi = swApi;
	}

	public List<SWResult> searchItems(long page) {
		List<SWResult> result = Collections.emptyList();

		try {
			Response<SWSearchListResponse> response = swApi.searchList(page).execute();
			result = response.body().getResults();
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

		return result;
	}
}
