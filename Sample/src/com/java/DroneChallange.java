package com.java;

/**
 * @author 728332
 *
 */
public interface DroneChallange {

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseLeftAdjacentTop(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseRightAdjacentTop(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseLeftAdjacentBottom(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseRightAdjacentBottom(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseForTopFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseForBottomFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseForLeftFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);

	/**
	 * @param array
	 * @param center
	 * @param direction
	 * @param currentXCord
	 * @param currentYCord
	 * @param visited
	 * @param model
	 * @param distance
	 * @param i
	 * @param j
	 * @param flag
	 * @param distanceCovered
	 * @return
	 */
	public Model traverseForRightFromCurrent(String[][] array, int center, String[] direction, int currentXCord,
			int currentYCord, Boolean[][] visited, Model model, int distance, int i, int j, boolean flag,
			int distanceCovered);
}
