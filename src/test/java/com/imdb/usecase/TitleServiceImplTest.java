package com.imdb.usecase;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.imdb.adapter.api.TitleResponse;
import com.imdb.adapter.api.TitleWrapper;

public class TitleServiceImplTest {

	@Inject
	private TitleServiceImpl service = new TitleServiceImpl();
	
	private String title, titleId;
	private TitleWrapper response;
	
	
	@Before
	public void prepare() {
		title = "Tropa de Elite";
		titleId = "tt0944947";
	}
	
	@Test
	public void canFindTitles() throws IOException {
		response = service.find(title);
		
		List<TitleResponse> results = response.getResults();
		assertNotNull("A resposta da busca não pode ser nula", results);
		assertSame("A resposta deve conter 4 títulos", 4, results.size());
	}
	
	@Test
	public void canDetailTitles() throws IOException {
		response = service.getDetails(titleId);
		
		List<TitleResponse> results = response.getResults();
		assertNotNull("A resposta da busca não pode ser nula", results);
		assertSame("A resposta deve conter 4 títulos", 4, results.size());
	}
}
