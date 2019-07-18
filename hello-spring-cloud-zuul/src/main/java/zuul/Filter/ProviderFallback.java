package zuul.Filter;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class ProviderFallback implements FallbackProvider{
    @Override
    //返回值指定微服务的serviceId,也可以是*代表所有微服务。
    public String getRoute() {
        return "*";
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                System.out.println("111");
                //fallback时的状态码
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException{
                System.out.println("222");
                //数字类型的状态码
                return 200;
            }

            @Override
            public String getStatusText() throws IOException{
                System.out.println("333");
                //状态文本
                return this.getStatusCode().getReasonPhrase();
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException{
                System.out.println("444");
                //响应体
                return new ByteArrayInputStream("此微服务不可用，请稍后重试！".getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                System.out.println("555");
                //响应头部
                HttpHeaders httpHeaders = new HttpHeaders();
                MediaType mediaType = new MediaType("application", "json", Charset.forName("UTF-8"));
                httpHeaders.setContentType(mediaType);
                return httpHeaders;
            }
        };
    }
}
