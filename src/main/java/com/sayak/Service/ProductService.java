package com.sayak.Service;

import com.sayak.Entity.Product;
import com.sayak.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getInventory() {
       return productDao.findById(1).get();
    }
}
