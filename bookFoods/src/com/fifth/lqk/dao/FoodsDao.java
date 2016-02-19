package com.fifth.lqk.dao;

import java.util.ArrayList;

import com.fifth.bean.FoodsBean;

public interface FoodsDao {

	public FoodsBean findFoodById(int food_id);

	public int fetchNumber();

}
