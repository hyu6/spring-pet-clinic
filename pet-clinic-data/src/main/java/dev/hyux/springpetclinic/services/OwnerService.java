package dev.hyux.springpetclinic.services;

import dev.hyux.springpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
