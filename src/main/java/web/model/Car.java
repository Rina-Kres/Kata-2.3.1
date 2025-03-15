package web.model;

public class Car {
    public int id;
    private String series;
    private String model;
    private int year;

    public Car(int id, String series, String model, int year) {
        this.id = id;
        this.series = series;
        this.model = model;
        this.year = year;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car {" +
                "id = '" + series + '\'' +
                ", model = '" + model + '\'' +
                ", date = " + year +
                '}';
    }
}
