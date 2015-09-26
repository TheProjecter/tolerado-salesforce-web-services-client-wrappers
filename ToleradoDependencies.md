This page explains what are the other 3rd party lib dependencies for Tolerado

# Tolerado Dependencies #

Tolerado dependencies are broadly classified into to areas

  1. WSDL2Java Dependencies
  1. Other Dependencies


# WSDL2Java Dependencies #

These dependencies include classes generated via Apache Axis 1.4. We already did WSDL2Java on partner, apex and metadata WSDLs, so ready to use JARS for each partner, apex and metadata are available at the [downloads page](http://code.google.com/p/tolerado-salesforce-web-services-client-wrappers/downloads/list). If you have already generated that code via Axis-1.4 then you can use that directly too.

# Other Dependencies #

Tolerado code depends directly indirectly on following libraries. I said indirectly because many of these are Apache Axis dependencies. Here is the list

| **Library Name** | **Jar File** | **Remarks** |
|:-----------------|:-------------|:------------|
| Apache Axis 1.4  | axis.jar     |             |
| Apache Commons Discovery | commons-discovery-0.2.jar  |             |
| Apache commons lang | commons-lang-2.5.jar |             |
| Apache Common Logging | commons-logging-1.1.1.jar | Used by Tolerado code directly, we are leaving logging stuff open so that you can plugin you logger with Tolerado. |
| JAX-RPC          | jaxrpc.jar   |             |
| Log4j            | log4j-1.2.16.jar | **OPTIONAL** include, if you are using log4j with commons logging. Otherwise feel free to remove this. |
|                  | wsdl4j-1.6.2.jar |             |

### NOTE ###
Listed are the minimal library versions, you guys can try with latest ones. Hope they should work well.