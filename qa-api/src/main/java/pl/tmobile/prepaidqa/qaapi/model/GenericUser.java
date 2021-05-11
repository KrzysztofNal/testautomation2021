package pl.tmobile.prepaidqa.qaapi.model;

public class GenericUser<T> {

    private T id;
    private String name;
    private String surname;

    public T getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
