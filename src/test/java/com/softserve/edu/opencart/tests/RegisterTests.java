package com.softserve.edu.opencart.tests;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.data.UserRepository;
import org.testng.annotations.Test;

public class RegisterTests extends TestRunnerFirst{
	
	IUser user = UserRepository.getNewUser();
	
	@Test
	public void checkRegisteredUser() {
		loadApplication()
				.gotoRegisterPage()
				.fillFields(user);
	}

}
