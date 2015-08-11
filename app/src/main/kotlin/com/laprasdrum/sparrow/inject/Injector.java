package com.laprasdrum.sparrow.inject;

import android.app.Application;

public final class Injector {
    private static ApplicationComponent component;

    public static void init(final Application application) {
        component = DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(application))
                .build();
    }

    public static ApplicationComponent get() {
        return component;
    }
}
