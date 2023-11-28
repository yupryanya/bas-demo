### <a name="about-system"></a>About

Welcome to my demo Java test automation project designed for a web-based client-server analytics system. This system handles data related to buildings and other objects of the urban environment.

### Contents

- [Technologies and Tools](#tech-and-instruments)
- [Test Cases ](#tests)
- [Running Tests](#how-to-run)
- [Allure Report](#allure-report)
- [Report Artefacts](#test-artefacts)
- [Integration with Allure TestOps](#allure-test-ops)
- [Integration with Jira](#jira)
- [Allure Notifications](#telegram-notification)


### <a name="tech-and-instruments"></a>Technologies and Tools

<p>

[<img width="6%" title="Java" src="media/svg/java.svg">](https://www.java.com/)
[<img width="6%" title="IntelliJ IDEA" src="media/svg/idea.svg">](https://www.jetbrains.com/idea/)
[<img width="7%" title="Gradle" src="media/svg/gradle.svg">](https://gradle.org/)
[<img width="6%" title="JUnit5" src="media/svg/junit5.svg">](https://junit.org/junit5/)
[<img width="6%" title="Selenide" src="media/svg/selenide.svg">](https://ru.selenide.org/)
[<img width="5.5%" title="Selenide" src="media/svg/restassured.png">](https://rest-assured.io/)
[<img width="6%" title="GitHub" src="media/svg/github.svg">](https://github.com/)
[<img width="5.5%" title="Jenkins" src="media/svg/jenkins.svg">](https://www.jenkins.io/)
[<img width="6%" title="Selenoid" src="media/svg/selenoid.svg">](https://aerokube.com/selenoid/)
[<img width="6%" title="AllureReport" src="media/svg/allure.svg">](https://allurereport.org/)
[<img width="5%" title="Allure TestOps" src="media/svg/alluretestops.svg">](https://qameta.io/)
[<img width="6%" title="Jira" src="media/svg/jira.svg">](https://www.atlassian.com/software/jira/)

</p>

`IntelliJ IDEA` for code writing and as a `Git` tool\
`Gradle` for build automation\
`JUnit5` for test execution\
`Selenide` for accelerated development based on `Selenium WebDriver`\
`REST Assured` for API testing\
`GitHub` for code storage\
`Jenkins` for remote test execution\
`Selenoid` for running browsers in `Docker` containers\
`Allure Report` for visualizing test results\
`Allure TestOps` for test management\
`Jira` for task management\
`Telegram` for test result notifications

### <a name="tests"></a>Test Cases

Login tests
1. Authenticate successfully with valid credentials
2. Successful user sign-out
3. Attempt login with an invalid password for a valid username

Objects list tests
1. Navigate to 'Objects' page from Main menu
2. Filter objects by level using 'Level' dropdown
2. Search by existing address using the upper 'Main Search' field
3. Search by existing address using the 'Sidebar Filter'
4. Search by a non-existing address using the upper 'Main Search' field

Create new object tests
1. Open 'New object' form from Objects page
2. Create a new object with all required fields properly filled
3. Create a new object with incomplete required fields

[↑ to contents](#contents)

----

### <a name="how-to-run"></a>Running Tests

Launch parameters are stored in .properties files.  
To execute tests, you can use the standard Gradle task for running tests or one of the custom tasks - 'regress' or 'smoke' to run specific test groups.

For running locally:

```commandline
 gradle clean regress -Denv=local
```

For remote browser execution in Selenoid:

```commandline
 gradle clean smoke -Denv=remote
```

From Jenkins:

A task has been configured to run autotests with parameters in [Jenkins](https://jenkins.autotests.cloud/job/021-azovceva-bas-demo-project/).
<p>
<img width="88%" title="Launch with Jenkins" src="media/screens/parametrized_jenkins_job.png">
</p>

Once the job is complete, you can get a summary of the test run and access the Allure report.
<p>
<img width="88%" title="Jenkins job results" src="media/screens/jenkins-job.png">
</p>

[↑ to contents](#contents)

----

### <a name="allure-report"></a>Allure Report

After the tests have passed, [Allure Report](https://jenkins.autotests.cloud/job/021-azovceva-bas-demo-project/allure/) is generated.
Each test is presented in the report as a series of steps with readable names.

<p>
<img width="88%" title="Allure report test steps" src="media/screens/allure_report_with_steps.png">
</p>

[↑ to contents](#contents)

----

### <a name="test-artefacts"></a>Report Artefacts
Detailed information, including snapshots, screenshots, and screen recordings for analyzing failed tests, is saved in the Report.

<p>
<img width="88%" title="Allure report artefacts" src="media/screens/allure_report_with_screenshots.png">
</p>

Recording a video of test execution can help to identify any issues or errors that occur during the test run.

<p>
<img width="88%" title="Test execution video" src="media/screens/test_video.gif">
</p>

[↑ to contents](#contents)

----

### <a name="allure-test-ops"></a>Integration with Allure TestOps
The integration between Jenkins and Allure works in both directions. Test results are collected in real-time from the build server during the execution of the build job. Additionally, tests can be initiated directly from the Allure interface. Manual and automated checks are combined into one test suite.

<p>
<img width="88%" title="Allure TestOps integration" src="media/screens/allure_testops_suite.png">
</p>

[↑ to contents](#contents)

----

### <a name="jira"></a>Integration with Jira
The Jira ticket is linked with tests from Allure TestOps.

<p>
<img width="88%" title="Allure TestOps integration" src="media/screens/jira_integration.png">
</p>

[↑ to contents](#contents)

----

### <a name="telegram-notification"></a>Allure Notifications 
Using the Allure notifications library, automatic notifications about the test results are sent to Telegram (also works with Slack, Skype, Email, Mattermost, Discord, Loop).

<p>
<img width="30%" title="Telegram notifications" src="media/screens/telegram_report.png">
</p>

[↑ to contents](#contents)

----
