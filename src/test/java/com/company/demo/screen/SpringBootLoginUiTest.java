package com.company.demo.screen;

import com.codeborne.selenide.Selenide;
import com.company.demo.JmixSampleUiTestApplication;
import com.company.demo.extension.ChromeExtension;
import io.jmix.masquerade.component.Untyped;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import static io.jmix.masquerade.Components.wire;
import static io.jmix.masquerade.Conditions.EDITABLE;
import static io.jmix.masquerade.Conditions.ENABLED;
import static io.jmix.masquerade.Conditions.VISIBLE;
import static io.jmix.masquerade.Conditions.caption;
import static io.jmix.masquerade.Selectors.$j;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(ChromeExtension.class)
@SpringBootTest(classes = JmixSampleUiTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SpringBootLoginUiTest {

    @Test
    public void login() {
        Selenide.open("/");
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
