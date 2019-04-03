package com.java;
import static java.time.temporal.ChronoUnit.HOURS;

import java.time.LocalTime;
import java.util.List;

/**
 * @author 728332
 *
 */
public class NpsScoreCalculatorImpl implements NpsScoreCalculator {

	/* (non-Javadoc)
	 * @see NpsScoreCalculator#findNpsScore(java.util.List)
	 */
	@Override
	public int findNpsScore(List<Item> orderedItems) {
		int promotors = 0;
		int detractors = 0;
		int neutral = 0;
		int nps = 0;
		for (Item item : orderedItems) {
			LocalTime l1 = item.getOrderTime();
			LocalTime l2 = item.getDeliveredTime();
			if (item.getTimeTakenInMinutes() > 59) {
				long hours = l1.until(l2, HOURS);
				if (hours <= 1) {
					promotors += 1;
				} else if (hours <= 3) {
					neutral += 1;
				} else {
					detractors += 1;
				}
			} else {
				promotors += 1;
			}
		}

		nps = (promotors * 100) / orderedItems.size() - (detractors * 100) / orderedItems.size();
		return nps;
	}
	

}
