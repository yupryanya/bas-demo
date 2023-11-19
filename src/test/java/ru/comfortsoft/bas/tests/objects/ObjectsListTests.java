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
import ru.comfortsoft.bas.utilities.RandomValues;

@DisplayName("Objects list tests")
public class ObjectsListTests extends TestBase {
    RandomValues randomValues = new RandomValues();
    private final CreateObjectRequestModel object = CreateObjectRequestModel.builder()
            .objType(randomValues.getRandomObjectType().getObjectTypeCode())
            .address(randomValues.generateRandomAddress())
            .name("Наименование объекта")
            .parentCode(randomValues.getRandomDistrict().getCode())
            .build();

    @WithLogin
    @Test
    @DisplayName("Open 'Objects' page from Main menu")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulOpenObjectsPageFromMenuTest() {
        mainPage.openPage();
        header.navigateTo(MenuItems.OBJECTS);
        objectsListPage.checkObjectsListPageIsDisplayed();
    }

    @WithLogin
    @ParameterizedTest
    @DisplayName("Filter objects using 'Level Filter' field")
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
    @DisplayName("Search by existing address using 'Sidebar Filter'")
    @Tag("regress")
    @Severity(SeverityLevel.NORMAL)
    @Owner("Yulia Azovtseva")
    void successfulSearchByAddressUsingSidebarFilterTest() {
        String objectCode = objectsApi.createObject(object).getCode();

        objectsListPage.openPage();
        objectsListPage.openSidebarFilter();
        sidebarFilter.setAddress(object.getAddress());
        sidebarFilter.clickSubmitButton();
        objectsListPage.clickFirstElementInList();
        objectViewPage.objectWithRequiredFieldsisDisplayed(object.getAddress());

        objectsApi.deleteObjectByCode(objectCode);
    }
}