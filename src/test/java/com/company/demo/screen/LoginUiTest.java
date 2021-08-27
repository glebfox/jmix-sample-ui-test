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

    @Test
    public void login() {
//        open("http://localhost:8080");
        open("http://host.docker.internal:8080");

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

        Untyped loginFormLayout = wire(Untyped.class, "loginFormLayout");
        loginFormLayout.shouldBe(VISIBLE);

        loginScreen.getLoginButton().click();
    }
}
