package com.ogaclejapan.qiitanium;


import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    protected final Qiitanium mApp;

    public AppModule(Qiitanium app) {
        this.mApp = app;
    }

    @Singleton
    @Provides
    public Application provideApplication() {
        return mApp;
    }

    @Singleton
    @Provides
    public Application.ActivityLifecycleCallbacks provideActivityLifecycleCallbacks() {
        return new AppActivityLifecycleCallbacks();
    }

    @Singleton
    @Provides
    public Qiitanium.LifecycleCallbacks provideAppLifecycleCallbacks() {
        return new AppLifecycleCallbacks(mApp);
    }

}
