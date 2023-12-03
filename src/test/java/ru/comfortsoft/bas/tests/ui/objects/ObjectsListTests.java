package ru.comfortsoft.bas.tests.ui.objects;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import ru.comfortsoft.bas.data.MenuItems;
import ru.comfortsoft.bas.data.ObjectLevels;
import ru.comfortsoft.bas.helpers.WithLogin;
import ru.comfortsoft.bas.models.objects.CreateObjectRequestModel;
import ru.comfortsoft.bas.models.objects.CreateObjectResponseModel;
import ru.comfortsoft.bas.tests.ui.BaseWeb;
import ru.comfortsoft.bas.utilities.RandomData;

@DisplayName("Objects list tests")
public class ObjectsListTests extends BaseWeb {
    private final RandomData randomValues = new RandomData();
    private final CreateObjectRequestModel randomDataObject = CreateObjectRequestModel.builder()
            .objType(randomValues.getRandomObjectType().getObjectTypeCode())
            .address(randomValues.generateRandomAddress())
            .name("Наименование объекта")
            .parentCode(randomValues.getRandomDistrict().getCode())
            .build();

    @Test
    @WithLogin
    @DisplayName("Navigate to 'Objects' page from Main menu")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulOpenObjectsPageFromMainMenuTest() {
        mainPage.openPage();
        header.navigateTo(MenuItems.OBJECTS);
        objectsListPage.objectsListPageIsDisplayed();
    }

    @ParameterizedTest
    @EnumSource(ObjectLevels.class)
    @WithLogin
    @DisplayName("Filter objects by level using 'Level' dropdown")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulFilteringByLevelUsingUpperLevelFilterTest(ObjectLevels level) {
        objectsListPage.openPage();
        objectsListPage.setLevelFilterValue(level.getLevelName());
        objectsListPage.clickFirstElementInList();
        objectViewPage.objectWithRequiredFieldsisDisplayed(level.getLevelName());
    }

    @Test
    @WithLogin
    @DisplayName("Search by existing address using the 'Sidebar Filter'")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingSidebarFilterTest() {
        String objectCode = objectsApi.createObject(randomDataObject).as(CreateObjectResponseModel.class).getCode();

        objectsListPage.openPage();
        objectsListPage.expandSidebarFilter();
        sidebarFilter.setAddress(randomDataObject.getAddress());
        sidebarFilter.clickSubmitButton();
        objectsListPage.valueIsDisplayedInObjectsList(randomDataObject.getAddress());

        objectsApi.deleteObject(objectCode);
    }

    @Test
    @WithLogin
    @DisplayName("Search by existing address using the upper 'Main Search' field")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingTheMainSearchInputTest() {
        String objectCode = objectsApi.createObject(randomDataObject).as(CreateObjectResponseModel.class).getCode();
        String address = randomDataObject.getAddress();

        objectsListPage.openPage();
        objectsListPage.fillTheMainSearchField(address);
        objectsListPage.valueIsDisplayedInObjectsList(address);

        objectsApi.deleteObject(objectCode);
    }

    @Test
    @WithLogin
    @DisplayName("Search by a non-existing address using the upper 'Main Search' field")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void unsuccessfulSearchByAddressUsingTheMainSearchTest() {
        objectsListPage.openPage();
        objectsListPage.fillTheMainSearchField("some address");
        objectsListPage.noObjectsFoundMessageIsDisplayed();
    }
}