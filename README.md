# SpringBoot-scheduler
@Scheduled is an annotation provided by the Spring Framework that can be used to schedule the execution of a method in a Spring application. It allows you to specify a fixed delay or a cron expression to control the frequency of method execution.

Here's an example of how to use @Scheduled in a Spring Boot application:
```
@Service
public class MyService {
    
    @Scheduled(fixedDelay = 1000)
    public void runTask() {
        // code to be executed periodically
    }
}
```
In the above example, we have annotated the runTask() method with @Scheduled(fixedDelay = 1000), which means that the method will be executed every 1000 milliseconds (i.e., 1 second) after the completion of the previous execution.

We can also use a cron expression to specify a more complex scheduling pattern. For example:
```
@Service
public class MyService {
    
    @Scheduled(cron = "0 0 12 * * ?")
    public void runTask() {
        // code to be executed every day at 12:00 PM
    }
}
```



