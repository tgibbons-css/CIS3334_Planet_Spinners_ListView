package css.planets;

/**
 * Created by cssuser on 2/15/2017.
 */

public class Planet {
    private String name;
    private Double distanceFromSol;
    private Integer diameter;

    public Planet(String name, Double distanceFromSol, Integer diameter) {
        this.name = name;
        this.distanceFromSol = distanceFromSol;
        this.diameter = diameter;
    }

    public Integer getDiameter() {
        return diameter;
    }

    public void setDiameter(Integer diameter) {
        this.diameter = diameter;
    }

    public Double getDistanceFromSol() {
        return distanceFromSol;
    }

    public void setDistanceFromSol(Double distanceFromSol) {
        this.distanceFromSol = distanceFromSol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(" + distanceFromSol + ", " + diameter + ")";
    }
}