package com.company.demo.screen;

import io.jmix.masquerade.Wire;
import io.jmix.masquerade.base.Composite;
import io.jmix.masquerade.component.Button;
import io.jmix.masquerade.component.TextField;

public class UserEdit extends Composite<UserEdit> {

    @Wire
    private TextField usernameField;
    @Wire
    private TextField passwordField;
    @Wire
    private TextField confirmPasswordField;

    @Wire
    private Button commitAndCloseBtn;

    private String password = "qO4Hn6o";

    public void fillAndSaveUser(String username) {
        usernameField.setValue(username);
        passwordField.setValue(password);
        confirmPasswordField.setValue(password);
        commitAndCloseBtn.click();
    }
}
