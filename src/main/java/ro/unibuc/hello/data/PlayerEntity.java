package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class PlayerEntity {
    @Id
    public String id;

    public String nume;
    public String echipa;
    public String pozitie;

    public PlayerEntity() {}

    public PlayerEntity(String nume, String echipa, String pozitie) {
        this.nume = nume;
        this.echipa = echipa;
        this.pozitie = pozitie;
    }

    @Override
    public String toString() {
        return String.format(
                "Book[nume='%s', echipa='%s', pozitie='%s']",
                id, nume, echipa, pozitie);
    }
}