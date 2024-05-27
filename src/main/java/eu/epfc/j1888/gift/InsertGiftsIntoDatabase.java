package eu.epfc.j1888.gift;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertGiftsIntoDatabase {
    Logger logger = LoggerFactory.getLogger(InsertGiftsIntoDatabase.class);
    @Bean
    CommandLineRunner insertGifts(GiftRepository repository) {
        return args -> {
            insertGift(repository, "fleur", 49.99, "fête des mères");
            insertGift(repository, "chocolat", 15.84, "fête des pères");
        };
    }

    private void insertGift(GiftRepository repository, String name, double price, String opportunity) {
        Gift gift = new Gift(null, name, price, opportunity);
        repository.save(gift);
        logger.info("insert " + gift);
    }
}
