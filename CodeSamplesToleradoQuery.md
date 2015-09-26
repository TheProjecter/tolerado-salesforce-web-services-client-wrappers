# Introduction #
Using queryMore() partner call requires
  * some setting of headers to stubs for batch size
  * using a string query locator handle correctly.
  * using query() call first and queryMore() second time.

Code sample below will show, how you can get rid of all that hassle by using ToleradoQuery

# Sample Code #
```

// Cached, Recoverable Stub
ToleradoPartnerStub pStub = new ToleradoPartnerStub(new Credential("username", "password"));
// Wrapper class for making queryMore calls super easy
// Just pass the SOQL and batch size here, it will take care of the rest
ToleradoQuery q = new ToleradoQuery(pStub, "Select name From lead",
                            250);    
// Do Java style iteration over the ToleradoQuery
while (q.hasMoreRecords()) {
    // Correct query locator used internally 
    SObject[] records = q.getRecords();
    if (records == null || records.length == 0)  break;
    for(sObject lead : records) {
        System.out.println(lead.get_any()[0].getValue());
    }            
            log.debug("Fetched next " + records.length + " records !");
    }
// No try catch block as run time exception is thrown, if the stub can't recover
// the error. 

```