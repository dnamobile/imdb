package com.imdb.usecase;

import static com.imdb.adapter.api.TitleEndpoint.FIND;
import static com.imdb.adapter.api.TitleEndpoint.GET_DETAILS;
import static com.imdb.adapter.api.TitleProperties.q;

import java.io.IOException;

import com.google.gson.Gson;
import com.imdb.adapter.api.TitleEndpoint;
import com.imdb.adapter.api.TitleProperties;
import com.imdb.adapter.api.TitleWrapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TitleServiceImpl 
	implements TitleService{

	
	private String getUrl(TitleEndpoint endpoint, TitleProperties property, String value) {
		StringBuilder url = new StringBuilder(PROTOCOL);
		url.append(HOST).append("/")
		.append(endpoint.getRoute()).append("?")
		.append(property).append("=")
		.append(value);
		return url.toString();
	}
	
	private TitleWrapper getResponse(TitleEndpoint endpoint, String value) throws IOException {
		return getResponse(endpoint, q, value);
	}
	
	private TitleWrapper getResponse(TitleEndpoint endpoint, TitleProperties property, String value) 
			throws IOException{
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			.url(getUrl(endpoint, property, value))
			.get()
			.addHeader(HOST_HEADER, HOST)
			.addHeader(API_KEY_HEADER, API_KEY)
			.build();
		
		Response response = client.newCall(request).execute();
		return fromJson(response.body().string());
	}
	
	private TitleWrapper fromJson(String data) {
		return new Gson().fromJson(data, TitleWrapper.class);
	}
	
	public TitleWrapper getDetails(String titleId) throws IOException {
		return getResponse(GET_DETAILS, TitleProperties.tconst, titleId);
	}
	
	public TitleWrapper find(String title) throws IOException {
		return getResponse(FIND, title);
	}
}
