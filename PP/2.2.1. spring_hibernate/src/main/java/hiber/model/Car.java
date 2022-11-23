package hiber.model;

import javax.persistence.*;

@Entity
public class Car {

    @OneToOne(cascade = CascadeType.PERSIST,mappedBy = "car")
    User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String model;
    @Column
    private int series;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Car() {

    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }
}
