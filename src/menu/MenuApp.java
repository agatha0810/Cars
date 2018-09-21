package menu;

import data.Car;

import java.util.HashMap;
import java.util.Scanner;


public class MenuApp {

    public static final int EXIT = 0;
    public static final int ALL_CAR = 1;
    public static final int FIND_CAR = 2;
    public static final int ADD_CAR = 3;
    public static final int REMOVE_CAR = 4;


    public static int year;
    public static String brand;
    public static String model;
    public static String color;


    public static void main(String[] args) {

        MenuApp menuApp = new MenuApp();
        try (Scanner sc = new Scanner(System.in);) {
            int userOption;
            do {
                menuApp.printOptions();
                userOption = sc.nextInt();
                sc.nextLine();

                switch(userOption) {
                    case MenuApp.EXIT:
                        break;
                    case MenuApp.ALL_CAR:
                        menuApp.allCars(sc);
                        break;
                    case MenuApp.FIND_CAR:
                        menuApp.findCar(sc);
                        break;
                    case MenuApp.ADD_CAR:
                        menuApp.addCar(sc);
                        break;
                    case MenuApp.REMOVE_CAR:
                        menuApp.removeCar(sc);
                        break;
                }
            } while (userOption != MenuApp.EXIT);
        }
    }


    //Auta na wejscie:
    public static HashMap<String, Car> infoCar() {
        HashMap<String, Car> warehouse = new HashMap<>();

        Car audi = new Car(2010, "audi", "a8", "black");
        Car fiat = new Car(2016, "fiat", "punto", "yellow");
        Car opel = new Car(2016, "opel", "astra", "blue");
        Car mitsubishi = new Car(2016, "mitsubishi", "spacestar", "white");
        Car toyota = new Car(2016, "toyota", "corolla", "red");

        Car mercedes = new Car(2010, "mercedes", "benz", "black");
        Car seat = new Car(2010, "seat", "ibiza", "red");
        Car subaru = new Car(2010, "subaru", "forester", "white");
        Car honda = new Car(2010, "honda", "civic", "blue");
        Car kia = new Car(2010, "kia", "sportage", "yellow");

        Car peugeot = new Car(2008, "peugeot", "partner");
        Car renault = new Car(2008, "reanult", "clio");
        Car citroen = new Car(2008, "bmw", "roadster");
        Car dacia = new Car(2008, "dacia", "duster");
        Car suzuki = new Car(2008, "suzuki", "swift");

        Car ford = new Car(2010, "ford", "fiesta", "black");
        Car skoda = new Car(2010, "skoda", "fabia", "red");
        Car hyundai = new Car(2010, "hyundai", "tucson", "white");
        Car volvo = new Car(2010, "volvo", "v40", "yellow");
        Car volkswagen = new Car(2010, "volkswagen", "golf", "green");
        Car mazda = new Car(2010, "mazda", "cx-5", "blue");
        Car jeep = new Car(2010, "jeep", "cherokee", "brown");

        warehouse.put("audi", audi);
        warehouse.put("fiat", fiat);
        warehouse.put("opel", opel);
        warehouse.put("mitsubishi", mitsubishi);
        warehouse.put("toyota", toyota);
        warehouse.put("mercedes", mercedes);
        warehouse.put("seat", seat);
        warehouse.put("subaru", subaru);
        warehouse.put("honda", honda);
        warehouse.put("kia", kia);
        warehouse.put("peugeot", peugeot);
        warehouse.put("renault", renault);
        warehouse.put("citroen", citroen);
        warehouse.put("dacia", dacia);
        warehouse.put("suzuki", suzuki);
        warehouse.put("ford", ford);
        warehouse.put("skoda", skoda);
        warehouse.put("hyundai", hyundai);
        warehouse.put("volvo", volvo);
        warehouse.put("volkswagen", volkswagen);
        warehouse.put("mazda", mazda);
        warehouse.put("jeep", jeep);

        return warehouse;

    }


    //Opcje MENU
    public void printOptions() {
        System.out.println("0 - wyjście z programu");
        System.out.println("1 - wypisanie wszystkich aut z bazy");
        System.out.println("2 - wyszukiwanie aut z bazy");
        System.out.println("3 - dodawanie aut do bazy");
        System.out.println("4 - usuwanie aut z bazy");
        System.out.println();
    }


    //Wypisywanie
    private static void allCars(Scanner sc){
        HashMap<String, Car> warehouse = new HashMap<>();
        warehouse = infoCar();

        int i = 0;
        System.out.println("Wszystkie auta w bazie (wszystkich razem mamy: " + warehouse.size() + "): ");
        for (String key : warehouse.keySet()){
            System.out.print(i++ + ": " + key + ", ");
        }
        System.out.println();
    }


    //Wyszukiwanie:
    private static void findCar(Scanner sc){
        HashMap<String, Car> warehouse = new HashMap<>();
        warehouse = infoCar();

        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj marke auta: ");
        String text = scanner.nextLine().toLowerCase();

        if (warehouse.get(text) == null) {
            System.out.println("Nie mamy takiego autka.");
        } else {
            System.out.println(warehouse.get(text));
        }
    }


    //Dodawanie:
    private static Car addCar(Scanner sc) {
        HashMap<String, Car> warehouse = new HashMap<>();
        warehouse = infoCar();

        Scanner scInt = new Scanner(System.in);
        Scanner scBrand = new Scanner(System.in);
        Scanner scModel = new Scanner(System.in);

        System.out.print("Dodawanie auta. ");
        System.out.println("Najpierw rocznik: ");

        year = scInt.nextInt();

        System.out.println("Marka: ");
        brand = scBrand.nextLine().toLowerCase();

        System.out.println("Model: ");
        model = scModel.nextLine().toLowerCase();

        Car car = new Car(year, brand, model, color);

        System.out.println("Dodane auto to: ");
        System.out.println(brand + " " + model);

        warehouse.put(brand, car);
        System.out.println("W bazie jest teraz: " + warehouse.size() + " aut. ");

        /*
        //TODO: dodawanie auta do listy tak, by przy kolejnym wypisaniu wszystkich to dodane widział
        warehouse.put(brand, car);
        */

        return car;

    }


    //Usuwanie:
    private static Car removeCar(Scanner sc) {
        HashMap<String, Car> warehouse = new HashMap<>();
        warehouse = infoCar();

        Scanner scInt = new Scanner(System.in);
        Scanner scBrand = new Scanner(System.in);
        Scanner scModel = new Scanner(System.in);

        System.out.print("Usuwanie auta. ");

        System.out.println("Marka: ");
        brand = scBrand.nextLine().toLowerCase();

        Car car = new Car(year, brand, model, color);

        if (warehouse.get(brand) == null) {
            System.out.println("Nie mamy takiego autka.");
        } else {
            System.out.println(warehouse.remove(brand));
        }

        System.out.println("Usunięte auto to: ");
        System.out.println(brand + " ");

        /*
        //TODO: usuwanie auta do listy tak, by przy kolejnym wypisaniu wszystkich to dodane widział
        warehouse.put(brand, car);
        */

        System.out.println("W bazie zostało: " + warehouse.size() + " aut. ");
        return car;

    }

}

