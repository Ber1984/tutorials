![img.png](img.png)

- Simply put, we use @Primary to give higher preference to a bean when there are multiple beans of the same type.

@Primary annotation in Spring
When there are multiple beans available of same type in Spring container, all of them are qualified to be autowired to single-valued dependency. That causes ambiguity and leads to throw an exception by framework. @Primary indicates that a bean should be given preference when multiple candidates are qualified to autowire a single-valued dependency.

# Use @Primary With @Component


They both override the getManagerName() of the Manager interface. Also, note that we mark the GeneralManager bean with @Primary.

This time, @Primary only makes sense when we enable the component scan:

https://www.baeldung.com/spring-primary

We use @Qualifier in Spring to autowire a specific bean among same type of beans, where as @Primary is used to give high preference to the specific bean among multiple beans of same type to inject to a bean.
