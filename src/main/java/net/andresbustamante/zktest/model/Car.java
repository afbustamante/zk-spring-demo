package net.andresbustamante.zktest.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Car {

    private Integer id;
    private String model;
    private String make;
    private String preview;
    private String description;
    private Integer price;

    public Car(Integer id, String model, String make, String description,  String preview, Integer price){
        this.id = id;
        this.model = model;
        this.make = make;
        this.preview = preview;
        this.description = description;
        this.price = price;
    }

}