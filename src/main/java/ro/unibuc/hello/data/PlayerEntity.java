package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

public class PlayerEntity {
    @Id
    private String id;

    private String nume;
    private String echipa;
    private String pozitie;

    public PlayerEntity() {}

    public PlayerEntity(String nume, String echipa, String pozitie) {
        this.nume = nume;
        this.echipa = echipa;
        this.pozitie = pozitie;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String title) {
        this.nume = title;
    }

    public String getEchipa() {
        return echipa;
    }

    public void setEchipa(String echipa) {
        this.echipa = echipa;
    }

    public String getPozitie() {
        return pozitie;
    }

    public void setPozitie(String pozitie) {
        this.pozitie = pozitie;
    }

    @Override
    public String toString() {
        return String.format(
                "Player[nume='%s', echipa='%s', pozitie='%s']",
                id, nume, echipa, pozitie);
    }
}