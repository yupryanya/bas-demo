package ru.comfortsoft.bas.tests.objects;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.comfortsoft.bas.data.MenuItems;
import ru.comfortsoft.bas.data.ObjectLevel;
import ru.comfortsoft.bas.helpers.WithLogin;
import ru.comfortsoft.bas.models.objects.CreateObjectRequestModel;
import ru.comfortsoft.bas.tests.TestBase;
import ru.comfortsoft.bas.utilities.RandomData;

@DisplayName("Objects list tests")
public class ObjectsListTests extends TestBase {
    RandomData randomValues = new RandomData();
    private final CreateObjectRequestModel object = CreateObjectRequestModel.builder()
            .objType(randomValues.getRandomObjectType().getObjectTypeCode())
            .address(randomValues.generateRandomAddress())
            .name("Наименование объекта")
            .parentCode(randomValues.getRandomDistrict().getCode())
            .build();

    @WithLogin
    @Test
    @DisplayName("Navigate to 'Objects' page from Main menu")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulOpenObjectsPageFromMainMenuTest() {
        mainPage.openPage();
        header.navigateTo(MenuItems.OBJECTS);
        objectsListPage.checkObjectsListPageIsDisplayed();
    }

    @WithLogin
    @ParameterizedTest
    @DisplayName("Filter objects by level using 'Level' dropdown")
    @Tag("regress")
    @EnumSource(ObjectLevel.class)
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulFilteringByLevelUsingUpperLevelFilterTest(ObjectLevel level) {
        objectsListPage.openPage();
        objectsListPage.setLevelFilterValue(level.getLevelName());
        objectsListPage.clickFirstElementInList();
        objectViewPage.objectWithRequiredFieldsisDisplayed(level.getLevelName());
    }

    @WithLogin
    @Test
    @DisplayName("Search by existing address using 'Sidebar Filter'")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingSidebarFilterTest() {
        String objectCode = objectsApi.createObject(object).getCode();

        objectsListPage.openPage();
        objectsListPage.expandSidebarFilter();
        sidebarFilter.setAddress(object.getAddress());
        sidebarFilter.clickSubmitButton();
        objectsListPage.clickFirstElementInList();
        objectViewPage.objectWithRequiredFieldsisDisplayed(object.getAddress());

        objectsApi.deleteObjectByCode(objectCode);
    }

    @WithLogin
    @Test
    @DisplayName("Search by existing address using upper 'Main Search' field")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingTheMainSearchInputTest() {
        String objectCode = objectsApi.createObject(object).getCode();

        objectsListPage.openPage();
        objectsListPage.fillTheMainSearchField(object.getAddress());
        objectsListPage.clickFirstElementInList();
        objectViewPage.objectWithRequiredFieldsisDisplayed(object.getAddress());

        objectsApi.deleteObjectByCode(objectCode);
    }

    @WithLogin
    @Test
    @DisplayName("Search by non existing address using upper 'Main Search' field")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void unsuccessfulSearchByAddressUsingTheMainSearchTest() {
        objectsListPage.openPage();
        objectsListPage.fillTheMainSearchField("some address");
        objectsListPage.noObjectsFoundMessageShouldBeDisplayed();
    }
}