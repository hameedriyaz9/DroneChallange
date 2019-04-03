package com.java;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 728332
 *
 */
public class GridBlockUtilityImpl implements GridBlockUtility {

	/* (non-Javadoc)
	 * @see GridBlockUtility#traverseThroughGridBlocks(Item)
	 */
	@Override
	public void traverseThroughGridBlocks(Item item) {

		int biggest = 0;
		if (Integer.parseInt(item.getDirection()[1]) == Integer.parseInt(item.getDirection()[3])) {
			biggest = Integer.parseInt(item.getDirection()[1]);
		} else {
			biggest = Integer.parseInt(item.getDirection()[1]) > Integer.parseInt(item.getDirection()[3])
					? Integer.parseInt(item.getDirection()[1])
					: Integer.parseInt(item.getDirection()[3]);
		}

		if (biggest % 2 == 0) {
			biggest = biggest + 1;
		}
		String[][] array = new String[biggest][biggest];

		/** Preparing the grid. Assuming the first grid elements starts with zero. */
		for (int i = 0; i < biggest; i++) {
			for (int j = 0; j < biggest; j++) {
				array[i][j] = "N" + (j + 1) + "W" + (i + 1) + "~" + "N" + (j + 1) + "E" + (i + 1) + "~" + "N" + (j + 1)
						+ "S" + (j + 1) + "~" + "W" + (i + 1) + "E" + (i + 1) + "~" + "W" + (i + 1) + "S" + (j + 1)
						+ "~" + "S" + (j + 1) + "E" + (i + 1);
			}
		}
		/** Finding the center point in the array */
		int center = biggest / 2;
		int currentXCord = center;
		int currentYCord = center;
		Boolean[][] visited = new Boolean[array.length][array.length];

		for (int x = 0; x < visited.length; x++) {
			for (int y = 0; y < visited.length; y++) {
				if (x == center && y == center) {
					visited[x][y] = true;
				} else {
					visited[x][y] = false;
				}
			}
		}

		Model model = new Model();

		/** traverse for center element */
		boolean flag = traversingForCenterElement(array, center, item.getDirection(), currentXCord, currentYCord,
				visited, model, item);

		/** traverse for adjacent left to center element */
		if (!flag) {
			traversingForAdjLeftElement(array, center, currentXCord, currentYCord, visited, model, item);
		}

		/** traverse for adjacent right to center element */
		if (model != null && !model.isFlag()) {
			traversingForAdjRightElement(array, center, currentXCord, currentYCord, visited, model, item);
		}
	}

	/**
	 * @param array
	 * @param center
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param item
	 */
	private void traversingForAdjRightElement(String[][] array, int center, int currentXCord, int currentYCord,
			Boolean[][] visited, Model model, Item item) {
		currentXCord = center;
		currentYCord = center;
		currentXCord += 1;
		currentYCord += 1;
		int adjacentDistance = 1;
		while (currentXCord < array.length - 1 && currentYCord < array.length - 1) {
			if (traverseAdjacentElements(array, center, item.getDirection(), currentXCord, currentYCord, visited, model,
					adjacentDistance)) {
				item.setTimeTakenInMinutes(model.getDistanceCovered());
				LocalTime localTime = item.getOrderTime();
				LocalTime deliveredTime = localTime.plusMinutes(model.getDistanceCovered());
				item.setDeliveredTime(deliveredTime);
			} else {
				currentXCord += 1;
				currentYCord += 1;
				adjacentDistance += 1;
			}
		}
	}

