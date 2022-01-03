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
use mysql;  
grant all privileges on *.* to root@'%' identified by '密码' with grant option;  
flush privileges;   

