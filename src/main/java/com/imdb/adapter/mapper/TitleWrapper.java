package com.imdb.adapter.mapper;

import java.util.List;

import com.imdb.domain.Title;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Wrapper for title data list of Rapid API
 * @author Danilo Portela
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TitleWrapper {

	private List<Title> results;
}
