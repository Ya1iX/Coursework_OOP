package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable {
    String techTask;
    ArrayList<Constructor> constrTeam;
    int teamSize, price, id;
    boolean isPaid, isRegistered;

    public Order(String techTask, int price, boolean isPaid, boolean isRegistered) {
        this.techTask = techTask;
        this.constrTeam = new ArrayList<>();
        this.teamSize = constrTeam.size();
        this.price = price;
        this.isPaid = isPaid;
        this.isRegistered = isRegistered;
    }

    public String getTechTask() {
        return techTask;
    }

    public void setTechTask(String techTask) {
        this.techTask = techTask;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getTeamSize  () { return teamSize = constrTeam.size(); }

    public void setTeamSize(int teamSize) { this.teamSize = teamSize; }

    public boolean isPaid() { return isPaid; }

    public void setPaid(boolean paid) { isPaid = paid; }

    public boolean isRegistered() { return isRegistered; }

    public void setRegistered(boolean registered) { isRegistered = registered; }

    public ArrayList<Constructor> getConstrTeam() {
        return constrTeam;
    }

    public void setConstrTeam(ArrayList<Constructor> constrTeam) {
        this.constrTeam = constrTeam;
    }

    @Override
    public String toString() {
        return "TechTask: " + techTask + " | Price: " + price + " | TeamSize: " + teamSize + " | isPaid: " + isPaid + " | isRegistered: " + isRegistered + " | ID: " + id + " | ConstrTeam: " + constrTeam;
    }
}

