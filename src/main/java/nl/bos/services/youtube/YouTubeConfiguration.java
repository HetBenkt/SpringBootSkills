package nl.bos.services.youtube;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nl.bos.ApplicationConfiguration;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class YouTubeConfiguration implements Interceptor {
	@Autowired
	ApplicationConfiguration applicationConfiguration;

	@Bean
	public YouTubeService youTubeService() {
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(this).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(YouTubeApi.YOUTUBE_API_URL)
				.addConverterFactory(GsonConverterFactory.create()).client(client).build();
		YouTubeApi youTubeApi = retrofit.create(YouTubeApi.class);

		return new YouTubeService(youTubeApi);
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();

		HttpUrl url = request.url().newBuilder().addQueryParameter("key", applicationConfiguration.getYouTubeApiKey())
				.build();
		request = request.newBuilder().url(url).build();

		return chain.proceed(request);
	}
}
