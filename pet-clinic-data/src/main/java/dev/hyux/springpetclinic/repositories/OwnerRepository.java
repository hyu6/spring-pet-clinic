package dev.hyux.springpetclinic.repositories;

import dev.hyux.springpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
