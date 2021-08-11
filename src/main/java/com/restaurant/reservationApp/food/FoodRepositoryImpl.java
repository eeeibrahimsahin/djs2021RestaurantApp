package com.restaurant.reservationApp.food;

import com.restaurant.reservationApp.drink.Drink;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class FoodRepositoryImpl implements FoodRepository{

    List <Food> foodList = new ArrayList<>(Arrays.asList(
            new Food(100,"Chicken Salad", "Meal", 9,15,"gr"),
            new Food(101,"Salad","Starter",2.1,5,"gr"),
            new Food(102,"Wonton Soup with BBQ","Starter",400,4.99,"ml"),
            new Food(103,"Five Star","meal",800,25,"gr"),
            new Food (104,"Chicken Kang ka Ree","meal",850,35,"gr")));

    @Override
    public List<Food> getAllFood() {
        return foodList ;
    }

    @Override
    public Food getFoodById(long id) {
        for(Food food : foodList){
            if(food.getId()== id){
                return food;
            }
        }
        return null;
    }

    @Override
    public Food createFood(Food food) {

            food.setId(100+(foodList.size() + 1));
            foodList.add(food);
            return food;
    }
}
