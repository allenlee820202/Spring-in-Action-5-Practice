docker run -d -e MYSQL_ROOT_PASSWORD=letmein -v ~/Documents/workspace-sts-3.9.4.RELEASE/Spring-in-Action-5-Sample-Code/Chapter5/src/main/resources/:/app --name tacocloud mysql:latest
docker exec -it tacocloud bash
