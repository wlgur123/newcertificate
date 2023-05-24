package com.nhnacademy.newcertificate.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses(){
        return new Class[] {RootConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses(){
        return new Class[] {WebConfig.class};
    }
    @Override
    protected String[] getServletMappings(){
        return new String[] {"/"};
    }
    @Override
    protected Filter[] getServletFilters(){
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        return new Filter[]{encodingFilter,hiddenHttpMethodFilter};
    }
}