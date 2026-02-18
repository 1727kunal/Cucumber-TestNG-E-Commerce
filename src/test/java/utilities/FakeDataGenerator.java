package utilities;

import com.github.javafaker.Faker;

public class FakeDataGenerator {
	static Faker faker = new Faker();

	public static String generateFirstName() {
		return faker.name().firstName();
	}

	public static String generateLastName() {
		return faker.name().lastName();
	}

	public static String generateEmail() {
		return faker.internet().safeEmailAddress();
	}

	public static String generateTelephone() {
		return faker.phoneNumber().cellPhone();
	}

	public static String generatePassword() {
		return faker.internet().password(8, 12, true, true, true);
	}
}
