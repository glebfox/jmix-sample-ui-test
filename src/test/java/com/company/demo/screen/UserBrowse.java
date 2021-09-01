package com.company.demo.screen;

import io.jmix.masquerade.Wire;
import io.jmix.masquerade.base.Composite;
import io.jmix.masquerade.component.Button;
import io.jmix.masquerade.component.Table;

import static io.jmix.masquerade.Conditions.VISIBLE;
import static io.jmix.masquerade.Selectors.byText;

public class UserBrowse extends Composite<UserBrowse> {

    @Wire
    private Button createBtn;

    @Wire
    private Table usersTable;

    public UserEdit createUser() {
        createBtn.click();
        return new UserEdit();
    }

    public void checkRecordIsDisplayed(String username){
        usersTable.shouldBe(VISIBLE)
                .getRow(byText(username))
                .shouldBe(VISIBLE);
    }
}
