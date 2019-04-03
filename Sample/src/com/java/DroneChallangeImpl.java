package com.java;

/**
 * @author 728332
 *
 */
public class DroneChallangeImpl implements DroneChallange {

	/* (non-Javadoc)
	 * @see DroneChallange#traverseLeftAdjacentTop(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseLeftAdjacentTop(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (i > 0 && j > 0) {
			if (!visited[i - 1][j - 1]) {
				if (array[i - 1][j - 1].indexOf(direction[0] + direction[1]) > -1
						&& array[i - 1][j - 1].indexOf(direction[2] + direction[3]) > -1) {
					distanceCovered += 1;
					model.setxCord(i - 1);
					model.setyCord(j - 1);
					flag = true;
					break;
				}
			}
			distanceCovered += 1;
			visited[i - 1][j - 1] = true;
			i -= 1;
			j -= 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseRightAdjacentTop(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseRightAdjacentTop(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (i > 0 && j < array.length - 1) {
			if (!visited[i - 1][j + 1]) {
				if (array[i - 1][j + 1].indexOf(direction[0] + direction[1]) > -1
						&& array[i - 1][j + 1].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i - 1);
					model.setyCord(j + 1);
					distanceCovered += 1;
					flag = true;
					break;
				}
			}
			visited[i - 1][j + 1] = true;
			distanceCovered += 1;
			i -= 1;
			j += 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseLeftAdjacentBottom(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseLeftAdjacentBottom(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (j > 0 && i < array.length - 1) {
			if (!visited[i + 1][j - 1]) {
				if (array[i + 1][j - 1].indexOf(direction[0] + direction[1]) > -1
						&& array[i + 1][j - 1].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i + 1);
					model.setyCord(j - 1);
					distanceCovered += 1;
					flag = true;
					break;
				}
			}
			visited[i + 1][j - 1] = true;
			distanceCovered += 1;
			i += 1;
			j -= 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseRightAdjacentBottom(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseRightAdjacentBottom(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (i < array.length - 1 && j < array.length - 1) {
			if (!visited[i + 1][j + 1]) {
				if (array[i + 1][j + 1].indexOf(direction[0] + direction[1]) > -1
						&& array[i + 1][j + 1].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i + 1);
					model.setyCord(j + 1);
					visited[i + 1][j + 1] = true;
					distanceCovered += 1;
					flag = true;
					break;
				}
			}
			distanceCovered += 1;
			visited[i + 1][j + 1] = true;
			i += 1;
			j += 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseForTopFromCurrent(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseForTopFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (i > 0) {
			if (!visited[i - 1][j]) {
				if (array[i - 1][j].indexOf(direction[0] + direction[1]) > -1
						&& array[i - 1][j].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i - 1);
					model.setyCord(j);
					distanceCovered += 1;
					visited[i - 1][j] = true;
					flag = true;
					break;
				}
			}
			distanceCovered += 1;
			visited[i - 1][j] = true;
			i -= 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseForBottomFromCurrent(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseForBottomFromCurrent(String[][] array, int center, String[] direction,
			int currentXCord, int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j,
			boolean flag, int distanceCovered) {
		while (i < array.length - 1) {
			if (!visited[i + 1][j]) {
				if (array[i + 1][j].indexOf(direction[0] + direction[1]) > -1
						&& array[i + 1][j].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i + 1);
					model.setyCord(j);
					visited[i + 1][j] = true;
					distanceCovered += 1;
					flag = true;
					break;
				}
			}
			distanceCovered += 1;
			visited[i + 1][j] = true;
			i += 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseForLeftFromCurrent(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseForLeftFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (j > 0) {
			if (!visited[i][j - 1]) {
				if (array[i][j - 1].indexOf(direction[0] + direction[1]) > -1
						&& array[i][j - 1].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i);
					model.setyCord(j - 1);
					visited[i][j - 1] = true;
					distanceCovered += 1;
					flag = true;
					break;
				}
			}
			distanceCovered += 1;
			visited[i][j - 1] = true;
			j -= 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}

	/* (non-Javadoc)
	 * @see DroneChallange#traverseForRightFromCurrent(java.lang.String[][], int, java.lang.String[], int, int, java.lang.Boolean[][], Model, int, int, int, boolean, int)
	 */
	@Override
	public Model traverseForRightFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered) {
		while (j < array.length - 1) {
			if (!visited[i][j + 1]) {
				if (array[i][j + 1].indexOf(direction[0] + direction[1]) > -1
						&& array[i][j + 1].indexOf(direction[2] + direction[3]) > -1) {
					model.setxCord(i);
					model.setyCord(j + 1);
					visited[i][j + 1] = true;
					distanceCovered += 1;
					flag = true;
					break;
				}
			}
			distanceCovered += 1;
			visited[i][j + 1] = true;
			j += 1;
		}
		if (flag) {
			model.setFlag(flag);
			model.setDistanceCovered(distanceCovered);
		} else {
			model.setFlag(flag);
			model.setDistanceCovered(0);
		}
		return model;
	}
}
