package com.JSONObject.Test;



import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Convert(converter = CarDataConverter.class)
    private CarData cars;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CarData getCars() {
        return cars;
    }

    public void setCars(CarData cars) {
        this.cars = cars;
    }
}
