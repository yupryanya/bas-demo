package ru.comfortsoft.bas.utilities;

import com.github.javafaker.Faker;
import ru.comfortsoft.bas.data.Districts;
import ru.comfortsoft.bas.data.ObjectTypes;

import java.util.Locale;
import java.util.Random;

public class RandomData {
    private final Faker faker = new Faker(new Locale("ru-RU"));
    private final Random random = new Random();

    public String generateRandomAddress() {
        return faker.address().streetAddress();
    }

    public Districts getRandomDistrict() {
        Districts[] values = Districts.values();
        return values[random.nextInt(values.length)];
    }

    public ObjectTypes getRandomObjectType() {
        ObjectTypes[] objectTypes = ObjectTypes.values();
        return objectTypes[random.nextInt(objectTypes.length)];
    }

    public String generateRandomObjectCode() {
        int randomCode = new Random().nextInt(900000) + 100000;
        return "OBT" + String.format("%06d", randomCode);
    }
}
