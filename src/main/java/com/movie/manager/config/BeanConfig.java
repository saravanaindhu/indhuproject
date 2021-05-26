package com.movie.manager.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.dozer.DozerBeanMapper;
import org.dozer.DozerBeanMapperSingletonWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.TimeZone;

@Configuration
public class BeanConfig {

    @Bean
    public ObjectMapper mapper() {
        final ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, true);
        mapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.setTimeZone(TimeZone.getDefault());
        return mapper;
    }

    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        return (DozerBeanMapper) DozerBeanMapperSingletonWrapper.getInstance();
    }




}
