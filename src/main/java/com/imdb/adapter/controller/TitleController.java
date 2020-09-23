package com.imdb.adapter.controller;

import static java.util.Optional.ofNullable;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.imdb.adapter.api.TitleWrapper;
import com.imdb.usecase.TitleService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Path("/title")
@NoArgsConstructor
@AllArgsConstructor
public class TitleController {

	@Inject
	private TitleService service;
	
//	@Inject
//	private Logger logger;
		
	@GET
	@Path("/details/{titleId}")
	@Produces("text/xml")
	public TitleWrapper getDetails(@PathParam("titleId") String titleId) throws IOException {
		return service.getDetails(
						ofNullable(titleId)
						.orElseThrow(() -> new IOException("O ID do título deve ser informado.")));
	}
	
	@GET
	@Path("/find/{title}")
	@Produces("text/xml")
	public TitleWrapper find(@PathParam("title") String title) throws IOException {
		return service.find(
						ofNullable(title)
						.orElseThrow(() -> new IOException("O título deve ser informado.")));
	}
	
}
