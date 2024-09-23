package quero.edu.desafio.backend.repository;

import org.springframework.data.repository.CrudRepository;

import quero.edu.desafio.backend.model.Offer;

public interface OfferRepository extends CrudRepository<Offer, Long> {
    
}
