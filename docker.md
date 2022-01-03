## docker 

mysql :
---

sudo docker run -itd -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7 /bin/bash