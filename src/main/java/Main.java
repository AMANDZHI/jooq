import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.ConfigModule;
import guice.Man;
import guice.ManService;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new ConfigModule());
        ManService manService = injector.getInstance(ManService.class);

        Man man = new Man();
        man.setId(3);
        man.setName("alex");

        manService.save(man);
        manService.getManById(3);
    }
}
