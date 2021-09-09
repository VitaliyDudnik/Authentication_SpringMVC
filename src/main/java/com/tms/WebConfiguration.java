package com.tms;

import com.tms.interceptor.ControllerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@Import(HibernateConfiguration.class)
@ComponentScan(basePackages = "com.tms")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter {
    private final ControllerInterceptor controllerInterceptor;

    public WebConfiguration(ControllerInterceptor controllerInterceptor) {
        this.controllerInterceptor = controllerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry
                .addInterceptor(controllerInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/users/home", "/users/reg", "/users/authorization", "/users/notRegistered", "/users/regContent");

    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }


}
