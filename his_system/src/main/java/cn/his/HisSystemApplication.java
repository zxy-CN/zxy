package cn.his;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.MediaType;
import javax.annotation.PostConstruct;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
@MapperScan("cn.his.mapper")
public class HisSystemApplication {
    //解决时间传递时少八个小时的问题
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Bean
    public HttpMessageConverters fastJsonConfigure(){
        FastJsonHttpMessageConverter fastJsonConverter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        // 日期
        fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        fastJsonConverter.setFastJsonConfig(fastJsonConfig);
        //中文乱码
        List<MediaType> fastMediaTypes = new ArrayList<>();
        MediaType application_json = new MediaType(MediaType.APPLICATION_JSON, Charset.forName("UTF-8"));
        fastMediaTypes.add(application_json);
        fastJsonConverter .setSupportedMediaTypes(fastMediaTypes);
        HttpMessageConverter<?> converter = fastJsonConverter;
        return new HttpMessageConverters(converter);
    }

    public static void main(String[] args) {
        SpringApplication.run(HisSystemApplication.class, args);
    }

}
