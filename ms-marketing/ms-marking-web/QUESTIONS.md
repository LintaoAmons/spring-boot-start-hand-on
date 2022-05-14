# 好像没找到 FeignClient 的实现类
> commit hash : `5093cfbff6557101533f2f7ad6cb0835d7036e10`

```bash
2022-05-14 11:34:13.660 [main] INFO  org.apache.catalina.core.StandardEngine::log - Starting Servlet engine: [Apache Tomcat/9.0.62]
2022-05-14 11:34:13.781 [main] INFO  org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/]::log - Initializing Spring embedded WebApplicationContext
2022-05-14 11:34:13.782 [main] INFO  org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext::prepareWebApplicationContext - Root WebApplicationContext: initialization completed in 967 ms
2022-05-14 11:34:13.941 [main] WARN  org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext::refresh - Exception encountered during context initialization - cancelling refresh attempt: org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'greetingController' defined in file [/Users/lintao.zhang/Documents/CS-self/springboot/ms-marketing/ms-marking-web/target/classes/com/example/marketing/web/controllers/GreetingController.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.example.user.api.feign.UserFeignClient': Unexpected exception during bean creation; nested exception is java.lang.IllegalStateException: No fallbackFactory instance of type class com.example.user.api.feign.UserFeignClient$UserFallbackFactory found for feign client ms-user
2022-05-14 11:34:13.943 [main] INFO  org.apache.catalina.core.StandardService::log - Stopping service [Tomcat]
2022-05-14 11:34:13.956 [main] INFO  org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener::logMessage - 

Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
2022-05-14 11:34:13.982 [main] ERROR org.springframework.boot.SpringApplication::reportFailure - Application run failed
org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'greetingController' defined in file [/Users/lintao.zhang/Documents/CS-self/springboot/ms-marketing/ms-marking-web/target/classes/com/example/marketing/web/controllers/GreetingController.class]: Unsatisfied dependency expressed through constructor parameter 0; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.example.user.api.feign.UserFeignClient': Unexpected exception during bean creation; nested exception is java.lang.IllegalStateException: No fallbackFactory instance of type class com.example.user.api.feign.UserFeignClient$UserFallbackFactory found for feign client ms-user
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:800)
	at org.springframework.beans.factory.support.ConstructorResolver.autowireConstructor(ConstructorResolver.java:229)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.autowireConstructor(AbstractAutowireCapableBeanFactory.java:1372)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1222)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:953)
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:918)
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:145)
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:740)
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:415)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:303)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1312)
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1301)
	at com.example.marketing.web.Application.main(Application.java:11)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'com.example.user.api.feign.UserFeignClient': Unexpected exception during bean creation; nested exception is java.lang.IllegalStateException: No fallbackFactory instance of type class com.example.user.api.feign.UserFeignClient$UserFallbackFactory found for feign client ms-user
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:555)
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
	at org.springframework.beans.factory.config.DependencyDescriptor.resolveCandidate(DependencyDescriptor.java:276)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.doResolveDependency(DefaultListableBeanFactory.java:1389)
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.resolveDependency(DefaultListableBeanFactory.java:1309)
	at org.springframework.beans.factory.support.ConstructorResolver.resolveAutowiredArgument(ConstructorResolver.java:887)
	at org.springframework.beans.factory.support.ConstructorResolver.createArgumentArray(ConstructorResolver.java:791)
	... 19 common frames omitted
Caused by: java.lang.IllegalStateException: No fallbackFactory instance of type class com.example.user.api.feign.UserFeignClient$UserFallbackFactory found for feign client ms-user
	at org.springframework.cloud.openfeign.FeignCircuitBreakerTargeter.getFromContext(FeignCircuitBreakerTargeter.java:78)
	at org.springframework.cloud.openfeign.FeignCircuitBreakerTargeter.targetWithFallbackFactory(FeignCircuitBreakerTargeter.java:62)
	at org.springframework.cloud.openfeign.FeignCircuitBreakerTargeter.target(FeignCircuitBreakerTargeter.java:55)
	at org.springframework.cloud.openfeign.FeignClientFactoryBean.getTarget(FeignClientFactoryBean.java:451)
	at org.springframework.cloud.openfeign.FeignClientFactoryBean.getObject(FeignClientFactoryBean.java:402)
	at org.springframework.cloud.openfeign.FeignClientsRegistrar.lambda$registerFeignClient$0(FeignClientsRegistrar.java:235)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1249)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1191)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:582)
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542)
	... 28 common frames omitted
```