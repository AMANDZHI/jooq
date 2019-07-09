package guice;

public interface Repository {

    void save(Man man);

    Man getManById(Integer id);
}
