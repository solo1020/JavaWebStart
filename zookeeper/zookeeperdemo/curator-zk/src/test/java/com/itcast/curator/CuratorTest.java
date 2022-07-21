package com.itcast.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
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
public class CuratorTest {

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
//
//        client.start();

        // 第二种方式：
        client = CuratorFrameworkFactory.builder().connectString(url)
                .sessionTimeoutMs(60 * 1000)
                .connectionTimeoutMs(15 * 1000)
                .retryPolicy(retryPolicy).namespace("itcast").build();

        client.start();

        System.out.println(client.getState());

    }

    /**
     * @description:创建节点 持久 临时 顺序
     *
     * 基本创建
     * 创建节点 带数据
     * 设置节点类型
     * 创建多级节点
     * @param:
     * @return: void
     * @author: isquz
     * @date: 2022/5/18 1:46
     */
    @Test
    public void testCreateZookeeperNode() throws Exception {
        // 如果创建节点没有指定数据 则默认将当前客户端的ip作为数据存储
        String path = client.create().forPath("/app1");
        System.out.println(path);
    }

    @Test
    public void testCreateZookeeperNodeWIthData() throws Exception {
        // 创建节点 指定数据
        String path = client.create().forPath("/app2", "hehe".getBytes());
        System.out.println(path);
    }

    // 设置节点类型
    @Test
    public void setNodeType() throws Exception {
        String path = client.create().withMode(CreateMode.EPHEMERAL).forPath("/app3");
        System.out.println(path);
    }

    // 创建多个节点 默认不允许一次性创建多级节点 所以需要调用自动创建不存在的父节点的方法
    @Test
    public void createMultiNodes() throws Exception {
        String path = client.create().creatingParentsIfNeeded().forPath("/app4/p1");
        System.out.println(path);
    }

    // =================================================================================//

    /**
     * @description:
     * 查询数据：get
     * 查询子节点： ls
     * 查询节点状态信息 ls -s
     *
     *
     */
    @Test
    public void getNode() throws Exception {
        byte[] data = client.getData().forPath("/app1");
        System.out.println(new String(data));
    }

    @Test
    public void getChildNode() throws Exception {
        List<String> list = client.getChildren().forPath("/app4");
        System.out.println(list);
    }

    @Test
    public void getNodeStatus() throws Exception {
        Stat status = new Stat();
        System.out.println(status);
        client.getData().storingStatIn(status).forPath("/app1");
        System.out.println(status);
    }

    // =================================================================================//

    /**
     * @description:
     * 修改节点：
     * 根据版本号修改
     *
     *
     * @date: 2022/5/20 20:27
     */
    @Test
    public void setNode() throws Exception {
        client.setData().forPath("/app1", "updateapp1".getBytes());
    }

    // 先查询出现在的ersion 再根据该version去修改数据
    // 避免其他客户端并发修改导致版本不一致的情况
    @Test
    public void setNodeWithVersion() throws Exception {
        Stat status = new Stat();
        client.getData().storingStatIn(status).forPath("/app1");
        System.out.println("status: " + status);
        System.out.println("version: " + status.getVersion());
        int version = status.getVersion();

        client.setData().withVersion(100).forPath("/app1", "new update".getBytes());
    }


    // =================================================================================//

    /**
     * @description:
     * 删除节点 delete deleteall
     * 删除带有子节点的节点
     * 确保删除成功 防止网络抖动 一直重试
     * 回调
     *
     * @author: isquz
     * @date: 2022/5/20 20:53
     */

    @Test
    public void deleteNode() throws Exception {
        client.delete().forPath("/app1");
    }

    @Test
    public void deleteChildNode() throws Exception {
        client.delete().deletingChildrenIfNeeded().forPath("/app4");
    }

    // 失败后重试 直到删除成功
    @Test
    public void superDelete() throws Exception {
        client.delete().guaranteed().forPath("/app2");
    }

    // 失败后重试 直到删除成功
    @Test
    public void deleteCallBack() throws Exception {
        client.delete().guaranteed().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework client, CuratorEvent event) throws Exception {
                System.out.println("being deleted...");
                System.out.println(event);
            }
        }).forPath("/app1");
    }

    @After
    public void releaseConnextion(){
        if (client != null){
            client.close();
        }
    }



}
