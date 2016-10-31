package nl.bos.services.sw.api;

import java.util.List;

public class SWSearchListResponse {
	private List<SWResult> results;

	public List<SWResult> getResults() {
		return results;
	}

	public void setResults(List<SWResult> results) {
		this.results = results;
	}
}
