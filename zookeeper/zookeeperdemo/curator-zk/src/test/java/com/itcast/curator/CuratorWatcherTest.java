package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @ClassName CuratorTest
 * @description:
 * @author: isquz
 * @time: 2022/5/15
 */
public class CuratorWatcherTest {

    private CuratorFramework client;

//    @Test
    @Before
    public void testConnect(){
        /*
         * @param connectString       list of servers to connect to
         * @param sessionTimeoutMs    session timeout
         * @param connectionTimeoutMs connection timeout
         * @param retryPolicy         retry policy to use
         */
        String url = "127.0.0.1:2181";
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        // 第一种方式
//        CuratorFramework client = CuratorFrameworkFactory.newClient(url, 60 * 1000,
//                15 * 1000, retryPolicy);
//        client.start();
        // 第二种方式：
        client = CuratorFrameworkFactory.builder().connectString(url)
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy).namespace("itcast").build();
        client.start();
        System.out.println(client.getState());
    }

    @After
    public void releaseConnextion(){
        if (client != null){
            client.close();
        }
    }

    /**
     * @description:
     *
     * NodeCache:
     * 给指定单一节点注册监听器
     *
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2022/5/21 23:23
     */  
    @Test
    public void testNodeCache() throws Exception {
        // 创建NodeCache对象
        NodeCache nodeCache = new NodeCache(client, "/app1");
        // 注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了...");
                // 获取修改后的节点数据
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println("new data: " + new String(data) );
            }
        });

        // 开启监听 如果设置为true 则开启监听时会加载缓存数据
        nodeCache.start(true);

        while (true){
            
        }

    }

    // 监听子节点
    @Test
    public void testChildrenCache() throws Exception {
        // 创建NodeCache对象
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app2", true);
        // 绑定监听器：
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
//                System.out.println("child node update...");
                System.out.println(pathChildrenCacheEvent);

                // 监听子节点数据变更 并获取变更后的数据
                PathChildrenCacheEvent.Type type = pathChildrenCacheEvent.getType();
                if (type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
                    byte[] data = pathChildrenCacheEvent.getData().getData();
                    System.out.println("child node update...");
                    System.out.println(new String(data));
                }
            }
        });
        // 开启
        pathChildrenCache.start();
        while (true){
        }
    }


    // 监听某个节点本身 及其子节点
    @Test
    public void testTreeCache() throws Exception {
        TreeCache treeCache = new TreeCache(client, "/app2");
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {
                System.out.println("child node update");
                System.out.println(treeCacheEvent);
            }
        });

        treeCache.start();
        while (true){

        }
    }

}
