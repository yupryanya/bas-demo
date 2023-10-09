package ru.comfortsoft.bas.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comfortsoft.bas.pages.NewObjectPage;
import ru.comfortsoft.bas.pages.ObjectViewPage;
import ru.comfortsoft.bas.pages.ObjectsListPage;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Objects page tests")
@Tag("regression")
public class ObjectsListPageTests extends TestBaseRemote {
    ObjectsListPage objectsListPage = new ObjectsListPage();
    NewObjectPage newObjectPage = new NewObjectPage();
    ObjectViewPage newObjectView = new ObjectViewPage();

    @Test
    @Tag("smoke")
    @DisplayName("Create a new object with all required filds filled")
    void successNewObjectCreation() {
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
                            .setAddress("г. Москва")
                            .submit();
        });
        step("Check the object with required code exists", () -> {
            String objectCode = newObjectPage.getGeneratedCode();
            assertTrue(newObjectView.objectWithRequiredCodeExists(objectCode));
        });
    }

    @Test
    @DisplayName("Search by address using main search field")
    void successfulSearchUsingTheMainSearchInput() {
        step("Open Objects page", () ->
                objectsListPage.openPage()
        );
        step("Fill main search field", () ->
                objectsListPage.findWithMainSearch("город Москва, п. Первомайское, у пос. Птичное, СПК Птичное, дом на уч. 7")
        );
        step("Check the object with required address exists", () -> {
            assertTrue(objectsListPage.objectWithRequiredAddressIsDisplayed());
        });
    }
}

