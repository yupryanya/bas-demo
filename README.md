

### <a name="Содержание"></a>Содержание

- [О системе](#about-system)
- [Использованные технологии и инструменты](#tech-and-instruments)
- [Реализованные проверки](#tests)
- [Способы запуска автотестов](#how-to-run)
- [Allure-отчет о результатах прохождения автотестов](#allure-report)
- [Тестовые артефакты](#test-artefacts)
- [Интеграция с системой тест-менеджмента Allure TestOps](#allure-test-ops)
- [Интеграция с Jira](#jira)
- [Уведомления о похождении тестов в мессенджере](#телеграм-нотификация)

### <a name="about-system"></a>О системе

### <a name="tech-and-instruments"></a>Использованные технологии и инструменты

<p>
<img width="6%" title="Java" src="media/svg/java.svg">
<img width="6%" title="IntelliJ IDEA" src="media/svg/idea.svg">
<img width="7%" title="Gradle" src="media/svg/gradle.svg">
<img width="6%" title="JUnit5" src="media/svg/junit5.svg">
<img width="6%" title="Selenide" src="media/svg/selenide.svg">
<img width="5.5%" title="Selenide" src="media/svg/restassured.png">
<img width="6%" title="GitHub" src="media/svg/github.svg">
<img width="5.5%" title="Jenkins" src="media/svg/jenkins.svg">
<img width="6%" title="Selenoid" src="media/svg/selenoid.svg">
<img width="6%" title="AllureReport" src="media/svg/allure.svg">
<img width="5%" title="Allure TestOps" src="media/svg/alluretestops.svg">
<img width="6%" title="Jira" src="media/svg/jira.svg">
</p>

`Intelij IDEA` для написания кода и работы с `Git`\
`Gradle` для автоматизации сборки\
`JUnit5` для выполнения тестов\
`Selenide` для ускорения разработки на базе `Selenium WebDriver`\
`REST Assured` для тестирования API\
`GitHub` для хранения кода\
`Jenkins` для запуска тестов удаленно\
`Selenoid` для запуска браузера в `Docker` контейнерах\
`Allure Report` для визуализации результатов тестирования\
`Allure TestOps` для управления тестированием\
`Jira` для таск менеджмента\
`Telegram` для уведомлений о результатах тестирования

### <a name="tests"></a>Реализованные проверки

### <a name="how-to-run"></a>Способы запуска автотестов

### <a name="allure-report"></a>Allure-отчет о результатах прохождения автотестов
После прохождения тестов, получаем графическое представление результатов. 
Каждый тест реализован как последовательность лямбда степов и отображается в отчете в виде понятных шагов.

### <a name = ""></a>Тестовые артефакты
В Allure-отчете собрана подробная информация о прохождении тестов, включая снапшоты, скриншоты и записи экрана 

### <a name = ""></a>Интеграция с системой тест-менеджмента Allure TestOps
Ручные и автоматизированные проверки объединены в один тест план. 

### <a name = ""></a>Интеграция с Jira
В тикет Jira добавлены нужные тесты.

### <a name ="telegram-notifications"></a>Уведомления о прохождении тестов в мессенджере  
С помощью библиотеки Allure notifications отправлено автоматическое оповещение о результатах прохождения автотестов в нужный мессенджер (Telegram, Slack, Skype, Email, Mattermost, Discord, Loop).


