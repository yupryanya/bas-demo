

### <a name="Содержание"></a>Содержание

- [О системе](#about-system)
- [Использованные технологии и инструменты](#tech-and-instruments)
- [Реализованные проверки](#tests)
- [Удаленный запуск в CI](#how-to-run)
- [Allure-отчет о результатах прохождения автотестов](#allure-report)
- [Тестовые артефакты](#test-artefacts)
- [Интеграция с системой тест-менеджмента Allure TestOps](#allure-test-ops)
- [Интеграция с Jira](#jira)
- [Уведомление о прохождении тестов в мессенджере](#telegram-notification)

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

Реализованы проверки для страницы "Объекты"
1. Вызов формы создания нового объекта из окна "Объекты"
2. Поиск объекта по существующему адресу с помощью основного поля поиска
3. Поиск объекта по существующему адресу с помощью бокового фильтра"
4. Фильтрация списка объектов с помощью фильтра по уровню
5. Создание нового объекта с помощью формы создания объекта с заполненными обязательными полями

### <a name="how-to-run"></a>Удаленный запуск в CI

Настроена задача для запуска автотестов с параметрами в Jenkins.
<p>
<img width="88%" title="Launch with Jenkins" src="media/screens/parametrized_jenkins_job.png">
</p>

Результат сборки.
<p>
<img width="88%" title="Jenkins job results" src="media/screens/jenkins-job.png">
</p>

### <a name="allure-report"></a>Allure-отчет о результатах прохождения автотестов
После прохождения тестов, получаем графическое представление результатов. 
Каждый тест отображается в отчете в виде понятных шагов.
<p>
<img width="88%" title="Allure report test steps" src="media/screens/allure_report_with_steps.png">
</p>

### <a name="test-artefacts"></a>Тестовые артефакты
В Allure-отчете сохраняется подробная информация, включая снапшоты, скриншоты и записи экрана для разбора упавших тестов.
<p>
<img width="88%" title="Allure report artefacts" src="media/screens/allure_report_with_screenshots.png">
</p>

### <a name="allure-test-ops"></a>Интеграция с системой тест-менеджмента Allure TestOps
Ручные и автоматизированные проверки объединены в один тест сьют. 
<p>
<img width="88%" title="Allure TestOps integration" src="media/screens/allure_testops_suite.png">
</p>

### <a name="jira"></a>Интеграция с Jira
В тикет Jira добавлены тесты из Allure TestOps.
<p>
<img width="88%" title="Allure TestOps integration" src="media/screens/jira_integration.png">
</p>

### <a name="telegram-notification"></a>Уведомления о прохождении тестов в мессенджере  
С помощью библиотеки Allure notifications отправлено автоматическое оповещение о результатах прохождения автотестов в Telegram (Slack, Skype, Email, Mattermost, Discord, Loop).
<p>
<img width="30%" title="Telegram notifications" src="media/screens/telegram_report.png">
</p>

