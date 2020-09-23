package com.imdb.usecase;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.imdb.adapter.mapper.TitleMapper;
import com.imdb.adapter.mapper.TitleResponse;
import com.imdb.adapter.mapper.TitleWrapper;

public class TitleServiceImplTest {

	@Inject
	private TitleServiceImpl service = new TitleServiceImpl();
	
	@Inject
	private TitleWrapper wrapper;
	
	private TitleResponse response;

	private String title, titleId;
	
	
	@Before
	public void prepare() {
		title = "Tropa de Elite";
		titleId = "tt0944947";
	}
	
	@Test
	public void canFindTitles() throws IOException {
		response = service.find(title);
		
//		List<TitleMapper> results = wrapper.getResults();
//		assertNotNull("A resposta da busca não pode ser nula", results);
//		assertSame("A resposta deve conter 4 títulos", 4, results.size());
	}
	
	@Test
	public void canDetailTitles() throws IOException {
		response =  service.getDetails(titleId);
		
//		List<TitleMapper> results = wrapper.getResults();
//		assertNotNull("A resposta da busca não pode ser nula", results);
//		assertSame("A resposta deve conter 4 títulos", 4, results.size());
	}
}
