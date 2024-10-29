package org.mock.persistence.entity;

public class Player {

    private Long id;
    private String name;
    private String team;
    private String position;

    public Player() {
    }

    public Player(Long id, String nombre, String equipo, String posicion) {
        this.id = id;
        this.name = nombre;
        this.team = equipo;
        this.position = posicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id = " + id +
                ", nombre = '" + name + '\'' +
                ", equipo = '" + team + '\'' +
                ", posicion = '" + position + '\'' +
                '}';
    }
}
