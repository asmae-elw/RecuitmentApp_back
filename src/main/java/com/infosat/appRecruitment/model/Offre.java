package com.infosat.appRecruitment.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Offre implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;
    private String title;
    private String contract;
    private String salary;
    private String prerequisites;
    private String experience;



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "offres")
    private Set<User> users = new HashSet<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public String getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(String prerequisites) {
        this.prerequisites = prerequisites;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Offre() {}

    public Offre(String title, String contract, String salary, String prerequisites, String experience ) {
        this.title = title;
        this.contract = contract;
        this.salary = salary;
        this.prerequisites = prerequisites;
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Offre{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", contract='" + contract + '\'' +
                ", salary='" + salary + '\'' +
                ", prerequisites='" + prerequisites + '\'' +
                ", experience='" + experience + '\'' +
                '}';
    }
}


