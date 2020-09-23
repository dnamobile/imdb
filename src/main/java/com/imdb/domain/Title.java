package com.imdb.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representation of Movie, Serie and TV Programs in IMDB
 * @author Danilo Portela
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Title {

	private String id;
	private int year;
	private String title; 
	private String titleType;
	private int runningTimeInMinutes;
}
