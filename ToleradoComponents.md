This page explains about various components of Tolerado

# Introduction #

Tolerado has 3 high level components.

  1. ToleradoStub(s)
  1. ToleradoQuery
  1. ToleradoSObject

## ToleradoStub(s) ##
These stubs are set of huge wrapper classes over all the web service calls exposed by partner, metadata and apex web service calls. It gives the fault tolerant behavior to each web service method.
We are providing ToleradoStub implementation for 4 salesforce WSDLs i.e. enterprise, partner, apex and metadata. More details below

| **WSDL** | **Tolerado Stub** | **Code** | **Java Docs** |
|:---------|:------------------|:---------|:--------------|
| partner.wsdl | ToleradoPartnerStub | [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/trunk/Tolerado/src/com/tgerm/tolerado/axis14/partner/ToleradoPartnerStub.java) |               |
| metadata.wsdl | ToleradoMetaStub  | [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/trunk/Tolerado/src/com/tgerm/tolerado/axis14/metadata/ToleradoMetaStub.java) | [here](http://tgerm-docs.appspot.com/wsdocs/com/tgerm/tolerado/axis14/metadata/ToleradoMetaStub.html) |
| apex.wsdl | ToleradoApexStub  | [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/trunk/Tolerado/src/com/tgerm/tolerado/axis14/apex/ToleradoApexStub.java) | [here](http://tgerm-docs.appspot.com/wsdocs/com/tgerm/tolerado/axis14/apex/ToleradoApexStub.html) |
| enterprise.wsdl | ToleradoEnterpriseStub | [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/trunk/Tolerado/src/com/tgerm/tolerado/axis14/enterprise/ToleradoEnterpriseStub.java) |               |

**Code samples** for ToleradoStubs can be found [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/CodeSamplesToleradoStubs)

## ToleradoQuery ##
Its a partner query helper class. When querying with partner binding you can directly fetch only 500 records. To fetch more then 500 one needs to use queryMore() API, this API requires setting some headers and maintaining a cursor on client. This class simplifies and exposes and easy to use interface to queryMore() API, so it does all the ground work for making the call correctly.

  * Complete Source for ToleradoQuery is available [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/trunk/Tolerado/src/com/tgerm/tolerado/axis14/partner/ToleradoQuery.java)
  * Tolerado Query [Code Samples](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/CodeSamplesToleradoQuery)


## ToleradoSobject ##
Wraps the com.sforce.soap.partner.sobject.SObject class, so that creating, updating and working with attributes can be pretty correct and easy.

  * Complete source of ToleradoSobject is available [here](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/source/browse/trunk/Tolerado/src/com/tgerm/tolerado/axis14/partner/ToleradoSobject.java)
  * ToleradoSobject [Code samples](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/wiki/CodeSamplesToleradoSObject)