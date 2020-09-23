package com.imdb.adapter.controller;

import static java.util.Optional.ofNullable;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.imdb.adapter.mapper.TitleRequest;
import com.imdb.adapter.mapper.TitleResponse;
import com.imdb.usecase.TitleService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Controller with available endpoints in Title API.
 * @author Danilo Portela
 */
@Data
@Path("/title")
@NoArgsConstructor
@AllArgsConstructor
public class TitleController {

	@Inject
	private TitleService service;
	
//	@Inject
//	private Logger logger;
		
	/**
	 * Endpoint with ID searchs for titles.
	 * @param request with a title ID
	 * @return A TitleResponse, with a list of Titles
	 * @throws IOException
	 */
	@GET
	@Path("/get-details")
	@Produces("text/xml")
	public TitleResponse getDetails(@FormParam("request") TitleRequest request) throws IOException {
		return service.getDetails(
						ofNullable(request.getTitleId())
						.orElseThrow(() -> new IOException("O ID do título deve ser informado.")));
	}
	
	/**
	 * Endpoint with query searchs for titles.
	 * @param request with a query setence
	 * @return A TitleResponse, with a list of Titles
	 * @throws IOException
	 */
	@GET
	@Path("/find")
	@Produces("text/xml")
	public TitleResponse find(@FormParam("request") TitleRequest request) throws IOException {
		return service.find(
						ofNullable(request.getQuery())
						.orElseThrow(() -> new IOException("O termo de busca deve ser informado.")));
	}
	
}
