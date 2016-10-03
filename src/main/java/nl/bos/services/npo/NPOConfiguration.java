package nl.bos.services.npo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import nl.bos.ApplicationConfiguration;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class NPOConfiguration implements Interceptor {
	@Autowired
	ApplicationConfiguration applicationConfiguration;

	@Bean
	public NPOService npoService() {
		OkHttpClient client = new OkHttpClient.Builder().addInterceptor(this).build();

		Retrofit retrofit = new Retrofit.Builder().baseUrl(NPOApi.NPO_API_URL)
				.addConverterFactory(GsonConverterFactory.create()).client(client).build();
		NPOApi npoApi = retrofit.create(NPOApi.class);

		return new NPOService(npoApi);
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request request = chain.request();
		request = request.newBuilder().build();
		return chain.proceed(request);
	}
}
