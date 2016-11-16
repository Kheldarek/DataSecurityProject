package pl.put.poznan.model;

public class GreetingModel {
    private long greetingId;
    private String name;

    public GreetingModel(long greetingId, String name) {
        this.greetingId = greetingId;
        this.name = name;
    }

    public long getGreetingId() {
        return greetingId;
    }

    public String getName() {
        return name;
    }
}
