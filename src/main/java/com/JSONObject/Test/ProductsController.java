package com.JSONObject.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ProductsController {

    @Autowired
    private ProductsRepository productsRepository;

    @PostMapping("/saveProduct")
    public ResponseEntity<String> saveProduct(@RequestParam("UserData") String userData) {
        try {
            
            ObjectMapper objectMapper = new ObjectMapper();
            CarData carData = objectMapper.readValue(userData, CarData.class);
            
            System.out.println(" test "+carData);

            
            Products product = new Products();
            product.setCars(carData);

            
            productsRepository.save(product);

            return new ResponseEntity<>("Product saved successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error saving product", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
