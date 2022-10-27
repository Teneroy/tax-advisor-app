package org.leonid.taxadviserapp.entities;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private int companyId;
    private String position;
    private LocalDate birthDate;


    public User(int id, String name, int companyId, String position, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.companyId = companyId;
        this.position = position;
        this.birthDate = birthDate;
    }

    public User(String name, LocalDate birthDate, int companyId) {
        this.name = name;
        this.companyId = companyId;
        this.birthDate = birthDate;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
