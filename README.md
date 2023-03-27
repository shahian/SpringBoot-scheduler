# SpringBoot-scheduler
@Scheduled is an annotation provided by the Spring Framework that can be used to schedule the execution of a method in a Spring application. It allows you to specify a fixed delay or a cron expression to control the frequency of method execution.

Here's an example of how to use @Scheduled in a Spring Boot application:
```java
@Service
public class MyService {
    
    @Scheduled(fixedDelay = 1000)
    public void runTask() {
        // code to be executed periodically
    }
}
```


