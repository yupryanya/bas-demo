package ru.comfortsoft.bas.tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.comfortsoft.bas.pages.NewObjectPage;
import ru.comfortsoft.bas.pages.ObjectViewPage;
import ru.comfortsoft.bas.pages.ObjectsListPage;
import ru.comfortsoft.bas.pages.SidebarFilter;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Objects page tests")
@Tag("regression")
public class ObjectsListPageTests extends TestBaseRemote {
    ObjectsListPage objectsListPage = new ObjectsListPage();
    NewObjectPage newObjectPage = new NewObjectPage();
    ObjectViewPage objectViewPage = new ObjectViewPage();
    SidebarFilter sidebarFilter = new SidebarFilter();

    @Test
    @DisplayName("Open 'New object' form from Objects screen")
    @Tag("smoke")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulNewObjectFormOpen() {
        step("Open Objects page", () ->
                objectsListPage.openPage()
        );
        step("Open 'New Object' form", () ->
                objectsListPage.clickNewObjectButton()
        );
        step("Check 'New Object' form is displayed", () ->
                newObjectPage.newObjectFormIsDisplayed()
        );
    }

    @ParameterizedTest
    @DisplayName("Create a new object with all required fields filled")
    @Tag("smoke")
    @CsvSource( value = {
            "Школа     : г. Москва                  : Здание : Войковский",
            "Жилой дом : г. Москва, улица Арбат, 23 : Здание : Арбат"
    },
            delimiter = ':'
    )
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulNewObjectCreation (String name, String address, String type, String parent) {
        step("Open 'New Object' page", () ->
                newObjectPage.openPage()
        );
        step("Fill all required fields", () ->
                newObjectPage.setObjectName(name)
                    .setAddress(address)
                    .setObjectType(type)
                    .setParentCode(parent)
                    .clickSubmitButton()
        );
        step("Check the object with same data is displayed", () ->
                objectViewPage.objectWithRequiredFieldsisDisplayed(address, type, parent)
        );
    }

    @ParameterizedTest
    @DisplayName("Search by existing address using 'Main Search' field")
    @ValueSource(strings = {
            "пос. Птичное, СПК Птичное, дом на уч. 7",
            "Даниловский"
    })
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingTheMainSearchInput(String address) {
        step("Open 'Objects' page", () ->
                objectsListPage.openPage()
        );
        step("Find element with the 'Main search' field", () ->
                objectsListPage.fillTheMainSearchField(address)
        );
        step("Cick the first element in objects list", () ->
                objectsListPage.clickFirstElementFromList()
        );
        step("Check the object with required address is displayed", () ->
                objectViewPage.objectWithRequiredFieldsisDisplayed(address)
        );
    }

    @ParameterizedTest
    @DisplayName("Search by existing address using 'Sidebar Filter'")
    @ValueSource(strings = {
            "Щукинская улица, дом 42",
            "Ленинский"
    })
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingSidebarFilter(String address) {
        step("Open 'Objects' page", () ->
                objectsListPage.openPage()
        );
        step("Open 'Sidebar Filter'", () ->
                objectsListPage.openSidebarFilter()
        );
        step("Fill the address field with existing address", () ->
                sidebarFilter.setAddress(address)
                        .clickSubmitButton()
        );
        step("Cick the first element in objects list", () ->
                objectsListPage.clickFirstElementFromList()
        );
        step("Check the object with required address is displayed", () ->
                objectViewPage.objectWithRequiredFieldsisDisplayed(address)
        );
    }

    @ParameterizedTest
    @DisplayName("Filter objects using 'Level Filter' field")
    @ValueSource(strings = {
            "Город",
            "Округ"
    })
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulFilteringByLevelUsingUpperLevelFilter(String level) {
        step("Open 'Objects' page", () ->
                objectsListPage.openPage()
        );
        step("Set 'Level Filter' value", () ->
                objectsListPage.setLevelFilterValue(level)
        );
        step("Cick the first element in objects list", () ->
                objectsListPage.clickFirstElementFromList()
        );
        step("Check the objects with required level are displayed", () ->
                objectViewPage.objectWithRequiredFieldsisDisplayed(level)
        );
    }
}