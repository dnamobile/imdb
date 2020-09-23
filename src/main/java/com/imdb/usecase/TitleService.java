package com.imdb.usecase;

import java.io.IOException;

import com.imdb.adapter.api.TitleWrapper;

public interface TitleService {

	final static String HOST_HEADER = "x-rapidapi-host";
	final static String API_KEY_HEADER = "x-rapidapi-key";
	final static String PROTOCOL = "https://";
	final static String HOST = "imdb8.p.rapidapi.com";
	final static String API_KEY = "08c754d6c5msh23451a491421fd1p1a1baejsnb03f64a5168d";
	
	public TitleWrapper getDetails(String titleId) throws IOException;
	
	public TitleWrapper find(String title) throws IOException;
}
