package com.test;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import com.java.GridBlockUtility;
import com.java.GridBlockUtilityImpl;
import com.java.Item;
import com.java.NpsScoreCalculator;
import com.java.NpsScoreCalculatorImpl;  

public class DroneTest {
	
	GridBlockUtility util = new GridBlockUtilityImpl();
	NpsScoreCalculator cal = new NpsScoreCalculatorImpl();
	
	@Test
	public void TestDroneChallenge() {
		
		List<String> items = new ArrayList<>();
		items.add("WM001 N66W5 05:11:50");
		items.add("WM002 S333E24 05:11:55");
		items.add("WM003 N73E50 05:31:50");
		items.add("WM004 N113E52 06:11:50");
		
		List<Item> listItem = util.configureItems(items);
		
		for (Item item : listItem) {
			util.traverseThroughGridBlocks(item);
		}
		
		List<Item> orderedItems = util.sortOrdersPerTimeTaken(listItem);
		int nps = cal.findNpsScore(orderedItems);
		assertEquals(25, nps);
	}
}
