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
In the above example, we have specified a cron expression that will execute the runTask() method every day at 12:00 PM.

Cron is a Unix utility that allows you to schedule tasks to run periodically at specific times or intervals. A cron expression is a string that consists of six or seven fields, separated by whitespace, that define a schedule for running a command or script.

Here is an example of a cron expression:
```
* * * * * *
```
Each field in the expression corresponds to a particular time element, as follows:

Minutes (0-59)
Hours (0-23)
Day of the month (1-31)
Month (1-12)
Day of the week (0-6, where 0 = Sunday)
The sixth and optional seventh field specifies the year. For example, the following expression runs a script every day at 1:30 AM:
Note that in order to use @Scheduled, we need to enable scheduling in your Spring Boot application by adding the @EnableScheduling annotation to your configuration class or to your main class.
```
30 1 * * *
```

