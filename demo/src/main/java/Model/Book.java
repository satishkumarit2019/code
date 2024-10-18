package Model;

import lombok.Data;

@Data
public class Book {
    private String title;
    private String name;
    private Double price;

    public Book(String title, String name, Double price){
        this.name =name;
        this.price=price;
        this.title=title;
    }
}
