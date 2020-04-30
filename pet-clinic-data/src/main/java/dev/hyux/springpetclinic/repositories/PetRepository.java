package dev.hyux.springpetclinic.repositories;

import dev.hyux.springpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}

