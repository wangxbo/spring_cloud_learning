package com.bxw.ribbon.client.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;

/**
 * User Ribbon Client HystrixCommand
 * Created by wxb on 2018/3/3.
 */
public class UserRibbonClientHystrixCommand extends HystrixCommand<Collection> {

    private final String providerServiceName;

    private final RestTemplate restTemplate;

    public UserRibbonClientHystrixCommand(String providerServiceName, RestTemplate restTemplate) {
        super(HystrixCommandGroupKey.Factory.asKey(
                "User-Ribbon-Client"),
                100);
        this.providerServiceName = providerServiceName;
        this.restTemplate = restTemplate;
    }


    /**
     * 主逻辑
     * @return
     * @throws Exception
     */
    @Override
    protected Collection run() throws Exception {
        //这个前面的"http://"必须加上，不然地址不完整
        return restTemplate.getForObject("http://" + providerServiceName + "/user/list", Collection.class);
    }

    /**
     * 重写 Fallback 实现
     * @return
     */
    protected Collection getFallback(){
        return Collections.emptyList();
    }


}
