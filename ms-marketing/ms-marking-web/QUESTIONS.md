# 删除了 fallbackFactory，程序能够启动，但是call不通
> commit hash: 6c92d501c329d1f5f7406fcf6a1b9f085e42e8d9

```bash
2022-05-14 12:09:22.603 [main] INFO  org.apache.coyote.http11.Http11NioProtocol::log - Starting ProtocolHandler ["http-nio-12080"]
2022-05-14 12:09:22.619 [main] INFO  org.springframework.boot.web.embedded.tomcat.TomcatWebServer::start - Tomcat started on port(s): 12080 (http) with context path ''
2022-05-14 12:09:22.627 [main] INFO  com.example.marketing.web.Application::logStarted - Started Application in 1.304 seconds (JVM running for 1.554)
2022-05-14 12:09:27.942 [http-nio-12080-exec-1] INFO  org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/]::log - Initializing Spring DispatcherServlet 'dispatcherServlet'
2022-05-14 12:09:27.943 [http-nio-12080-exec-1] INFO  org.springframework.web.servlet.DispatcherServlet::initServletBean - Initializing Servlet 'dispatcherServlet'
2022-05-14 12:09:27.944 [http-nio-12080-exec-1] INFO  org.springframework.web.servlet.DispatcherServlet::initServletBean - Completed initialization in 1 ms
2022-05-14 12:09:28.159 [http-nio-12080-exec-1] ERROR org.apache.catalina.core.ContainerBase.[Tomcat].[localhost].[/].[dispatcherServlet]::log - Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is com.netflix.hystrix.exception.HystrixRuntimeException: UserFeignClient#getUserById(long) failed and fallback failed.] with root cause
java.net.ConnectException: Connection refused (Connection refused)
        at java.net.PlainSocketImpl.socketConnect(Native Method)
        at java.net.AbstractPlainSocketImpl.doConnect(AbstractPlainSocketImpl.java:476)
        at java.net.AbstractPlainSocketImpl.connectToAddress(AbstractPlainSocketImpl.java:218)
        at java.net.AbstractPlainSocketImpl.connect(AbstractPlainSocketImpl.java:200)
        at java.net.SocksSocketImpl.connect(SocksSocketImpl.java:394)
        at java.net.Socket.connect(Socket.java:606)
        at sun.net.NetworkClient.doConnect(NetworkClient.java:175)
        at sun.net.www.http.HttpClient.openServer(HttpClient.java:463)
        at sun.net.www.http.HttpClient.openServer(HttpClient.java:558)
        at sun.net.www.http.HttpClient.<init>(HttpClient.java:242)
        at sun.net.www.http.HttpClient.New(HttpClient.java:339)
        at sun.net.www.http.HttpClient.New(HttpClient.java:357)
        at sun.net.www.protocol.http.HttpURLConnection.getNewHttpClient(HttpURLConnection.java:1226)
        at sun.net.www.protocol.http.HttpURLConnection.plainConnect0(HttpURLConnection.java:1162)
        at sun.net.www.protocol.http.HttpURLConnection.plainConnect(HttpURLConnection.java:1056)
        at sun.net.www.protocol.http.HttpURLConnection.connect(HttpURLConnection.java:990)
        at sun.net.www.protocol.http.HttpURLConnection.getInputStream0(HttpURLConnection.java:1570)
        at sun.net.www.protocol.http.HttpURLConnection.getInputStream(HttpURLConnection.java:1498)
        at java.net.HttpURLConnection.getResponseCode(HttpURLConnection.java:480)
        at feign.Client$Default.convertResponse(Client.java:109)
        at feign.Client$Default.execute(Client.java:105)
        at feign.SynchronousMethodHandler.executeAndDecode(SynchronousMethodHandler.java:119)
        at feign.SynchronousMethodHandler.invoke(SynchronousMethodHandler.java:89)
        at org.springframework.cloud.openfeign.FeignCircuitBreakerInvocationHandler.lambda$asSupplier$1(FeignCircuitBreakerInvocationHandler.java:112)
        at org.springframework.cloud.netflix.hystrix.HystrixCircuitBreaker$1.run(HystrixCircuitBreaker.java:45)
        at com.netflix.hystrix.HystrixCommand$2.call(HystrixCommand.java:302)
        at com.netflix.hystrix.HystrixCommand$2.call(HystrixCommand.java:298)
        at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:46)
        at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:35)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30)
        at rx.Observable.unsafeSubscribe(Observable.java:10327)
        at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:51)
        at rx.internal.operators.OnSubscribeDefer.call(OnSubscribeDefer.java:35)
        at rx.Observable.unsafeSubscribe(Observable.java:10327)
        at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:41)
        at rx.internal.operators.OnSubscribeDoOnEach.call(OnSubscribeDoOnEach.java:30)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:48)
        at rx.internal.operators.OnSubscribeLift.call(OnSubscribeLift.java:30)
        at rx.Observable.unsafeSubscribe(Observable.java:10327)
        at rx.internal.operators.OperatorSubscribeOn$SubscribeOnSubscriber.call(OperatorSubscribeOn.java:100)
        at com.netflix.hystrix.strategy.concurrency.HystrixContexSchedulerAction$1.call(HystrixContexSchedulerAction.java:56)
        at com.netflix.hystrix.strategy.concurrency.HystrixContexSchedulerAction$1.call(HystrixContexSchedulerAction.java:47)
        at com.netflix.hystrix.strategy.concurrency.HystrixContexSchedulerAction.call(HystrixContexSchedulerAction.java:69)
        at rx.internal.schedulers.ScheduledAction.run(ScheduledAction.java:55)
        at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
        at java.util.concurrent.FutureTask.run(FutureTask.java:266)
        at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
        at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
        at java.lang.Thread.run(Thread.java:748)
```

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