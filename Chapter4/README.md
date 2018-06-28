## Missing parts in the textbook
### Necessary dependencies in the ```.pom``` file
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>javax.persistence</groupId>
  <artifactId>javax.persistence-api</artifactId>
  <version>2.2</version>
</dependency>
```

## Inspect h2-console using your browser
### Log in
1. Go to ```localhost:8080/h2-console```
2. Set ```JDBC URL``` to ```jdbc:h2:mem:testdb```
3. Test connection should show _successful_
4. Click _connect_

### Reference
See [this youtube video](https://www.youtube.com/watch?v=tSJW5NKPhcM).
