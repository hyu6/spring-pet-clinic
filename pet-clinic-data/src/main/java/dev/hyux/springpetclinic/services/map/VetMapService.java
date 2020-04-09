package dev.hyux.springpetclinic.services.map;

import dev.hyux.springpetclinic.model.Vet;
import dev.hyux.springpetclinic.services.SpecialtyService;
import dev.hyux.springpetclinic.services.VetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetMapService(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Vet object) {

        if (object != null) {
            if (object.getSpecialities() != null && !object.getSpecialities().isEmpty()) {
                object.getSpecialities().forEach(speciality -> {
                    // unsaved speciality
                    if (speciality.getId() == null) {
                        specialtyService.save(speciality);
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
    public void delete(Vet object) {
        super.delete(object);
    }
}