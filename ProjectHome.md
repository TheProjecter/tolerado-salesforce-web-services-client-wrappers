# What is **Tolerado** ? #
Project "tolerado" is a Java based Client side Framework for better and fault tolerant use of Web Service APIs given by Salesforce. This project is named "tolerado" as it will mainly focus on improving the error handling on client web service calls, i.e. making the client side fixture more fault tolerable. Main focus will be on

  1. Correct exception handling for web service failures. Provision will be made to recover failures which can be retried.
  1. Giving utility and wrapper API's for easing and making development effort less error prone with existing WS client stubs.

Tolerdao will integrate deeply with Salesforce **Enterprise**, **Partner**, **Apex** and **Metadata** WSDL web services. So for these WSDLs, you guys can use your existing WSDL2Java client side Axis stubs with this project or download the pre-generated axis stubs from download page.

### Note ###
This code share project is comaptible with **Apache Axis 1.4 stubs** for salesforce web services. If you want to use Tolerado with [WSC](http://code.google.com/p/sfdc-wsc/), then please switch to **[Tolerado for WSC](http://code.google.com/p/tolerado-sfdc-wsc-apis/)**

# Motivation behind Tolerado ! #
Motive is to create an API that wraps existing Salesforce web service client APIs and

  * Giving a RECOVERABLE framework for each web service method call. This recoverable framework will transparently RETRY all the recoverable web service/remote errors/exceptions rather failing fast.

  * Giving an transparent caching mechanism for salesforce session id/urls, so that we save a login web service call.

  * Giving utility and wrapper API's for easing and making development effort less error prone with existing WS client stubs. For ex.
    * Easing the creation of new Sobjects via wrappers rather using “com.sforce.soap.partner.sobject.SObject” and notorious MessageElement.
    * Giving easy stubs, so that developers are not into hassle of setting right session headers, server urls etc for using either Metadata, Apex or Partner WSDL APIs.

  * Keeping the migration effort to minimal. So classes are designed to fit well with existing Axis generated classes for ex. QueryResult, RunTestsResult etc.


# Why use/migrate to Tolerado ? #
  * Your Apache Axis web service client code will be too simplified, more fault tolerant/recoverable and readable too.
    * This [post](http://www.tgerm.com/2010/07/salesforce-java-code-fixes.html) gives **detailed code samples and shows how code will be better and stable at production** ?
    * This [post](http://www.tgerm.com/2010/06/retrying-web-service-exceptions.html) explains why recovering from web service exceptions is important.

  * Apex/Metadata WSDL users will get rid of issues and complexities involved in creating correct MetadataBindingStub/ApexBindingStub.
    * If it tooks 15-20 lines of code previously to get correct Metadata binding, now it will take just 1 line.
    * What are the other issues, explained in this [post](http://www.tgerm.com/2010/05/apex-no-operation-available-request.html)

  * Simplified CRUD operations on Sobjects.
    * You no more need to deal with MessageElement class while peforming CRUD operations on SObjects.
    * You will get a clean wrapper i.e. ToleradoSobject that will give simple getter/setters to work with Sobject fields rather dealing with complex Axis MessageElements.
    * Get rid of Out of memory errors, This [post](http://www.tgerm.com/2010/06/messageelement-out-memory-salesforce.html) OOM issue with MessageElement.

  * queryMore() partner calls will be simplified too much via ToleradoQuery.
    * Now you can make queryMore() calls without query cursors handling and all the other house keeping in Soap Stubs.
    * ToleradoQuery offers you an easy Java style interface to do queryMore calls correctly with desired batch size.

# References - Useful Pointers #
All of them are listed in the right side bar under labels, "Featured wiki pages" and "External Links". Still here is a useful list for important references

  * [Getting Started Guide](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/GettingStartedGuide)
  * [Code Samples](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/CodeSamples)
  * [Tolerado Dependencies](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/ToleradoDependencies)
  * [How to add new web service method powered by Tolerado](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/HowToAddNewToleradoWSMethod)
  * [Why tolerado code is better then direct Apache Axis WSDL2Java salesforce stubs](http://www.tgerm.com/2010/07/salesforce-java-code-fixes.html)
  * [Java Docs for Tolerado Classes](http://tgerm-docs.appspot.com/wsdocs/index.html)

# Whats next - TODO ? #
I am code complete(minor stuff remaining) with this project. Still some minor side todo tasks are their.

**TODO List**

  * Do more testing of each part of API.
  * Enhance documentation for ease in using,understanding and contributing to the project

# Special Thanks #
  * **[Jason Oulette](http://developer.force.com/mvp_profile_jason)** : I learned a lot from him and got ideas of Tolerado from one of his projects
  * **My Family** : For sharing their time and weekends, to let me work hard on this project.