package com.company.demo.screen;

import com.company.demo.extension.ChromeExtension;
import io.jmix.masquerade.component.Untyped;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static io.jmix.masquerade.Components.wire;
import static io.jmix.masquerade.Conditions.*;
import static io.jmix.masquerade.Selectors.$j;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ChromeExtension.class)
public class LoginUiTest {

    // The application must be running on the url = http://localhost:8080
    // User can change the base url using the 'selenide.baseUrl' variable in build.gradle file
    @Test
    public void login() {
        open("/");
        LoginScreen loginScreen = $j(LoginScreen.class);

        assertNotNull(loginScreen.getUsernameField());
        assertNotNull(loginScreen.getPasswordField());

        loginScreen.getUsernameField()
                .shouldBe(EDITABLE)
                .shouldBe(ENABLED);

        loginScreen.getUsernameField().setValue("masquerade");
        loginScreen.getPasswordField().setValue("rulezzz");

        loginScreen.getWelcomeLabelTest()
                .shouldBe(VISIBLE);

        loginScreen.getLoginButton()
                .shouldBe(VISIBLE)
                .shouldBe(ENABLED)
                .shouldHave(caption("Submit"));

        Untyped loginForm = wire(Untyped.class, "loginForm");
        loginForm.shouldBe(VISIBLE);

        loginScreen.getLoginButton().click();
    }
}
