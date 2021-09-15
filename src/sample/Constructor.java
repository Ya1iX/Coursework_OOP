package sample;

import java.io.Serializable;

public class Constructor implements Serializable {
    String name, isEmployedStr;
    int workExp, constructorId;
    boolean isEmployed;

    public Constructor(String name, int workExp) {
        this.name = name;
        this.workExp = workExp;
        this.isEmployed = false;
        this.isEmployedStr = isEmployed() ? "Занят" : "Свободен";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorkExp() {
        return workExp;
    }

    public void setWorkExp(int workExp) {
        this.workExp = workExp;
    }

    public boolean isEmployed() { return isEmployed; }

    public void setEmployed(boolean employed) { isEmployed = employed; }

    public int getConstructorId() { return constructorId; }

    public void setConstructorId(int constructorId) { this.constructorId = constructorId; }

    public String getIsEmployedStr() { return isEmployedStr = isEmployed() ? "Занят" : "Свободен"; }

    public void setIsEmployedStr(String isEmployedStr) { this.isEmployedStr = isEmployedStr; }

    @Override
    public String toString(){
        return "Name: " + name + " | workExp: " + workExp + " | isEmployed: " + isEmployed + " | ID: " + constructorId;
    }
}
