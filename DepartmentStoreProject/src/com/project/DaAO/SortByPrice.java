package com.project.DaAO;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

import com.project.pojo.Product;
public class SortByPrice implements Comparator<Map.Entry<Integer, Product>>{

	@Override
	public int compare(Entry<Integer, Product> o1, Entry<Integer, Product> o2) {
		return Double.compare(o1.getValue().getSellingPrice(),o2.getValue().getSellingPrice());
	}

}
