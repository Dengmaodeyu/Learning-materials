package com.xixicc.servicebase.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Configuration
@Slf4j
public class CORSConfig implements WebMvcConfigurer {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").//允许所有的访问请求（访问路径）
                allowedMethods("*").//允许所有的请求方法访问该跨域资源服务器
                allowedOrigins("*").//允许所有的请求域名访问我们的跨域资源
                allowedHeaders("*");//允许所有的请求header访问
    }
    /**
     * @EnableWebMvc 使用该注解后，需要手动配置  addInterceptors() 和 addResourceHandlers()
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
                    @Override
                    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                        log.info("JacksonConfig");
                        return HandlerInterceptor.super.preHandle(request, response, handler);
                    }
                }).addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html")
                .excludePathPatterns("/null/**")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/swagger/**")
                .excludePathPatterns("/webjars/**")
                .excludePathPatterns("/v2/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//        registry.addResourceHandler("/doc.html").addResourceLocations()
        // 配置 knife4j 文档资源的访问路径
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }



    /**
     * 填充全局 objectMapper
     * https://stackoverflow.com/questions/45734108/spring-boot-not-using-configured-jackson-objectmapper-with-enablewebmvc
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.stream().filter(p -> p instanceof MappingJackson2HttpMessageConverter)
                .map(p -> (MappingJackson2HttpMessageConverter)p).forEach(p -> p.setObjectMapper(objectMapper));
        WebMvcConfigurer.super.extendMessageConverters(converters);
    }
}

