package pl.krakow.uek.pp5.creditcard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import pl.krakow.uek.pp5.creditcard.model.CreditCardFacade;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        System.out.println("It works :)");
        SpringApplication.run(App.class, args);
    }

    @Autowired
    CreditCardFacade creditCardFacade;

    @EventListener(ApplicationReadyEvent.class)
    void createSampleCards() {
        creditCardFacade.register(UUID.randomUUID().toString(), BigDecimal.valueOf(2000));
        creditCardFacade.register(UUID.randomUUID().toString(), BigDecimal.valueOf(5000));
        creditCardFacade.register(UUID.randomUUID().toString(), BigDecimal.valueOf(2500));
    }

}
