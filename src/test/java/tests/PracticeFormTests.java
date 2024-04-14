package tests;

import data.FormKeys;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static java.lang.String.format;

public class PracticeFormTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    String firstName = "Alexey",
            lastName = "Kuslin",
            fullName = format("%s %s", firstName, lastName),
            userEmail = "Alexey@mail.ru",
            userGender = "Male",
            userNumber = "0123456789",
            birthDay = "12",
            birthMonth = "January",
            birthYear = "2000",
            birthDate = format("%s %s,%s", birthDay, birthMonth, birthYear),
            userSubject = "Maths",
            userHobby = "Sports",
            userPicture = "img.jpg",
            userAddress = "NCR Delhi 5",
            state = "NCR",
            city = "Delhi",
            stateAndCity = format("%s %s", state, city),
            emptyField = " ";

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubject(userSubject)
                .setHobby(userHobby)
                .uploadPicture(userPicture)
                .setAddress(userAddress)
                .setState(state)
                .setCity(city)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.Name.getKey(), fullName)
                .checkResult(FormKeys.Email.getKey(), userEmail)
                .checkResult(FormKeys.Gender.getKey(), userGender)
                .checkResult(FormKeys.Mobile.getKey(), userNumber)
                .checkResult(FormKeys.Birth.getKey(), birthDate)
                .checkResult(FormKeys.Subject.getKey(), userSubject)
                .checkResult(FormKeys.Hobby.getKey(), userHobby)
                .checkResult(FormKeys.Picture.getKey(), userPicture)
                .checkResult(FormKeys.Address.getKey(), userAddress)
                .checkResult(FormKeys.StateAndCity.getKey(), stateAndCity);
    }

    @Test
    void minSuccessfulFillFormTest() {
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender(userGender)
                .setUserNumber(userNumber)
                .pressSubmit();

        registrationPage.checkResult(FormKeys.Name.getKey(), fullName)
                .checkResult(FormKeys.Email.getKey(), emptyField)
                .checkResult(FormKeys.Gender.getKey(), userGender)
                .checkResult(FormKeys.Mobile.getKey(), userNumber)
                .checkResult(FormKeys.Birth.getKey(), emptyField)
                .checkResult(FormKeys.Subject.getKey(), emptyField)
                .checkResult(FormKeys.Hobby.getKey(), emptyField)
                .checkResult(FormKeys.Picture.getKey(), emptyField)
                .checkResult(FormKeys.Address.getKey(), emptyField)
                .checkResult(FormKeys.StateAndCity.getKey(), emptyField);
    }

    @Test
    void validationFormTest() {
        registrationPage.openPage()
                .pressSubmit();

        registrationPage.checkGenderValidation("Male")
                .checkGenderValidation("Female")
                .checkGenderValidation("Other")
                .checkInputValidation("firstName")
                .checkInputValidation("lastName")
                .checkInputValidation("userNumber");

        registrationPage.checkFormNotDisplayed();
    }
}