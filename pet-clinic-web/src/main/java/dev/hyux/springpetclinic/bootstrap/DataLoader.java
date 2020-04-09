package dev.hyux.springpetclinic.bootstrap;

import dev.hyux.springpetclinic.model.Owner;
import dev.hyux.springpetclinic.model.PetType;
import dev.hyux.springpetclinic.model.Vet;
import dev.hyux.springpetclinic.services.OwnerService;
import dev.hyux.springpetclinic.services.PetTypeService;
import dev.hyux.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Brown");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alex");
        owner2.setLastName("Garcia");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Robert");
        vet1.setLastName("West");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Margaret");
        vet2.setLastName("Evans");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
