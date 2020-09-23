package com.imdb.adapter.mapper;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Mapper that transforms input data of Rapid API   
 * @author Danilo Portela
 */
@Data
@Builder
@ToString
public final class TitleMapper {

	private static final String separator = "\n";
	
	
	/**
	 * Mapper that transforms a TitleWrapper to TitleResponse 
	 * @param wrapper input with data of Rapid API
	 * @return response with list of titles
	 */
	public static TitleResponse map(TitleWrapper wrapper) {
		StringBuilder titleList = new StringBuilder();
		wrapper.getResults()
					.forEach(t -> 
						titleList.append(t.getTitle())
								.append(separator));
		
		return TitleResponse.builder()
							.titleList(titleList.toString())
							.build();
	}
}
