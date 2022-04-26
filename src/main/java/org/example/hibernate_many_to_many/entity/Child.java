package org.example.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String firstname;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE, CascadeType.REFRESH,CascadeType.DETACH })
    @JoinTable(name = "child_section"
            , joinColumns = @JoinColumn (name = "child_id")
            , inverseJoinColumns = @JoinColumn(name = "section_id")
    )
    private List<Section> sectionList;

    public Child() {
    }

    public Child(String name, int age) {
        this.firstname = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
    public void addSectionToChild(Section section) {
        if(sectionList == null) {
            sectionList = new ArrayList<>();
        }
        sectionList.add(section);
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", age=" + age +
                '}';
    }
}
