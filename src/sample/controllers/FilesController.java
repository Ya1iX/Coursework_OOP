package sample.controllers;

import javafx.scene.control.Alert;
import sample.Constructor;
import sample.Order;

import java.io.*;
import java.util.ArrayList;

public class FilesController {
    public static void writeOrder(Order order, String path) throws IOException {
        ArrayList<Order> orders = readOrders(path);
        if (orders.isEmpty()) order.setId(0);
        else {
            order.setId(orders.get((orders.size() - 1)).getId() + 1);
        }
        orders.add(order);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(orders);
        } catch (FileNotFoundException e) {
            try (FileWriter file = new FileWriter(path); ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
                oos.writeObject(orders);
            } catch (IOException exception) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void changeOrder(Order order, String path) throws IOException {
        ArrayList<Order> orders = readOrders(path);
        int orderIndex = -1;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == order.getId()) orderIndex = i;
        }
        if (orderIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Изменяемый заказ не был найден!");
            alert.showAndWait();
            return;
        }
        orders.set(orderIndex, order);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(orders);
        } catch (FileNotFoundException e) {
            try (FileWriter file = new FileWriter(path); ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
                oos.writeObject(orders);
            } catch (IOException exception) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<Order> readOrders(String path) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            ArrayList<Order> orders = (ArrayList<Order>) ois.readObject();
            return orders;
        } catch (IOException e) {
            try {
                FileWriter file = new FileWriter(path);
                file.close();
            } catch (IOException exception) {
                System.out.println(e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Файл содержит некорректные данные.");
            alert.showAndWait();
        }
        return new ArrayList<Order>();
    }

    public static ArrayList<Constructor> readConstructors(String path) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            ArrayList<Constructor> constructors = (ArrayList<Constructor>) ois.readObject();
            return constructors;
        } catch (IOException e) {
            FileWriter file = new FileWriter(path);
            file.close();
        } catch (ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Файл содержит некорректные данные.");
            alert.showAndWait();
        }
        return new ArrayList<Constructor>();
    }

    public static void writeConstructor(Constructor constructor, String path) throws IOException {
        ArrayList<Constructor> constructors = readConstructors(path);
        if (constructors.isEmpty()) constructor.setConstructorId(0);
        else {
            constructor.setConstructorId(constructors.get((constructors.size() - 1)).getConstructorId() + 1);
        }
        constructors.add(constructor);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(constructors);
        } catch (FileNotFoundException e) {
            try (FileWriter file = new FileWriter(path); ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
                oos.writeObject(constructors);
            } catch (IOException exception) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void changeConstructor(Constructor constructor, String path) throws IOException {
        ArrayList<Constructor> constructors = readConstructors(path);
        int constructorIndex = -1;
        for (int i = 0; i < constructors.size(); i++) {
            if (constructors.get(i).getConstructorId() == constructor.getConstructorId()) constructorIndex = i;
        }
        if (constructorIndex == -1) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText(null);
            alert.setContentText("Изменяемый конструктор не был найден!");
            alert.showAndWait();
            return;
        }
        constructors.set(constructorIndex, constructor);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(constructors);
        } catch (FileNotFoundException e) {
            try (FileWriter file = new FileWriter(path); ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
                oos.writeObject(constructor);
            } catch (IOException exception) {
                System.out.println(e.getMessage());
            }
        }
    }
}
