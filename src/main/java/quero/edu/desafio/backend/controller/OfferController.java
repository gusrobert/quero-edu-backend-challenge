package quero.edu.desafio.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import quero.edu.desafio.backend.model.Offer;
import quero.edu.desafio.backend.service.OfferService;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;


    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/list")
    public Iterable<Offer> list() {
        Iterable<Offer> offers = offerService.list();

        
        for (Offer offer : offers) {
            if (!offer.getKind().isEmpty() && !offer.getKind().equals("offers")) {
                offer.setKind(processKind(offer.getKind()));
            }

            if(!offer.getLevel().isEmpty() && !offer.getLevel().equals("offers")) {
                offer.setLevel(offer.getLevel());
            }
            

        }

        return offers;
    }

    public String processKind(String kind) {
        if(kind.equals("presencial")) {
            return kind.substring(0, 1).toUpperCase() + kind.substring(1);
        }

        return "EaD";
    }

    public String processLevel(String level) {
        if(level.equals("bacharelado")) {
            return "Graduação (bacharelado)";
        }

        if(level.equals("tecnologo")) {
            return "Graduação (tecnólogo)";
        }

        return "Graduação (licenciatura)";
    }
}