	/**
	 * @param array
	 * @param center
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param item
	 */
	private void traversingForAdjLeftElement(String[][] array, int center, int currentXCord, int currentYCord,
			Boolean[][] visited, Model model, Item item) {
		int adjacentDistance = 1;
		currentXCord -= 1;
		currentYCord -= 1;
		while (currentXCord > 0 && currentYCord > 0) {
			if (traverseAdjacentElements(array, center, item.getDirection(), currentXCord, currentYCord, visited, model,
					adjacentDistance)) {
				item.setTimeTakenInMinutes(model.getDistanceCovered());
				LocalTime localTime = item.getOrderTime();
				LocalTime deliveredTime = localTime.plusMinutes(model.getDistanceCovered());
				item.setDeliveredTime(deliveredTime);
			} else {
				currentXCord -= 1;
				currentYCord -= 1;
				adjacentDistance += 1;
			}
		}
	}

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param item
	 * @return
	 */
	private boolean traversingForCenterElement(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, Item item) {
		int centerDistance = 0;
		boolean flag = traverseAdjacentElements(array, center, item.getDirection(), currentXCord, currentYCord, visited,
				model, centerDistance);
		if (flag) {
			item.setTimeTakenInMinutes(model.getDistanceCovered());
			LocalTime localTime = item.getOrderTime();
			LocalTime deliveredTime = localTime.plusMinutes(model.getDistanceCovered());
			item.setDeliveredTime(deliveredTime);
		}
		return flag;
	}

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @return
	 */
	private boolean traverseAdjacentElements(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance) {
		DroneChallange challange = new DroneChallangeImpl();
		int distanceCovered = distance;
		int i = currentXCord;
		int j = currentXCord;
		boolean flag = false;

		/** Traversing for left adjacent top */
		model = challange.traverseLeftAdjacentTop(array, center, direction, currentXCord, currentYCord, visited, model,
				distance, i, j, flag, distanceCovered);

		/** Traversing for right adjacent top for current coord */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseRightAdjacentTop(array, center, direction, currentXCord, currentYCord, visited,
					model, distance, i, j, flag, distanceCovered);
		}

		/** Traversing for left adjacent bottom for current coord. */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseLeftAdjacentBottom(array, center, direction, currentXCord, currentYCord, visited,
					model, distance, i, j, flag, distanceCovered);
		}

		/** Traversing for right adjacent bottom from current coord. */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseRightAdjacentBottom(array, center, direction, currentXCord, currentYCord, visited,
					model, distance, i, j, flag, distanceCovered);
		}

		/** Traversing for top from current coord */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseForTopFromCurrent(array, center, direction, currentXCord, currentYCord, visited,
					model, distance, i, j, flag, distanceCovered);
		}

		/** Traversing for bottom from current coord */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseForBottomFromCurrent(array, center, direction, currentXCord, currentYCord,
					visited, model, distance, i, j, flag, distanceCovered);
		}

		/** Traversing for left from current coord */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseForLeftFromCurrent(array, center, direction, currentXCord, currentYCord, visited,
					model, distance, i, j, flag, distanceCovered);
		}

		/** Traversing for right from current coord */
		if (!model.isFlag()) {
			i = currentXCord;
			j = currentYCord;
			distanceCovered = distance;
			model = challange.traverseForRightFromCurrent(array, center, direction, currentXCord, currentYCord, visited,
					model, distance, i, j, flag, distanceCovered);
		}
		return model.isFlag();
	}

	/* (non-Javadoc)
	 * @see GridBlockUtility#sortOrdersPerTimeTaken(java.util.List)
	 */
	@Override
	public List<Item> sortOrdersPerTimeTaken(List<Item> items) {
		return items.stream().sorted(Comparator.comparing(Item::getTimeTakenInMinutes))
		.collect(Collectors.toList());
	}

	/* (non-Javadoc)
	 * @see GridBlockUtility#configureItems(java.util.List)
	 */
	@Override
	public List<Item> configureItems(List<String> items) {
		List<Item> itemList = new ArrayList<>();
		for (String item : items) {
			Item i = new Item();
			i.setOrderId(item.split(" ")[0]);
			String latlng = item.split(" ")[1];
			i.setDirection(latlng.split("[^A-Z0-9]+|(?<=[A-Z])(?=[0-9])|(?<=[0-9])(?=[A-Z])"));
			LocalTime time = LocalTime.parse(item.split(" ")[2]);
			i.setOrderTime(time);
			itemList.add(i);
		}
		return itemList;
	}

}
