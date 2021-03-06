package ru.gb.homeWork.model;

import javax.persistence.*;

//@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    public Product() {
    }

    public Product(String title, int cost) {
        this.title = title;
        this.cost = cost;
    }

    public Product(Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
//        return  " nid: " + id + ',' + " title: " + title + ',' + " cost: " + cost;
        return String.format("Product [id = %d, title = %s, cost = %d]", id, title, cost);
    }
}
