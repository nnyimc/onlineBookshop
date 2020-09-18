package fr.nnyimc.onlinebookshop.persistence.dao;

import fr.nnyimc.onlinebookshop.persistence.entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource

public interface ProductRepository extends JpaRepository<Product, Long> {
    @RestResource(path="seeProducts")
    Page<Product> findAll(Pageable pageable);

    @RestResource(path="byQuantity")
    Page<Product> findByQuantityGreaterThan(@Param("qty") int qty, Pageable pageable);
}
