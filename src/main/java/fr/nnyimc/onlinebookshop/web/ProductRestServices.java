package fr.nnyimc.onlinebookshop.web;

import fr.nnyimc.onlinebookshop.persistence.dao.ProductRepository;
import fr.nnyimc.onlinebookshop.persistence.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
public class ProductRestServices {
    private final ProductRepository productRepository;

    public ProductRestServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value="/seeProducts")
    public Page<Product> productPage(Pageable pageable)
    {
        return productRepository.findAll(pageable);
    }

    @GetMapping(value="/seeProduct/{id}")
    public Product product(@PathVariable(name="id") Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @PutMapping(value="/updateProduct/{id}")
    public Product update(@PathVariable(name="id") Long id, @RequestBody Product p) {
        p.setId(id);
        return productRepository.save(p);
    }

    @PostMapping(value="/addProduct")
    public Product add(@RequestBody Product p) {
        return productRepository.save(p);
    }

    @DeleteMapping(value="/deleteProduct/{id}")
    public void delete(@PathVariable(name="id") Long id) {
        productRepository.deleteById(id);
    }
}
