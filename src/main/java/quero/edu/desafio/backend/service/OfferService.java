package quero.edu.desafio.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import quero.edu.desafio.backend.model.Offer;
import quero.edu.desafio.backend.repository.OfferRepository;

@Service
public class OfferService {
    private final OfferRepository offerRepository;


    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public Iterable<Offer> list() {
        return offerRepository.findAll();
    }

    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    public Iterable<Offer> save(List<Offer> offers) {
        return offerRepository.saveAll(offers);
    }
}
