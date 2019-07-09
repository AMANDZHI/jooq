package guice;

import javax.inject.Inject;

public class ManService {

    @Inject
    private Repository repository;


    public void save(Man man) {
        repository.save(man);
    }

    public Man getManById(Integer id) {
        return repository.getManById(id);
    }
}
