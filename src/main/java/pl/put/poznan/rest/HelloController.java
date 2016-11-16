package pl.put.poznan.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.put.poznan.model.GreetingModel;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
    private static final String HELLO_TEMPLATE = "Witaj, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(name = "/hejo")
    public GreetingModel obtainGreeting(@RequestParam(value = "name", defaultValue = "Ochrono Danych") String name) {
        return new GreetingModel(counter.getAndIncrement(), String.format(HELLO_TEMPLATE, name));
    }
}
