package com.fifth.lqk.biz;

import java.util.ArrayList;

import com.fifth.bean.FoodsBean;

public interface FoodsBiz {

	public FoodsBean findFoodById(int food_id);

	public int fetchNumber();

}
