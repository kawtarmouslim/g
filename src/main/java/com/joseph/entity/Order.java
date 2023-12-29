package com.joseph.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commande;

    private String status;
    private String name_client;
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> orderedProducts;

    private String id_user;
    private int date_creation;

    public Order(String status, String name_client, List<Product> orderedProducts, String id_user, int date_creation) {
        this.status = status;
        this.name_client = name_client;
        this.orderedProducts = orderedProducts;
        this.id_user = id_user;
        this.date_creation = date_creation;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName_client() {
        return name_client;
    }

    public void setName_client(String name_client) {
        this.name_client = name_client;
    }

    public List<Product> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<Product> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public int getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(int date_creation) {
        this.date_creation = date_creation;
    }
}
