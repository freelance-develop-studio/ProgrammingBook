Spring course for begginers
=================================


Table of contents
===========================

<!--ts-->
   * [Introduction into Java EE](#introJavaEE)
   * [What is Spring?](#whatIsSpring)
   * [Why use Spring?](#whyUseSpring)
   * [Spring components](#springComponents)
   * [Concept of Spring beans and dependency injection](#conceptOfSpringBeans)
   * [Spring annotations](#springAnnotations)
<!--te-->


<a name=introJavaEE></a>
## Introduction into Java EE
Java EE is a collection of technologies and APIs for the Java platfrom, designed to support "Enterprise" applications.

Enterprise applications can generally be classed as large-scale, distributed, transactional, and highly-available applications, designed to support mission-critical business requirements.

Java EE is used for banks or stock exchanges.

Some of the core technologies used in JEE are JDBC, JNDI, EJBs, RMI, JSP and Java servlets.

### Java EE Overview
<div align="center">
	<img src="images/image1.PNG"/>
</div>

### Where does our web app code run ?
Web apps that we create, need to run in a container on the web server. We do not run them like we would a typical Java application.

These web servers woudl typically be housed in a 'server room' and connected to the internet, and as developers, we would deploy our apps to the machine "running" the web server.

We vill be using a web server called Tomcat in this course, and intalling and running it on our local machine for development purposes.

### What are components ?
JEE appplications are made up of components. They are self contained functional software assembled into a Java EE application. For example: Servlet, JSP pages, JSF...



<a name=whatIsSpring></a>
## What is Spring ?
Spring is arguably the most popular Java application development framework for enterprises today. Spring framework is used by milions of developers around the world.

Spring framework is open source and was originally created by Rod Johnson.

Spring first release was made in June 2003 under the Apache 2.0 license. Spring was born out of necessity and specifically to address some huge problems faced by J2EE developers using the then comlicated and low performing EJB model of the time.


<a name=whyUseSpring></a>
## Why use Spring ?
* Spring provides comprehensive infrastructure support for developing Java applications. Spring handles the infrastructure so you can focus on the business logic.
* Spring is a lightweight framework.

	*	 Spring advocates the POJO (Plain old Java Object) programming model. POJOs avoid the need for a dedicated application server for deployment. These application can be massive, and consume vast resources. Instead we can easily use a lightweight webserver such as Tomcat for deploying Spring applications. As you have seen already Tomcat was a small download, and it does not consume a lot of resources either.
	*	 Spring is highly modular meaning you are free to pick and choose modules of Spring that meet your requirements and to then ignore the rest. This makes your application much more lightweight as they only include the modules you have decided on, which means smaller filesizes, reduced uploads, and hence faster deployment.
* Spring philosophy advocates the reuse of existing framework and technologies such as the Logging framework, the ORM framework, JEE itself and many more.
* Spring POJO programming model makes testing spring framework applications very easy.
* Spring makes life easy by allowing developers to focus on the business logic while it takes care of the low level "plumbing".



<a name=springComponents></a>
## Spring components
Spring contains four moduls Core container, Data access, Web and Test.

<div align="center">
	<img src="images/image2.png"/>
</div>

### Core container
* Beans and core - the modules provide the basics of the framework such as IoC (Inversion of Control), DI (Dependency injection).
* Context - this module builds up on the foundation provided by Beans and Core modules and provides the means to access objects in a framework style.
* SpEL (Spring language expression) - provides Spring specific expression language for querying and manipulating objects.


### Data access/integration
* JDBC - interface (API) specification for connecting programs written in Java to the data in popular databases.
* ORM -  technique for converting data between incompatible type systems using object-oriented programming languages. Spring provide interface for famous ORM tools as Hibernate
* OXM - Spring Object XML Mappers
* JMS - allows integrations with JMS (Java messaging service)
* Transactions - allows creation of transactional applications

### Web
* WebSocket -  creates a persistent connection between a user and a web service for 2-way communication. 
* Sevlet - Java Servlets are server-side Java program modules that process and answer client requests and implement the servlet interface.
* Web - contains MVC architecture, JSP (Java servlet pages - are a server-side programming technology that enables the creation of dynamic web pages, it helps developers embed java code in normal HTML pages by making use of special JSP tags) 
* Portlet - similar as servlets but servlets can render complete web pages, whereas portlets renders html fragments.

### Test
This module provides support for creating applications for unit testing and integration testing.



<a name=conceptOfSpringBeans></a>
## Concept of Spring beans and dependency injection

### What is bean? 
A bean is an object that is instantiated, assembled, and otherwise managed by a Spring IoC container. These beans are created with the configuration metadata that you supply to the container.
Bean is POJO object + metadata shortly.

### What is POJO?
POJO is Plain Old Java Object is a Java object not bound by any restriction other than those forced by the Java Language Specification. I.e., a POJO should not have to extend prespecified classes, implement prespecified interface, contain prespecified annotations.

### Bean scopes

When defining a <bean> you have the option of declaring a scope for that bean. For example, to force Spring to produce a new bean instance each time one is needed, you should declare the bean's scope attribute to be prototype. Similarly, if you want Spring to return the same bean instance each time one is needed, you should declare the bean's scope attribute to be singleton.

The Spring Framework supports the following five scopes, three of which are available only if you use a web-aware ApplicationContext. The default scope for bean is a singleton.

* **Singleton**: This scopes the bean definition to a single instance per Spring IoC container (default).
* **Prototype**: This scopes a single bean definition to have any number of object instances.
* **Request**: This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext.
* **Session**: This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.
* **Global-session**: This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.

__Note__: The ApplicationContext is the central interface within a Spring application for providing configuration information to the application. It is read-only at run time, but can be reloaded if necessary and supported by the application.

## Inversion of Control
The Inversion of Control (IoC) and Dependency Injection (DI) patterns are all about removing dependencies from your code.

For example, say your application has a text editor component and you want to provide spell checking. Your standard code would look something like this:

```
public class TextEditor {

    private SpellChecker checker;

    public TextEditor() {
        this.checker = new SpellChecker();
    }
}
```

What we've done here creates a dependency between the TextEditor and the SpellChecker. In an IoC scenario we would instead do something like this:

```
public class TextEditor {

    private IocSpellChecker checker;

    public TextEditor(IocSpellChecker checker) {
        this.checker = checker;
    }
}
```

In the first code example we are instantiating SpellChecker (this.checker = new SpellChecker();), which means the TextEditor class directly depends on the SpellChecker class.

In the second code example we are creating an abstraction by having the SpellChecker dependency class in TextEditor constructor signature (not initializing dependency in class). This allows us to call the dependency then pass it to the TextEditor class like so:

```
SpellChecker sc = new SpellChecker; // dependency
TextEditor textEditor = new TextEditor(sc);
```

Now the client creating the TextEditor class has the control over which SpellChecker implementation to use because we're injecting the dependency to the TextEditor signature.

## Dependency injection
Spring helps in the creation of loosely coupled applications because of Dependency Injection.

In Spring, objects define their associations (dependencies) and do not worry about how they will get those dependencies. It is the responsibility of Spring to provide the required dependencies for creating objects.

Suppose we have an object Employee and it has a dependency on object Address. We would define a bean corresponding to Employee that will define its dependency on object Address.

When Spring tries to create an Employee object, it will see that Employee has a dependency on Address, so it will first create the Address object (dependent object) and then inject it into the Employee object.



<a name=springAnnotations></a>
## Spring annotations
Annotation is a form of syntactic metadata that can be added to Java source code. Annotatino you can place on  classes, methods, variables, parameters.

### History
The Java Programming language provided support for Annotations from Java 5.0. Leading Java frameworks were quick to adopt annotations and the Spring Framework started using annotations from the release 2.5. Due to the way they are defined, annotations provide a lot of context in their declaration.

Prior to annotations, the behavior of the Spring Framework was largely controlled through XML configuration. Today, the use of annotations provide us tremendous capabilities in how we configure the behaviors of the Spring Framework.

### XML based configuration
**Pros**

* XML configuration is outside the Java classes. The whole configuration is limited to a few files and can be viewed easily. If configuration needs to be changed then the code does not need to go through the process of recompilation.
* Using XML helps to centralize configuration metadata. The configuration code is located in a few text files and can be changed easily, if required.
* XML configuration is more verbose and might be a good fit for beginners to understand what is going on. 

**Cons**

* XML typing can be error prone and typos are difficult to debug. Even though we have some great tools like the spring-ide that helps us to write error free xml configuration files, manual typing sometimes becomes unavoidable. Also XML is not type safe e.g. Java code via the compiler will validate types while compiling, and throw an error if you try to assign the wrong type to a variable. This also applies to method arguments, since you are passing explicit types to them. The Java language is designed to enforce type. This safety is not available in XML
* For example. in XML it is possible to add an argument to a bean's constructor but to forget injection this argument when defining the bean in the XML. This is not possible with annotations since mistakes of this type will be flagged by the compiler.


### Annotation based configuration
**Pros**

* Using annotations usually leads to shorter and more concise configurations vs XML.
* Some developers prefer to have their dependency wiring closer to the source and hence might prefer annotations over xml.
* The annotations ensure type safety. It can also self document a class, taht you can look in the class and truly see what is being injected by Spring.


**Cons**

* Annotations reside in your source code.
* Annotations leads to more decentralized configuration of metadata whereby all metadata is strewn all over your code base. This might lead to a less control over the configuration information.
* Annotations can clutter the POJO. You could actually argue that it is no longer a POJO anymore.
* If you change, add or delete annotations, it requires code recompilation.
* Annotations may be considered less intuitive in nature because it is brevity expecially if you are a beginner.

### Core Spring annotations

* **@Required**: annotation indicates that the affected bean must be populated at configuration time with the required property.
* **@Autowired**: annotation injects object dependency implicitly. This annotation is applied on fields, setter methods, and constructors.
* **@Qualifier**: This annotation is used along with @Autowired annotation. When you need more control of the dependency injection process, @Qualifier can be used. @Qualifier can be specified on individual constructor arguments or method parameters. This annotation is used to avoid confusion which occurs when you create more than one bean of the same type and want to wire only one of them with a property.
* **@Configuration**: is an analog for XML configuration file – it is configuration using Java class. Java class annotated with @Configuration is a configuration by itself and will have methods to instantiate and configure the dependencies.
* **@ComponentScan**: annotation to allow Spring to know the packages to scan for annotated components. @ComponentScan is also used to specify base packages using basePackageClasses or basePackage attributes to scan. If specific packages are not defined, scanning will occur from the package of the class that declares this annotation.
* **@Bean**: annotation works with @Configuration to create Spring beans. Annotation is used at the method level.
* **@Value**:  indicates a default value expression for the field or parameter to initialize the property with.

### Spring stereotype annotations
* **@Component**:  annotation marks the Java class as a bean or say component so that the component-scanning mechanism of Spring can add into the application context.
* **@Controller**: annotation is used to indicate the class is a Spring controller. This annotation can be used to identify controllers for Spring MVC or Spring WebFlux.
* **@Service**: marks a Java class that performs some service, such as execute business logic, perform calculations and call external APIs. This annotation is a specialized form of the Component annotation intended to be used in the service layer.
* **@Repository**: annotation is used on Java classes which directly access the database. The Repository annotation works as marker for any class that fulfills the role of repository or Data Access Object. This annotation has a automatic translation feature. For example, when an exception occurs in the Repository there is a handler for that exception and there is no need to add a try catch block.

### Spring boot annotations
* **@EnableAutoConfiguration**: annotation is usually placed on the main application class. The annotation implicitly defines a base “search package”. This annotation tells Spring Boot to start adding beans based on classpath settings, other beans, and various property settings.
* **@SpringBootApplication**: is a convenient annotation that adds three annotations (Configuration, EnableAutoConfiguration, ComponentScan) into one.

### Spring DataAccess annotations
* **@Transactional**:  is not enough to activate the transactional behaviour. The annotation is simply a metadata that can be consumed by some runtime infrastructure. This infrastructure uses the metadata to configure the appropriate beans with transactional behaviour.
* **@Cacheable**: each time the method with annotation is called, the cache is checked to see whether the invocation has been already executed and does not have to be repeated.
* **@CachePut**: the method with annotation will always be executed and the result cached.
* **@CacheEvict**: is not that you always want to populate the cache with more and more data. Sometimes you may want remove some cache data so that you can populate the cache with some fresh values. In such a case use the CacheEvict annotation.
* **@CacheConfig**: annotation helps to streamline some of the cache information at one place. 

### Task Execution and Scheduling Annotations

