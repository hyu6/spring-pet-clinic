package dev.hyux.springpetclinic.bootstrap;

import dev.hyux.springpetclinic.model.Owner;
import dev.hyux.springpetclinic.model.Vet;
import dev.hyux.springpetclinic.services.OwnerService;
import dev.hyux.springpetclinic.services.VetService;
import dev.hyux.springpetclinic.services.map.OwnerServiceMap;
import dev.hyux.springpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Brown");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Alex");
        owner2.setLastName("Garcia");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Robert");
        vet1.setLastName("West");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Margaret");
        vet2.setLastName("Evans");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}
