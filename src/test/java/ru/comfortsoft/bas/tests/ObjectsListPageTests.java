package ru.comfortsoft.bas.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ru.comfortsoft.bas.pages.NewObjectPage;
import ru.comfortsoft.bas.pages.ObjectViewPage;
import ru.comfortsoft.bas.pages.ObjectsListPage;
import ru.comfortsoft.bas.pages.SidebarFilter;

import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Objects page tests")
@Tag("regression")
public class ObjectsListPageTests extends TestBaseLocal {
    ObjectsListPage objectsListPage = new ObjectsListPage();
    NewObjectPage newObjectPage = new NewObjectPage();
    ObjectViewPage newObjectView = new ObjectViewPage();
    SidebarFilter sidebarFilter = new SidebarFilter();

    @Test
    @Tag("smoke")
    @DisplayName("Open 'New object' form from Objects page")
    void successfulNewObjectFormOpen() {
        step("Open Objects page", () ->
                objectsListPage.openPage()
        );
        step("Open 'New Object' form", () ->
                objectsListPage.openNewObjectForm()
        );
        step("Check 'New Object' form is displayed", () -> {
                assertTrue(newObjectView.newObjectFormIsDisplayed());
        });
    }


    @Test
    @Tag("smoke")
    @DisplayName("Create a new object with all required fields filled")
    void successfulNewObjectCreation () {
        step("Open 'New Object' page", () ->
                newObjectPage.openPage()
        );
        step("Fill all required fields", () -> {
                newObjectPage.setObjectName("Школа")
                    .setAddress("г. Москва")
                    .setObjectType("Здание")
                    .setParentCode("Арбат")
                    .submit();
        });
        step("Check the object with generated code exists", () -> {
                String objectCode = newObjectPage.getGeneratedCode();
                assertTrue(newObjectView.objectWithRequiredCodeExists(objectCode));
        });
    }

    @Test
    @DisplayName("Search by existing address using 'Main Search' field")
    void successfulSearchByAddressUsingTheMainSearchInput() {
        step("Open 'Objects' page", () ->
                objectsListPage.openPage()
        );
        step("Fill 'Main Search' field with existing address", () ->
                objectsListPage.findWithMainSearch("п. Первомайское, у пос. Птичное, СПК Птичное, дом на уч. 7")
        );
        step("Check the object with required address is diplayed", () -> {
                assertTrue(objectsListPage.objectWithRequiredAddressIsDisplayed());
        });
    }

    @Test
    @DisplayName("Search by existing address using 'Sidebar Filter'")
    void successfulSearchByAddressUsingSidebarFilter() {
        step("Open 'Objects' page", () ->
                objectsListPage.openPage()
        );
        step("Open 'Sidebar Filter'", () ->
                objectsListPage.openSidebarFilter()
        );
        step("Fill the address field with existing address", () ->
                sidebarFilter.findWithSidebarFilterByAddress("п. Первомайское, у пос. Птичное, СПК Птичное, дом на уч. 7")
        );
        step("Check the object with required address is displayed", () -> {
                assertTrue(objectsListPage.objectWithRequiredAddressIsDisplayed());
        });
    }

    @Test
    @DisplayName("Filter objects using 'Level Filter' field")
    void successfulFilteringByLevelUsingUpperLevelFilter() {
        step("Open 'Objects' page", () ->
                objectsListPage.openPage()
        );
        step("Set 'Level Filter' value", () ->
                objectsListPage.setLevelFilterValue("Город")
        );
        step("Check the objects with required level are displayed", () -> {
                assertTrue(objectsListPage.objectWithRequiredLevelIsDisplayed());
        });
    }
}

