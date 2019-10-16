
## How to execute the tests


  - To run all features:
  ```mvn integration-test```

  - To run all features and produce an aggregated report: 
  ```mvn verify```
  - Serenity properties can be found in serenity.properties. Many properties can be changed here, E.g. browser, screensize etc...
  - Aggregated report can be found at ```./target/site/index.html``` including screenshots and request/reponse details for api calls.

### Prerequisites

Tests require a minimum of maven3, chromedriver installed to PATH and chrome browser.
### Executing features from Intellij
Individual tests can be run within Intellij using the Cucumber plugin (use ```net.serenitybdd.cucumber.cli.Main``` for the run configuration Main class).

### Documentation
http://thucydides.info/docs/serenity-staging/

https://github.com/rest-assured/rest-assured/wiki/

https://www.seleniumhq.org/docs/