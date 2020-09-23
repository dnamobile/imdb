package com.imdb.adapter.mapper;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Class for request data searchs in Rapid API
 * @author Danilo Portela
 */
@Data
@NoArgsConstructor
public class TitleRequest 
	implements Serializable{

	private static final long serialVersionUID = 1L;

	private String titleId;
	private String query;
}
