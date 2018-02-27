package com.bxw.ribbon.client.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.*;

import java.util.List;


/**
 * 自定义{@link IRule} 实现，永远选择最后一台可达服务器
 * Created by wxb on 2018/2/27.
 */
public class MyRule extends AbstractLoadBalancerRule{

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object o) {
        ILoadBalancer loadBalancer = getLoadBalancer();
        //获取所有可达服务器列表
        List<Server> servers = loadBalancer.getReachableServers();
        if(servers.isEmpty()){
            return null;
        }
        //选最后一台
        Server server = servers.get(servers.size() - 1);
        return server;
    }
}
