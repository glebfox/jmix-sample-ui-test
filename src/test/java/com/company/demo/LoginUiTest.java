package com.company.demo;

import com.company.demo.screen.LoginScreen;
import io.jmix.masquerade.component.Untyped;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static io.jmix.masquerade.Components.wire;
import static io.jmix.masquerade.Conditions.*;
import static io.jmix.masquerade.Selectors.$j;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LoginUiTest {

    // The application must be running on the url = http://localhost:8080
    // User can change the base url using the 'selenide.baseUrl' variable in build.gradle file
    @Test
    public void login() {
        // open URL of an application
        open("/");

        // obtain UI object
        LoginScreen loginScreen = $j(LoginScreen.class);

        assertNotNull(loginScreen.getUsernameField());
        assertNotNull(loginScreen.getPasswordField());

        // fluent asserts
        loginScreen.getUsernameField()
                .shouldBe(EDITABLE)
                .shouldBe(ENABLED);

        // setting values
        loginScreen.getUsernameField().setValue("admin");
        loginScreen.getPasswordField().setValue("admin");

        // fluent asserts
        loginScreen.getWelcomeLabelTest()
                .shouldBe(VISIBLE);

        // fluent asserts
        loginScreen.getLoginButton()
                .shouldBe(VISIBLE)
                .shouldBe(ENABLED)
                .shouldHave(caption("Submit"));

        Untyped loginForm = wire(Untyped.class, "loginForm");
        loginForm.shouldBe(VISIBLE);

        loginScreen.getLoginButton().click();

        // close the browser tab
        closeWindow();
    }
}
