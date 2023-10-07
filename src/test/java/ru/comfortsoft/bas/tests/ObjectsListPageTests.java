package ru.comfortsoft.bas.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comfortsoft.bas.pages.NewObjectPage;
import ru.comfortsoft.bas.pages.ObjectsListPage;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;


@DisplayName("Objects page tests")
@Tag("regression")
public class ObjectsListPageTests extends TestBaseLocal {
    @Test
    @Tag("smoke")
    @DisplayName("Create a new object with required filds filled")
    void successNewObjectCreation() {
        ObjectsListPage objectsListPage = new ObjectsListPage();
        NewObjectPage newObjectPage = new NewObjectPage();

        step("Open Objects page", () ->
                objectsListPage.openPage()
        );
        step("Open New Object form", () ->
                objectsListPage.openNewObjectForm()
        );
        step("Fill required fields", () -> {
                newObjectPage.setObjectType("Здание")
                            .setParentCode("Арбат")
                            .setObjectName("Школа")
                            .setAddress("г.Москва")
                            .submit();
        });
        String objectCode = newObjectPage.getGeneratedCode();

        sleep(2500);
    }

    @Test
    @Tag("smoke")
    @DisplayName("Search by address using main search input")
    void successfulSearchUsingTheMainSearchInput() {
        ObjectsListPage objectsListPage = new ObjectsListPage();

        step("Open Objects page", () ->
                objectsListPage.openPage()
        );
        step("Fill main search field", () ->
                objectsListPage.findWithMainSearch("Ленинский проспект")
        );
    }
}

