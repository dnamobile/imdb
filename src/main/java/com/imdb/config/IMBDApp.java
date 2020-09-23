package com.imdb.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.imdb.adapter.controller.TitleController;

@ApplicationPath("imdb")
public class IMBDApp 
	extends Application{
    
	@Override
	public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<>();
        s.add(TitleController.class);
        return s;
    }
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new BasicModule());
	    TitleController controller = injector.getInstance(TitleController.class);
	}
}
