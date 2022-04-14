## docker 

mysql : 
---

windows docker-desktop 的配置文件在用户目录下.docker里面的daemon.json  
docker 的存储目录修改 "data-root": "/mnt/d/Docker/storage/desktop"  

sudo docker run -itd -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7 /bin/bash

daemon.json
```
{
  "builder": {
    "gc": {
      "defaultKeepStorage": "20GB",
      "enabled": true
    }
  },
  "data-root": "/mnt/d/Docker/storage/desktop",
  "experimental": false,
  "features": {
    "buildkit": true
  },
  "registry-mirrors": [
    "https://docker.mirrors.ustc.edu.cn",
    "http://hub-mirror.c.163.com",
    "https://registry.docker-cn.com"
  ]
}

```
拉取镜像：  
docker pull mysql/mysql-server:5.7  

查看本地镜像：  
docker images   

首次启动：  
docker run -itd -p 3306:3306 --name mysqlserver -e MYSQL_ROOT_PASSWORD=123456 mysql/mysql-server:5.7   

docker启动后会自动停止  所以再次启动已经停止的容器：  

docker start a71d75d859bf 后面是ps -a列出来的containerID   

进入命令行：  
docker exec -it a71d75d859bf /bin/bash   

设置root用户远程登陆：  
```
use mysql;  
grant all privileges on *.* to root@'%' identified by '密码' with grant option;  
flush privileges;   

grant all privileges on *.* to root@'%' identified by 'admin' with grant option;
```



win10 使用WSL2 docker 更改存储目录：  
------
1. 首先查看当前wsl:  
```
wsl --list -v
带* 号标记的表示wsl默认使用的是哪个vm  
docker-desktop 一般是docker本身程序的存储 不占用太多空间  
docker-desktop-data 是镜像等占用较大存储的内容 所以改到非C盘  

```
2. 关闭docker  
3. 导出原有docker的data数据
```
wsl --export docker-desktop-data "D:\Docker\wsl\data\docker-desktop-data.tar"
```
4. 取消注册dockers数据
```
wsl --unregister docker-desktop-data
```
5. 重新将第3步导出的data数据导入
第一个路径是存储的文件夹  第二个是原来导出的data包文件  
```
wsl --import docker-desktop-data "D:\Docker\wsl\data" "D:\Docker\wsl\data\docker-desktop-data.tar" --version 2
```


默认存储路径是C:\Users\用户\AppData\Local\Docker\wsl\data下面存储的ex4.vhdx文件  

docker redis
---
docker search redis  

拉取redis ： docker pull redis:3.2.1  

第一次运行：
docker run -p 6379:6379 --name redis -v D:\Docker\redis\conf\redis.conf:/etc/redis/redis.conf -v D:\Docker\redis\data:/data -itd redis:3.2.1 redis-server /etc/redis/redis.conf --appendonly yes --requirepass "Admin_test"

如果启动后容器立马退出  一般启动出错  可以通过docker logs -f -t --tail 100 容器名(redis) 查看错误日志  

配置文件中要注释掉bind 127.0.0.1 即使只在本地连接也要注释掉才能成功  

docker start 容器id 或在docker desktop 里面操作  

docker exec -it redis /bin/bash  进入容器后  

redis-cli -a 密码  



配置文件：  
```
# bind 127.0.0.1
protected-mode yes
port 6379
tcp-backlog 511
timeout 0
tcp-keepalive 300
daemonize no
supervised no
requirepass Admin_test

appendonly yes

appendfilename "appendonly.aof"

appendfsync everysec

pidfile /var/run/redis_6379.pid
loglevel notice
logfile ""
databases 16
```