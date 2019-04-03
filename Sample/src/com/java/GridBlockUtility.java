package com.java;
import java.util.List;

/**
 * @author 728332
 *
 */
public interface GridBlockUtility {
	
	/**
	 * @param items
	 * @return
	 */
	public List<Item> configureItems(List<String> items);

	/**
	 * @param item
	 */
	public void traverseThroughGridBlocks(Item item);
	
	/**
	 * @return
	 */
	public List<Item> sortOrdersPerTimeTaken(List<Item> items);
}
