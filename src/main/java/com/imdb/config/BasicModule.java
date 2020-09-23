package com.imdb.config;

import com.google.inject.AbstractModule;
import com.imdb.usecase.TitleService;
import com.imdb.usecase.TitleServiceImpl;

public class BasicModule 
	extends AbstractModule{

	@Override
    protected void configure() {
        bind(TitleService.class).to(TitleServiceImpl.class);
    }
}
