package com.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "dance")
public class Dance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "style")
    private String style;

    @ManyToOne(optional = false)
    @JoinColumn(name = "man_id")
    private Man man;

    @ManyToOne
    @JoinColumn(name = "woman_id")
    private Woman woman;

    public Dance(){

    }

    public Dance(String style, Man man, Woman woman) {
        this.style = style;
        this.man = man;
        this.woman = woman;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Man getMan() {
        return man;
    }

    public void setMan(Man man) {
        this.man = man;
    }

    public Woman getWoman() {
        return woman;
    }

    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dance dance = (Dance) o;

        if (id != dance.id) return false;
        if (style != null ? !style.equals(dance.style) : dance.style != null) return false;
        if (man != null ? !man.equals(dance.man) : dance.man != null) return false;
        return woman != null ? woman.equals(dance.woman) : dance.woman == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (style != null ? style.hashCode() : 0);
        result = 31 * result + (man != null ? man.hashCode() : 0);
        result = 31 * result + (woman != null ? woman.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dance " +
                "id = " + this.id +
                ", style = " + this.style + "\n" +
                man + " " +
                woman;
    }
}
