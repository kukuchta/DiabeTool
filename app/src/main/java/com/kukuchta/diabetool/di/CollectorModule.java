package com.kukuchta.diabetool.di;
import com.kukuchta.diabetool.collectors.base.CollectorPlugin;
import com.kukuchta.diabetool.collectors.plugins.TestCollectorPlugin;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import dagger.multibindings.IntoSet;

@Module
@InstallIn(SingletonComponent.class)
public class CollectorModule {

    /**
     * Provides the TestCollectorPlugin and adds it to a set of all CollectorPlugin implementations.
     * The @IntoSet annotation is key here.
     */
    @Provides
    @IntoSet
    public CollectorPlugin provideTestCollectorPlugin(TestCollectorPlugin implementation) {
        return implementation;
    }

    /*
    // WHEN YOU ADD A NEW PLUGIN IN THE FUTURE, JUST ADD ANOTHER PROVIDER METHOD:

    @Provides
    @IntoSet
    public CollectorPlugin provideAnotherRealPlugin(AnotherRealPlugin implementation) {
        return implementation;
    }
    */
}
