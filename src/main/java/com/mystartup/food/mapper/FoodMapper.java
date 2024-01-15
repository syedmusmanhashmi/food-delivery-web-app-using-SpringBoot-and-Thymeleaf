//Creating mapper in order to access database

package com.mystartup.food.mapper;

import com.mystartup.food.model.Food;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FoodMapper {
    //In interface we don't need to provide details here
    @Select("SELECT * FROM FOOD")
    Food[] selectFoods();
    //mapper method will run from the FoodService. so we will create a method in foodservice
    @Insert("INSERT INTO FOOD (name,price) VALUES (#{name},#{price})")
    int insertFood(Food food);
}
