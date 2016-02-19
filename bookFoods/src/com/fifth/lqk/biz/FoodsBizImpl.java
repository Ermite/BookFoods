package com.fifth.lqk.biz;

import java.util.ArrayList;

import com.fifth.bean.FoodsBean;
import com.fifth.lqk.dao.FoodsDao;
import com.fifth.lqk.dao.FoodsDaoImpl;

public class FoodsBizImpl implements FoodsBiz {
	FoodsDao foodsDao = new FoodsDaoImpl();
	@Override
	public FoodsBean findFoodById(int food_id) {
		FoodsBean foodsBean =null;
		try {
			foodsBean=foodsDao.findFoodById(food_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return foodsBean;
	}
	@Override
	public int fetchNumber() {
		int number=0;
		try {
			number=foodsDao.fetchNumber();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return number;
	}

}
