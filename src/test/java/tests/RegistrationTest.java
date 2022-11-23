package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class RegistrationTest extends TestBase {

    @Test
    @DisplayName("Регистрация пользователя с валидными данными")
    public void successfulRegistration() {

        Faker faker = new Faker();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
        String[] birthday = dateFormat.format(faker.date().birthday()).split(" ");

        String firstName = faker.name().firstName(),
                lastName = faker.name().lastName(),
                userEmail = faker.internet().emailAddress(),
                userGender = "Male",
                userPhone = faker.phoneNumber().subscriberNumber(10),
                userBirthDay = birthday[0],
                userBirthMonth = birthday[1],
                userBirthYear = birthday[2],
                subjects = "Maths",
                hobbies = "Music",
                imagePath = "profile.jpg",
                currentAddress = faker.address().streetAddress(),
                userState = "NCR",
                userCity = "Delhi";

        new RegistrationPage().openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(userGender)
                .setPhone(userPhone)
                .setBirthDay(userBirthDay, userBirthMonth, userBirthYear)
                .setSubject(subjects)
                .setHobbie(hobbies)
                .uploadPicture(imagePath)
                .setCurrentAddress(currentAddress)
                .selectState(userState)
                .selectCity(userCity)
                .submitForm()
                .verifyResultModule()
                .verifyResultValue("Student Name", firstName + " " + lastName)
                .verifyResultValue("Student Email", userEmail)
                .verifyResultValue("Gender", userGender)
                .verifyResultValue("Mobile", userPhone)
                .verifyResultValue("Date of Birth", userBirthDay + " " + userBirthMonth + "," + userBirthYear)
                .verifyResultValue("Subjects", subjects)
                .verifyResultValue("Hobbies", hobbies)
                .verifyResultValue("Picture", imagePath)
                .verifyResultValue("Address", currentAddress)
                .verifyResultValue("State and City", userState + " " + userCity);
    }
}