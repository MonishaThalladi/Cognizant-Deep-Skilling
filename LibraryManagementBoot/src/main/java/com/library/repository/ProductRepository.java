package com.library.repository;

import com.library.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    // Criteria Query for dynamic filtering (Hands-on 6)
    public List<Product> searchProducts(String category, String ramSize, String hardDisk, 
                                        String cpuSpeed, String operatingSystem) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        Root<Product> product = cq.from(Product.class);

        List<Predicate> predicates = new ArrayList<>();

        // Dynamically add filters
        if (category != null && !category.isEmpty()) {
            predicates.add(cb.equal(product.get("category"), category));
        }
        if (ramSize != null && !ramSize.isEmpty()) {
            predicates.add(cb.equal(product.get("ramSize"), ramSize));
        }
        if (hardDisk != null && !hardDisk.isEmpty()) {
            predicates.add(cb.equal(product.get("hardDisk"), hardDisk));
        }
        if (cpuSpeed != null && !cpuSpeed.isEmpty()) {
            predicates.add(cb.equal(product.get("cpuSpeed"), cpuSpeed));
        }
        if (operatingSystem != null && !operatingSystem.isEmpty()) {
            predicates.add(cb.equal(product.get("operatingSystem"), operatingSystem));
        }

        cq.select(product).where(predicates.toArray(new Predicate[0]));
        return entityManager.createQuery(cq).getResultList();
    }
}
