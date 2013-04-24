template-java-spring-webapp
===========================
My template directory structure and files for bootstrapping a java/spring/maven web app.

I've been bootstrapping and refining projects continually over the past ten years using some variant of this architecture and file layout.  It always takes a while to setup a new project from scratch though, and so this template is meant to provide an easy starting point that I can update periodically with newer approaches and libraries.

Note that while java/spring/maven might seem unwieldy to many at first, the truth is that when setup correctly, a modern approach makes this combination as agile as any of the newer platforms. (...but with all of the flexiblity and potential of Java and it's many 3rd party libraries.) The only downside, ihmo, is that the Java language is somewhat more verbose than newer options.

A key point though, is that once setup correctly a developer should almost never need to restart (and wait on) the web server.  A developer should be able to change any code (including many annotations) and then immediately refresh the browser to see those code changes applied.  While it requires a lot of background knowledge and external tool support to set things up correctly, this is possible in the Java/Spring/Maven world.  A key component is the use of JRebel, which should be considered a required tool by all modern Java developers.

Every time a Java developer has to wait to see results of code changes, all the new kids will laugh at him.

 
h3. Status as of 2013-04-24
-----------------
Still very much a work in progress.  Directory structure is still dirty, but will compile and run in a servlet container with minimal additional setup.  This code includes examples for:

 * JPA/Hibernate with Annotations
 * SpringData-JPA (<-- very nice and substantially cuts down on boiler-plate persistence code)
 ** Includes hard-to-find example for adding-to/customizing the automatically generated JPA repository interface
 * Controller with Annotations
 * Transactions with Annotations 
 * Scheduled Services with Annotations
 * Spring Security Setup
 * RESTful api support with automatic content negotiation
 * External properties configuration (still XML, but Java config is supported)
 * Maven multimodule organization
 * Automated buildling via ant w/ maven
 * And More
 
As is, should be mostly understable by advanced Java/Spring/Maven developers.  However, likely requires more documentation before would actually be of interest to anyone besides myself.

h3. Initial Setup
-----------------
After cloning, do global search-and-replace on the following (file/directories/text):
 * mycompany - used for package naming
 * myproj - used for project naming, package naming, variables, and more

 Eventually I'll document:
 * How to use the common environment setup strategy (optional)
 * How to setup an IDE
 ** This architecture has been used with Eclipse, IntelliJ, and Netbeans.
 * How to use maven without any ide
 * How to setup the servlet container, incl. support for runtime debugging
 * How to setup and use JRebel
 * How to use the automated build
 

h4. Future Roadmap
 * Need to integrate a distributed 2nd level hibernate cache.
 ** Once this is done, will add a new "myproj-admin-webapp" project showing how
to create separate webapp that correctly/safely can be deployed independently of main web app.
 ** Will likely use Terracotta, although will also review EHCache, Memcache, or Hazelcast

 * Add automated minification & bundling for JavaScript and CSS
 ** including automatic switching to CDN

 * Add internationalization and localization support

 * Add support for single-sign-on in the security setup
 * Add support for external authentication (OpenId, etc)
 
 * Need to flush out web scaffolding
 ** integrate AngularJs?
 ** show cross-domain AJAX to RESTful services

 
 
 
 