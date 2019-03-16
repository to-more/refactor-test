
#### Explanation of item 1

 * Reduce the number of parameters (method logMessage) because that indicates that the method does a lot of things
 * Replace if statements for a more polymorphic structure 
 * Implement a strategy to manage the different ways of logging
 * Implement a singleton for database connection 
 
 #### TODO
 * Make the singleton thread-safe
 * Extract database parameters to a configuration file
 
 #### Run test
 ```bash
 ./gradlew clean test
```