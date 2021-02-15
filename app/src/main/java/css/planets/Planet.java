package css.planets;

/**
 * Created by cssuser on 2/15/2017.
 */

public class Planet {
    private String name;
    private Double distanceFromSol;
    private Double diameter;

    public Planet(String name, Double distanceFromSol, Double diameter) {
        this.name = name;
        this.distanceFromSol = distanceFromSol;
        this.diameter = diameter;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
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