package com.springmvc.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc
@ComponentScan("com.springmvc")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	/*
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
		return resolver;
	}
	*/
	
	@Bean
	public ViewResolver cnviewResolver(ContentNegotiationManager cnm){
		 ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		 cnvr.setContentNegotiationManager(cnm);
		 return cnvr;
	}
	
	/*
	 // Solo se coloca si deseas un formato predeterminado para la respuesta del servicio
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_XML);
	}*/
	
	@Bean
	public ViewResolver beanNameViewResolver(){
		return new BeanNameViewResolver();
	}
	
	@Bean
	public View personas(){
		return new MappingJackson2JsonView();
	}
	
	

}