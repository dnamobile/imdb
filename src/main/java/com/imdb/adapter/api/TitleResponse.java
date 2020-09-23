package com.imdb.adapter.api;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class TitleResponse {

	private String id;
	private int year;
	private String tconst; 
	private String titleType;
	private String title; 
	private int runningTimeInMinutes;
	
	
	
	public static TitleResponse build(String tConst, String titleType, String title, int year, int runningTimeInMinutes) {
		return builder()
				.tconst(tConst)
				.titleType(titleType)
				.title(title)
				.year(year)
				.runningTimeInMinutes(runningTimeInMinutes)
				.build();
	}
	
}
