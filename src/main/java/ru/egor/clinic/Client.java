package ru.egor.clinic;

import java.util.Objects;

public class Client {
    private String name;
    private Pet pet;
    private int id;

    public Client(int id, String name, Pet pet) {
        this.name = name;
        this.pet = pet;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", pet=" + pet +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return id == client.id &&
                Objects.equals(name, client.name) &&
                Objects.equals(pet, client.pet);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, pet, id);
    }
}
