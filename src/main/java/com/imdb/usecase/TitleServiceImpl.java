package com.imdb.usecase;

import static com.imdb.adapter.api.TitleEndpoint.FIND;
import static com.imdb.adapter.api.TitleEndpoint.GET_DETAILS;
import static com.imdb.adapter.api.TitleProperties.q;
import static com.imdb.adapter.mapper.TitleMapper.map;

import java.io.IOException;

import com.google.gson.Gson;
import com.imdb.adapter.api.TitleEndpoint;
import com.imdb.adapter.api.TitleProperties;
import com.imdb.adapter.mapper.TitleResponse;
import com.imdb.adapter.mapper.TitleWrapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Service implementation for Title API Operations
 * @author Danilo Portela
 */
@Data
@NoArgsConstructor
public class TitleServiceImpl 
	implements TitleService{

	/**
	 * Builds a URL for connect in Rapid API
	 * @param endpoint in Rapid API
	 * @param property for search
	 * @param value param for search
	 * @return a string of API url
	 */
	private String getUrl(TitleEndpoint endpoint, TitleProperties property, String value) {
		StringBuilder url = new StringBuilder(PROTOCOL);
		url.append(HOST).append("/")
		.append(endpoint.getRoute()).append("?")
		.append(property).append("=")
		.append(value);
		return url.toString();
	}
	
	/**
	 * Converts Json data in a TitleWrapper 
	 * @param data json string for parse
	 * @return a wrapper of titles
	 */
	private TitleWrapper fromJson(String data) {
		return new Gson().fromJson(data, TitleWrapper.class);
	}
	
	/**
	 * Proxy to getResponse method
	 */
	private TitleResponse getResponse(TitleEndpoint endpoint, String value) throws IOException {
		return getResponse(endpoint, q, value);
	}
	
	/**
	 * Call Rapid API endpoints with parameters and returns a response with a list os titles
	 * @param endpoint in Rapid API
	 * @param property for search
	 * @param value param for search
	 * @return a response with a list of titles searched
	 * @throws IOException
	 */
	private TitleResponse getResponse(TitleEndpoint endpoint, TitleProperties property, String value) 
			throws IOException{
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
			.url(getUrl(endpoint, property, value))
			.get()
			.addHeader(HOST_HEADER, HOST)
			.addHeader(API_KEY_HEADER, API_KEY)
			.build();
		
		Response response = client.newCall(request).execute();
		TitleWrapper wrapper = fromJson(response.body().string());
		return map(wrapper);
	}
	
	
	/** Operation for getDetails endpoint */
	public TitleResponse getDetails(String titleId) throws IOException {
		return getResponse(GET_DETAILS, TitleProperties.tconst, titleId);
	}
	
	/** Operation for find endpoint */
	public TitleResponse find(String title) throws IOException {
		return getResponse(FIND, title);
	}
}
