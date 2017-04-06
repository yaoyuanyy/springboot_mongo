package com.yy.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mapping.context.MappingContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.CustomConversions;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {
	
	@Bean
	public CommandLineRunner commandLineRunner(){
		return  new CommandLineRunner(){

			@Override
			public void run(String... args) throws Exception {
				System.out.println("---welcome to this project---");
				
			}
			
		};
	}

    /**
     * 加入自定义类型转换 String-->LocalDateTime;LocalDateTime-->String
     * @param simpleMongoDbFactory
     * @param mappingContext
     * @return
     */
	@Bean
	public MongoTemplate mongoTemplate(SimpleMongoDbFactory simpleMongoDbFactory,
                                       MappingContext mappingContext){
        //MappingContext mappingContext = new SimpleMongoMappingContext();
        MappingMongoConverter mongoConverter = new MappingMongoConverter(simpleMongoDbFactory,mappingContext);

        List<Converter> converters = new ArrayList<>();
        converters.add(new LocalDateTimeToStringConverter());
        converters.add(new StringToLocalDateTimeConverter());

        mongoConverter.setCustomConversions(new CustomConversions(converters));
        System.out.println("------------MongoTemplate started------------");
        mongoConverter.afterPropertiesSet();//把自定义的convertor注册到conversionService中
		return new MongoTemplate(simpleMongoDbFactory, mongoConverter);
	}

    /*@Bean
    public MongoTemplate mongoTemplate(SimpleMongoDbFactory simpleMongoDbFactory){
        return new MongoTemplate(simpleMongoDbFactory);
    }*/
}

class LocalDateTimeToStringConverter implements Converter<LocalDateTime, String> {
    @Override
    public String convert(LocalDateTime source) {
        System.out.println("------------LocalDateTimeToStringConverter------------");
        return source == null ? null : source.toString();
    }
}

class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {
    @Override
    public LocalDateTime convert(String source) {
        System.out.println("------------StringToLocalDateTimeConverter------------");
        return source == null ? null : LocalDateTime.parse(source);
    }
}
