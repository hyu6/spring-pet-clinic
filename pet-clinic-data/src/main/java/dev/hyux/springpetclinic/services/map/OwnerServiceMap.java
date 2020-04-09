package dev.hyux.springpetclinic.services.map;

import dev.hyux.springpetclinic.model.Owner;
import dev.hyux.springpetclinic.services.OwnerService;
import dev.hyux.springpetclinic.services.PetService;
import dev.hyux.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractServiceMap<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if (object != null) {
            if (object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        // unsaved pet type
                        if (pet.getPetType().getId() == null) {
                            petTypeService.save(pet.getPetType());
                        }
                    } else {
                        throw new RuntimeException("Pet type is required");
                    }

                    // unsaved pet
                    if (pet.getId() == null) {
                        petService.save(pet);
                    }
                });
            }

            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
