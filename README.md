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

1. Minutes (0-59)
2. Hours (0-23)
3. Day of the month (1-31)
4. Month (1-12)
5. Day of the week (0-6, where 0 = Sunday)
6. The sixth and optional seventh field specifies the year. For example, the following expression runs a script every day at 1:30 AM:

```
30 1 * * *
```
We can also use special characters in a cron expression to specify more complex schedules. For example:

1. * - indicates all possible values for a field</br>
2. / - specifies increments</br>
3. , - specifies a list of values</br>
4. - - specifies a range of values</br>
5. ? - specifies no specific value</br>

Here is an example of a cron expression that runs a script every 10 minutes during business hours on weekdays:
```
0/10 9-17 * * 1-5
```
In this expression, 0/10 means "every 10 minutes", 9-17 means "between 9 AM and 5 PM", and 1-5 means "from Monday to Friday".

Cron expressions can be used not only in Unix, but also in other platforms and programming languages. For example, in Java Spring Boot, you can use cron expressions with the @Scheduled annotation to schedule the execution of a method.

Note that in order to use @Scheduled, we need to enable scheduling in your Spring Boot application by adding the @EnableScheduling annotation to your configuration class or to your main class.

