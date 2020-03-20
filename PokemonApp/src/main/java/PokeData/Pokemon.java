package PokeData;

public class Pokemon {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    private long id;
    private String name;
    private long height;
    private long weight;

    public Pokemon(){

    }


    @Override
    public String toString() {
        return ">> Pokemon {" +
                "ID = " + id +
                ", Name = '" + name + '\'' +
                ", Height = " + height +
                ", Weight = " + weight + '\'' +
                '}';
    }

}
