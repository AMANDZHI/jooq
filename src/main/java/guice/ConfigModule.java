package guice;

import com.google.inject.AbstractModule;

public class ConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Repository.class).to(ManRepository.class);
    }
}
