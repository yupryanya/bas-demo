package ru.comfortsoft.bas.tests.objects;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import ru.comfortsoft.bas.data.District;
import ru.comfortsoft.bas.data.ObjectType;
import ru.comfortsoft.bas.helpers.WithLogin;
import ru.comfortsoft.bas.tests.TestBase;
import ru.comfortsoft.bas.utilities.RandomValues;

@DisplayName("Create object tests")
public class CreateObjectTests extends TestBase {
    @WithLogin
    @Test
    @DisplayName("Open 'New object' form from Objects page")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulNewObjectFormOpenTest() {
        objectsListPage.openPage();
        objectsListPage.clickNewObjectButton();
        createObjectPage.checkTheNewObjectFormIsVisible();
    }

    @WithLogin
    @Test
    @DisplayName("Create a new object with all required fields filled")
    @Tags({@Tag("smoke"), @Tag("regress")})
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void successfulNewObjectCreationTest() {
        RandomValues randomValues = new RandomValues();

        District district = randomValues.getRandomDistrict();
        ObjectType objectType = randomValues.getRandomObjectType();
        String objectAddress = randomValues.generateRandomAddress();
        String objectName = "Наименование";

        createObjectPage.openPage();
        createObjectPage.setObjectName(objectName);
        createObjectPage.setAddress(objectAddress);
        createObjectPage.setObjectType(objectType.getObjectTypeName());
        createObjectPage.setParentCode(district.getDistrictName());
        String objectCode = createObjectPage.getObjectCode();
        createObjectPage.clickSubmitButton();
        objectViewPage.objectWithRequiredFieldsisDisplayed(objectAddress, district.getDistrictName(), objectType.getObjectTypeName());

        objectsApi.deleteObjectByCode(objectCode);
    }

    @WithLogin
    @Test
    @DisplayName("Create a new object with incomplete required fields")
    @Tag("regress")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Yulia Azovtseva")
    void newObjectCreationWithIncompleteRequiredFieldsTest() {
        RandomValues randomValues = new RandomValues();

        String objectAddress = randomValues.generateRandomAddress();
        String objectName = "Наименование";

        createObjectPage.openPage();
        createObjectPage.setObjectName(objectName);
        createObjectPage.setAddress(objectAddress);
        createObjectPage.clickSubmitButton();

        createObjectPage.requiredFieldErrorMessageShouldBeDisplayed();
    }
}
