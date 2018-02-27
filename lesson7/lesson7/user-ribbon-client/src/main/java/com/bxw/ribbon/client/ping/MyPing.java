package com.bxw.ribbon.client.ping;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.Server;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * 实现 {@link IPing} 接口：检查对象 /health 是否正常状态码:200
 * Created by wxb on 2018/2/27.
 */
public class MyPing implements IPing{
    @Override
    public boolean isAlive(Server server) {
        String host = server.getHost();
        int port = server.getPort();
        //health endpoint ，通过Spring组件实现URI拼接
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.scheme("http");
        builder.host(host);
        builder.port(port);
        builder.path("/health");
        URI uri = builder.build().toUri();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity responseEntity = restTemplate.getForEntity(uri, String.class);
        //响应状态为200，返回true
        return HttpStatus.OK.equals(responseEntity.getStatusCode());

    }
}
