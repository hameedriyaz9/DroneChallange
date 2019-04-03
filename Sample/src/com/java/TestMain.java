package com.java;

import java.util.List;

/**
 * @author 728332
 *
 */
public class TestMain {

	/**
	 * @param args path for the input file.
	 */
	public static void main(String[] args) {

		NpsScoreCalculator cal = new NpsScoreCalculatorImpl();
		GridBlockUtility util = new GridBlockUtilityImpl();
		FileOperations fo = new FileOperationsImpl();

		List<String> items = fo.readContentFromFile(args[0]);

		List<Item> itemList = util.configureItems(items);

		for (Item item : itemList) {
			util.traverseThroughGridBlocks(item);
		}

		List<Item> orderedItems = util.sortOrdersPerTimeTaken(itemList);

		int nps = cal.findNpsScore(orderedItems);
		
		String path = System.getProperty("user.home") + "\\Desktop\\Delivered.txt";
		
		String message = fo.writeContentToDisk(orderedItems, nps, path);
		System.out.println(message);
	}

}
