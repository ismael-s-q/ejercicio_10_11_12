package com.ismael.Springbootrestdeploy.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@ApiModel("Tabla de ordenadores portatiles para la venta") es para saber de que va en la documentacion de swagger
//@Table(name = "Laptops" ) esta anotación iría debajo de la de @Entity es para darle un nombre diferente en la documentacion de swagger
@Entity
public class Laptop {


    // atributos

    // @ApiModelProperty("Clave primaria autoincremental") es para darle información en la documentacion de swagger
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;



   // @ApiModelProperty("Tamaño aplicado en tipo Integer") es para darle información en la documentacion de swagger
    private Integer tamaño;

   // @ApiModelProperty("Color del ordenador según la marca del portatil") es para darle información en la documentacion de swagger
    private String colour;

    // constructor

    public Laptop(){
    }

    public Laptop(Long id, String model, Integer tamaño, String colour) {
        this.id = id;
        this.model = model;
        this.tamaño = tamaño;
        this.colour = colour;
    }


    // Getter and Setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    // toString


    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", tamaño=" + tamaño +
                ", colour='" + colour + '\'' +
                '}';
    }
}
