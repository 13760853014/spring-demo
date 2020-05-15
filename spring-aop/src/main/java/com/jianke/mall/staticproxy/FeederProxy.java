package com.jianke.mall.staticproxy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeederProxy implements Cat {
    private Cat cat;

    @Override
    public String eatFood(String foodName) {
        System.out.println("proxy Lion exec eatFood ");
        return cat.eatFood(foodName);
    }

    @Override
    public boolean running() {
        System.out.println("proxy Lion exec running.");
        return cat.running();
    }
}