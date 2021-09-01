/*
 * Copyright (c) 2008-2013 Haulmont. All rights reserved.
 */

package com.company.demo.menu;

import com.company.demo.screen.UserBrowse;
import io.jmix.masquerade.component.SideMenu;

public final class Menus {
    public static final SideMenu.Menu<UserBrowse> USER_BROWSE =
            new SideMenu.Menu<>(UserBrowse.class, "application", "User.browse");
}
