package dev.hyux.springpetclinic.repositories;

import dev.hyux.springpetclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
