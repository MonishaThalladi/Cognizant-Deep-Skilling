package com.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "p_id")
    private int id;

    @Column(name = "p_name")
    private String name;

    @Column(name = "p_category")
    private String category;

    @Column(name = "p_price")
    private double price;

    @Column(name = "p_ram_size")
    private String ramSize;

    @Column(name = "p_hard_disk")
    private String hardDisk;

    @Column(name = "p_cpu_speed")
    private String cpuSpeed;

    @Column(name = "p_operating_system")
    private String operatingSystem;

    // Constructors
    public Product() {}

    public Product(String name, String category, double price, String ramSize, String hardDisk, String cpuSpeed, String operatingSystem) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.ramSize = ramSize;
        this.hardDisk = hardDisk;
        this.cpuSpeed = cpuSpeed;
        this.operatingSystem = operatingSystem;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getRamSize() { return ramSize; }
    public void setRamSize(String ramSize) { this.ramSize = ramSize; }

    public String getHardDisk() { return hardDisk; }
    public void setHardDisk(String hardDisk) { this.hardDisk = hardDisk; }

    public String getCpuSpeed() { return cpuSpeed; }
    public void setCpuSpeed(String cpuSpeed) { this.cpuSpeed = cpuSpeed; }

    public String getOperatingSystem() { return operatingSystem; }
    public void setOperatingSystem(String operatingSystem) { this.operatingSystem = operatingSystem; }

    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "', category='" + category + "', price=" + price + "}";
    }
}
