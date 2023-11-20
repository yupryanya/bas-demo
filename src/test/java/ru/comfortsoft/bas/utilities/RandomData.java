package ru.comfortsoft.bas.utilities;

import com.github.javafaker.Faker;
import ru.comfortsoft.bas.data.District;
import ru.comfortsoft.bas.data.ObjectType;

import java.util.Locale;
import java.util.Random;

public class RandomData {
    private Locale locale = new Locale("ru-RU");
    private Faker faker = new Faker(locale);
    private Random random = new Random();

    public String generateRandomAddress() {
        return faker.address().streetAddress();
    }

    public District getRandomDistrict() {
        District[] values = District.values();
        return values[random.nextInt(values.length)];
    }

    public ObjectType getRandomObjectType() {
        ObjectType[] objectTypes = ObjectType.values();
        return objectTypes[random.nextInt(objectTypes.length)];
    }
}
