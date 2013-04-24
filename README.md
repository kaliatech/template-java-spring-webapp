template-java-spring-webapp
===========================
My template directory structure and files for bootstrapping a java/spring/maven web app.

If you are working on a java web project and have to restart the server to see code changes, then you are doing it wrong and all the new kids will laugh at you.


Status as of 2013-04-24
-----------------
Directory structure is still dirty, but will compile and run in a servlet container with minimal additional setup.  This code includes examples for:

* JPA/Hibernate with Annotations
* SpringData-JPA (<-- very nice and substantially cuts down on boiler-plate persistence code)
 * Includes hard-to-find example for adding-to/customizing the automatically generated JPA repository interface
* Controller with Annotations
* Transactions with Annotations 
* Scheduled Services with Annotations
* Spring Security Setup
* RESTful api support with automatic content negotiation
* External properties configuration (still XML, but Java config is supported)
* Maven multimodule organization
* Automating build via maven w/ ant
* And More


Initial Setup
-----------------
After cloning, do global search-and-replace on the following (file/directories/text):
* mycompany - used for package naming
* myproj - used for project naming, package naming, variables, and more

 Eventually I'll document:
* How to use the common environment setup strategy (optional)
* How to setup an IDE
 * This architecture has been used with Eclipse, IntelliJ, and Netbeans.
* How to use maven without any ide
* How to setup the servlet container, incl. support for runtime debugging
* How to setup and use JRebel
* Using Freemarker and inverted master template pattern
* How to use the automated build
 

Future Tasks
-----------------
* Need to integrate a distributed 2nd level hibernate cache.
 * Once this is done, will add a new "myproj-admin-webapp" project showing how
to create separate webapp that correctly/safely can be deployed independently of main web app.
 * Will likely use Terracotta, although will also review EHCache, Memcache, or Hazelcast

* Add unit test examples and basic mock support
 
* Add automated minification & bundling for JavaScript and CSS
 * including automatic switching to CDN

* Add internationalization and localization support

* Add support for single-sign-on in the security setup
* Add support for external authentication (OpenId, etc)
 
* Need to provide more complete web scaffolding starting point
 * integrate AngularJs?
 * show cross-domain AJAX to RESTful services

 
 
 
 