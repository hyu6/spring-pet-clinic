package dev.hyux.springpetclinic.bootstrap;

import dev.hyux.springpetclinic.model.Owner;
import dev.hyux.springpetclinic.model.Pet;
import dev.hyux.springpetclinic.model.PetType;
import dev.hyux.springpetclinic.model.Vet;
import dev.hyux.springpetclinic.services.OwnerService;
import dev.hyux.springpetclinic.services.PetTypeService;
import dev.hyux.springpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Brown");
        owner1.setAddress("100 Alpha Street");
        owner1.setCity("San Jose");
        owner1.setTelephone("4001231234");

        Pet pet1 = new Pet();
        pet1.setName("Max");
        pet1.setPetType(dog);
        pet1.setOwner(owner1);
        pet1.setBirthday(LocalDate.now());
        owner1.getPets().add(pet1);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Alex");
        owner2.setLastName("Garcia");
        owner1.setAddress("200 Beta Street");
        owner1.setCity("Cupertino");
        owner1.setTelephone("4011231234");

        Pet pet2 = new Pet();
        pet2.setName("Kitty");
        pet2.setPetType(cat);
        pet2.setOwner(owner2);
        pet2.setBirthday(LocalDate.now());
        owner2.getPets().add(pet2);

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
