package nl.bos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationConfiguration {
	@Value("${application.youtube.api_key}")
	private String youTubeApiKey;

	public String getYouTubeApiKey() {
		return youTubeApiKey;
	}
}
