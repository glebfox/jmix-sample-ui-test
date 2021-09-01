package com.company.demo.screen;

import io.jmix.masquerade.Wire;
import io.jmix.masquerade.base.Composite;
import io.jmix.masquerade.component.SideMenu;

import static com.company.demo.menu.Menus.USER_BROWSE;

public class MainScreen extends Composite<MainScreen> {

    @Wire
    private SideMenu sideMenu;

    public UserBrowse openUserBrowse() {
        return sideMenu.openItem(USER_BROWSE);
    }
}
