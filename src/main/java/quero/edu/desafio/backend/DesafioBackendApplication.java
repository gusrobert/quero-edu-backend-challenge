package quero.edu.desafio.backend;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import quero.edu.desafio.backend.model.Offer;
import quero.edu.desafio.backend.service.OfferService;

@SpringBootApplication
public class DesafioBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DesafioBackendApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(OfferService offerService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Offer>> typeReference = new TypeReference<List<Offer>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
            try {
                List<Offer> offers = mapper.readValue(inputStream,typeReference);
                offerService.save(offers);
                System.out.println("Offers Saved!");
            } catch (IOException e){
                System.out.println("Unable to save offers: " + e.getMessage());
            }
        };
    }
}
