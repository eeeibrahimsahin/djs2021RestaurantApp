package com.restaurant.reservationApp;

import com.restaurant.reservationApp.drink.Drink;
import com.restaurant.reservationApp.drink.DrinkRepository;
import com.restaurant.reservationApp.employee.Employee;
import com.restaurant.reservationApp.employee.EmployeeRepository;
import com.restaurant.reservationApp.employee.EmployeeService;
import com.restaurant.reservationApp.food.Food;
import com.restaurant.reservationApp.food.FoodRepository;
import com.restaurant.reservationApp.guest.Guest;
import com.restaurant.reservationApp.guest.GuestRepository;
import com.restaurant.reservationApp.table.Table;
import com.restaurant.reservationApp.table.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestaurantAppApplication {

    @Autowired
    private DrinkRepository drinkRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private GuestRepository guestRepository;
    @Autowired
    private TableRepository tableRepository;

    public static void main(String[] args) {

        SpringApplication.run(RestaurantAppApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        final List<Drink> drinkList = new ArrayList<>(Arrays.asList(
//                new Drink(1, "CocoCola", "Soft", 2000, "box", 1.5),
//                new Drink(2, "Pepsi", "Soft", 2000, "box", 1),
//                new Drink(3, "Corona", "Beer", 2000, "bottle", 3),
//                new Drink(4, "Chivas", "Whiskey", 2000, "bottle", 10),
//                new Drink(5, "Spa", "Soft", 2000, "bottle", 1),
//                new Drink(6, "Dujardin Blauw", "Brandy", 2000, "bottle", 20),
//                new Drink(7, "Heneiken", "Beer", 2000, "bottle", 3),
//                new Drink(8, "LeCola", "Soft", 2000, "box", 1),
//                new Drink(9, "Guiness", "Beer", 2000, "bottle", 3)
//
//        ));
//        final List<Employee> employeeList = new ArrayList<>(Arrays.asList(
//                new Employee(1, "Aysegul", "Aydar", "aysegul.aydar","aysegul.aydar", "ADMIN"),
//                new Employee(2, "Ayse", "Kocak", "ayse.kocak", "ayse.kocak", "CHEF"),
//                new Employee(3, "Saif", "Alamrani", "saif.alamrani", "saif.alamrani", "RECEPTIONIST"),
//                new Employee(4, "Zeynel", "Goksu", "zeynel.goksu",   "zeynel.goksu", "KITCHEN"),
//                new Employee(5, "Issa", "Rizqallah", "issa.rizqallah", "issa.rizqallah", "CASHIER"),
//                new Employee(6, "Ibrahim", "Sahin", "crazyboy007","crazyboy007",  "WAITER")
//        ));
//        final List<Food> foodList = new ArrayList<>(Arrays.asList(
//                new Food(100, "Chicken Salad", "Meal", 9, 15, "gr"),
//                new Food(101, "Salad", "Starter", 2.1, 5, "gr"),
//                new Food(102, "Wonton Soup with BBQ", "Starter", 400, 4.99, "ml"),
//                new Food(103, "Five Star", "meal", 800, 25, "gr"),
//                new Food(104, "Chicken Kang ka Ree", "meal", 850, 35, "gr")));
//
//        final List<Guest> guestList = new ArrayList<>(Arrays.asList(
//                new Guest(1, "Mila", "Bom", 061234567, 234),
//                new Guest(2, "Alex", "De Souza", 061234567, 345),
//                new Guest(3, "Yolant", "Verbulen", 061234567, 456),
//                new Guest(4, "Johan", "Cruyff", 061234567, 567),
//                new Guest(5, "Pogba", "Henry", 061234567, 678),
//                new Guest(6, "Sedat", "Peker", 061234567, 789)
//        ));
//
//        final List<Table> tableList = new ArrayList<>(Arrays.asList(
//                new Table(1, 4, 2),
//                new Table(2, 4, 1),
//                new Table(3, 4, 2),
//                new Table(4, 2, 1),
//                new Table(5, 2, 2),
//                new Table(6, 2, 1),
//                new Table(7, 8, 1)
//        ));
//
//        drinkRepository.saveAll(drinkList);
//        employeeList.forEach(employee -> employeeService.createEmployee(employee));
//        foodRepository.saveAll(foodList);
//        guestRepository.saveAll(guestList);
//        tableRepository.saveAll(tableList);
//    }
}
