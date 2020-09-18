package fr.nnyimc.onlinebookshop;

import fr.nnyimc.onlinebookshop.persistence.dao.ProductRepository;
import fr.nnyimc.onlinebookshop.persistence.entities.Product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class OnlinebookshopApplication implements CommandLineRunner {
    private final RepositoryRestConfiguration restConfiguration;
    private final ProductRepository productRepository;

    public OnlinebookshopApplication(RepositoryRestConfiguration restConfiguration,
                                     ProductRepository productRepository) {
        this.restConfiguration = restConfiguration;
        this.productRepository = productRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(OnlinebookshopApplication.class, args);
    }

    @Override
    public void run(String... args) {

        try {
            restConfiguration.exposeIdsFor(Product.class);
            // Static instantiation
            productRepository.save(new Product(null, "Merise appliquée", 22.75,36));
            productRepository.save(new Product(null, "Bases de données", 18.75,18));
            productRepository.save(new Product(null, "Java Swing", 8.95,4));
            productRepository.save(new Product(null, "L'ésotérisme de Dante", 12.75,6))
            ;
            productRepository.save(new Product(null, "La crise du monde moderne", 8.99,28));
            productRepository.save(new Product(null, "Dans les fôrets de Sibérie", 9.05,14));
            productRepository.save(new Product(null, "Eros and the Mysteries of Love", 18.75,76));
            productRepository.save(new Product(null, "Orient et Occident", 28.05,48));

            productRepository.save(new Product(null, "Les Prolégomènes", 38.95,4));
            productRepository.save(new Product(null, "Les Morticoles", 12.05,36));
            productRepository.save(new Product(null, "Métaphysique du Moyen-Âge", 8.75,26));
            productRepository.save(new Product(null, "La Cité d'Isis", 10.95,10));

            productRepository.save(new Product(null, "The Evangelion Style", 4.95,24));
            productRepository.save(new Product(null, "La Danse avec le Diable", 12.85,32));
            productRepository.save(new Product(null, "Le Dossier Rebatet", 26.75,6));
            productRepository.save(new Product(null, "Le Symbolisme de la Croix", 10.95,3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
