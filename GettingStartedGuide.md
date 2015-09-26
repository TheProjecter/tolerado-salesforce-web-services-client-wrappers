As of now this project is wrapping stubs generated via Apache Axis 1.4. Later we will try to address other WSDL2Java generators. So this guide is for you if you are using or planning for Apache Axis 1.4.

# Getting Started with TOLERADO #
  * Prerequisites
  * Running sample code
  * Running Samples via the Tolerado Samples Project



## Prerequisites ##
![http://tolerado-salesforce-web-services-client-wrappers.googlecode.com/files/ToleradoJarDependencies.png](http://tolerado-salesforce-web-services-client-wrappers.googlecode.com/files/ToleradoJarDependencies.png)
  1. You will need to download latest tolerado-core-x.x.jar from [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/downloads/list). This jar has the basic fixture of Tolerado.
  1. Tolerado can work independently with either Partner or Enterprise WSDL. If you are planning to use Tolerado with Enterprise WSDL, then you can download tolerado-enterprise-x.x.jar, but because of Org specific differences, we suggest doing WSDL2Java and generating your own classes for this WSDL. For using with Partner WSDL, download tolerado-partner-1.1.jar.
  1. This is optional, if you want to work with metadata or apex wsdl download respective tolerado-metadata-1.1.jar/ tolerado-apex-1.1.jar files.	You need either of Tolerado enterprise or partner jar files, so depending on your requirement feel free to add any one or both of partner and enterprise Tolerado jars.
  1. This is optional, if you haven't done WSDL2Java over Partner, Metadata and Apex WSDLs. You can download these jars(sfdc-<WSDL NAME>.jar) from the [download page](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/downloads/list). All these Jars are having classes generated from Apache Axis 1.4 WSDL2Java. If you have already done so, you can use you existing generated code.
  1. Make sure you have all the dependencies mentioned [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/ToleradoDependencies). All these jars can also be checked out from SVN [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/#svn/trunk/Tolerado/dependencies/3rdparty)


## Running sample code ##
Once you have all the prerequisites set in your classpath. Code samples for Tolerado are available [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/CodeSamples). Start coping and playing the stuff.


## Running Samples via the Tolerado Samples Project ##
Tolerado Samples is a complete Java project independent of Tolerado main development branch. Its checked into SVN as java project, so you guys can checkout it from [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/#svn/trunk/Tolerado-Samples) and start playing with samples

Here is a video that shows how to checkout and setup Tolerado Samples

<a href='http://www.youtube.com/watch?feature=player_embedded&v=EP2I5UaNU7c' target='_blank'><img src='http://img.youtube.com/vi/EP2I5UaNU7c/0.jpg' width='425' height=344 /></a>