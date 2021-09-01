package com.company.demo;

import com.company.demo.screen.LoginScreen;
import com.company.demo.screen.MainScreen;
import com.company.demo.screen.UserBrowse;
import com.company.demo.screen.UserEdit;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static io.jmix.masquerade.Selectors.$j;

public class UserUiTest {

    @Test
    void createSimpleUser() {
        open("/");

        // login to the application
        $j(LoginScreen.class).getLoginButton().click();

        // open application menu item
        $j(MainScreen.class).openUserBrowse();

        // run the user creation method from the UserBrowse class
        $j(UserBrowse.class).createUser();

        // fill required fields in the user editor screen
        $j(UserEdit.class).fillAndSaveUser("demo");

        // check that the newly created user appears in the table
        $j(UserBrowse.class).checkRecordIsDisplayed("demo");

        // close the browser tab
        closeWindow();
    }
}
