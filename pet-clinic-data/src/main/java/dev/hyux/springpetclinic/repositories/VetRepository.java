package dev.hyux.springpetclinic.repositories;

import dev.hyux.springpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
