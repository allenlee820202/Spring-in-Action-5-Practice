## Missing parts in the textbook
### Necessary dependencies in the ```.pom``` file
```xml
<dependency>
  <groupId>mysql</groupId>
  <artifactId>mysql-connector-java</artifactId>
</dependency>
```

## Tacocloud MySQL server setup
### Prerequisites
1. Docker
2. Docker-compose

### Start MySQL server
```bash
cd Chapter5/src/main/resources/
docker-compose up
```

### Load MySQL schemas
```bash
docker exec -it [container id or name] bash
cd /app
sh load_default_db.sh
```
