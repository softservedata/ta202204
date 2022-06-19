package com.softserve.homework14;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import com.softserve.edu.opencart.tests.TestRunner;
import org.testng.annotations.Test;

public class FillInRegisterPageTest extends TestRunner {
    IUser user = UserRepository.getNewUser();

    @Test
    public void checkRegisteredUser() {
        loadApplication()
                .gotoRegisterPage()
                .fillInRegisterPage(user);
    // add asserts , success reg page, unsuccess reg page
        // final String EXPECTED_REGISTRATION_MESSAGE = "Your Account Has Been Created!";
        //
    }
}
