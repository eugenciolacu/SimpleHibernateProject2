package com.hibernate.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "man")
public class Man {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "man", cascade = CascadeType.ALL)
    private List<Dance> dances = new ArrayList<Dance>();

    public Man(){

    }

    public Man(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dance> getDances() {
        return dances;
    }

    public void setDances(List<Dance> dances) {
        this.dances = dances;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Man man = (Man) o;

        if (id != man.id) return false;
        if (!name.equals(man.name)) return false;
        return dances.equals(man.dances);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        result = 31 * result + dances.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Man " +
                "id = " + this.id +
                ", name = " + this.name;
    }
}
