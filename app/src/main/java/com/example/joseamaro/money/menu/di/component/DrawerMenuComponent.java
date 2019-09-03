package com.example.joseamaro.money.menu.di.component;


import com.core.di.component.ActivityComponent;
import com.example.joseamaro.money.menu.presentation.activity.DrawerMenuActivity;
import com.example.joseamaro.money.menu.di.module.DrawerMenuModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by joseamaro on 02-09-19.
 */

@Singleton
@Component(modules = {DrawerMenuModule.class})
public interface DrawerMenuComponent extends ActivityComponent<DrawerMenuActivity>{
}
