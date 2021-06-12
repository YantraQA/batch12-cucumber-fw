# Cucumber Selenium Framwork

---

#### Steps


----

### Phase 1
* Create Project
* Add Dep in POM
* Write Amazon Scn in feature file:
   * Search
   * Product Details
   * Scenario Outline for Product Search
* Cucumber feature:
   * Background
   * Scenario Outline
   * Parametrization
* Create Runner
* Create Step Defs
* Add Log 4j2
* Add Extent Report
* Add Hooks to take screen shot for each line

---

### Phase 2

* Create two Step Defs
* Divide the Step def methods in multiple file
* DI using Cucumber Pico container

### Phase 3
* Add more test cases
* Learn Data Tables
* Parallel Execution



### Phase 4
Jenkins

----

#### Code Concepts:

### Test Context
```java
public class TestContext {

    public WebDriver driver;
    public String base_url = "https://amazon.in";
    public int implicit_wait_timeout_in_sec = 20;
    public Scenario scn;

    public CmnPageObjects cmnPageObjects;
    public HomePageObjects homePageObjects;
    public SignInPageObjects signInPageObjects;
    public SearchPageObjects searchPageObjects;
    public ProductDescriptionPageObjects productDescriptionPageObjects;

    public void initializeWebDriver() throws Exception {
        //Get the browser name by default it is chrome
        String browserName = WebDriverFactory.getBrowserName();
        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
        log.info("Browser invoked.");
    }

    public void intializePageObjects(){
        cmnPageObjects = new CmnPageObjects(driver);
        homePageObjects = new HomePageObjects(driver);
        signInPageObjects = new SignInPageObjects(driver);
        searchPageObjects = new SearchPageObjects(driver);
        productDescriptionPageObjects = new ProductDescriptionPageObjects(driver);
    }
}
```

* Step Defs DI injection of Test Context

```java
@Log4j2
public class StepDefs1 {

  TestContext testContext;
  public Scenario scn;

  //Dependency Injections using Pico Container
  public StepDefs1(TestContext testContext) {
    this.testContext = testContext;
    this.scn = testContext.scn;
  }
}
```
