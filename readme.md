quotableAPI-cucumber-java-maven
=================

QuotableAPI : Automation Testing Using Java

cucumber is a behavior driven development (BDD) approach to write automation test script to test Web and Backend applications.
It enables you to write and execute automated acceptance/unit tests.
It is cross-platform, open source and free.

Download a Framework
--------------
* QuotableApi - https://github.com/sreekarsunku/quotableApi

Framework Architecture
--------------
	quotableapi
		|
		|_src/main/java
		|_src/main/resources
		|_src/test/java
		|	|_com.project.quotableapi.quotableapi
		|	|	|_QuotableApi.java
		|	|_com.project.quotableapi.quotableapi.runner
		|	|	|_CucumberRunner.java
		|	|_com.project.quotableapi.quotableapi.stepdef
		|	|	|_QuotableStepDef.java
		|_src/test/resources
		|	|_features
		|	|	|_quotable_api.feature
    

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.
* **src/test/java/StepDefinition** - step defintion under this package refers for feature steps.
* **src/test/java/runner** - this package contains cucumber runner (CucumberRunner.java) where glue code location (step defintions) is defined.
* **src/test/java/quotableapi** - reusable methods realted quotable api are defined here.
* * **target** - all output reports are stored here.


Running test
--------------

Go to your project directory from terminal and hit following commands
* `mvn test`
* `mvn verify serenity::aggregate` generates a Serenity report
* `mvn test -Dcucumber.options="classpath:features/my_first.feature"` to run specific feature.


Teamcity Run Report Screenshots
-----------------------
1. Project configured in teamcity
![image](https://user-images.githubusercontent.com/11191193/124349247-d28ae100-dc0b-11eb-836c-71db2abb77d5.png)

2. Test Run Overview
![image](https://user-images.githubusercontent.com/11191193/124349329-17167c80-dc0c-11eb-9e43-6933a357e82d.png)

3. Build Log Overview
![image](https://user-images.githubusercontent.com/11191193/124349365-51801980-dc0c-11eb-83bf-d9798fe769f2.png)

4. Report Overview
![image](https://user-images.githubusercontent.com/11191193/124349431-91df9780-dc0c-11eb-9a99-6046e27bed9b.png)

![image](https://user-images.githubusercontent.com/11191193/124349481-d3704280-dc0c-11eb-83e3-8a2faf399f84.png)

