package com.imdb.adapter.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe for data response for API
 * @author Danilo Portela
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TitleResponse {

	private String titleList;
}
