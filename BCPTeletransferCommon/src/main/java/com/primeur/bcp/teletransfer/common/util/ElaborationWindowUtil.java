package com.primeur.bcp.teletransfer.common.util;

import java.util.Calendar;
import java.util.Date;

import com.primeur.bcp.teletransfer.common.constant.ProductConstants;
import com.primeur.bcp.teletransfer.common.model.Product;

/**
 * ElaborationWindowUtil Class. This Class contains util methods related to
 * product elaboration window.
 * 
 * @author David Reyes
 * 
 */
public class ElaborationWindowUtil {

	/**
	 * Returns a boolean that indicates if the product is in the elaboration window.
	 * 
	 * @param 	product
	 * @return 	<code>true</code> if the product is in the elaboration window;</p>
	 * 			<code>false</code> if the product is out the elaboration window
	 */
	public static boolean isProductInElaborationWindow(Product product) {

		boolean response = false;
		
		char consolidatorState = product.getConsolidatorState();
		
		switch (consolidatorState) {
		
		case ProductConstants.ACTIVE_STATUS:
		case ProductConstants.UNACTIVE_STATUS:
			
			Date actualDate = new Date();
			Calendar actualCalendar = Calendar.getInstance();

			Date startDate = null;
			Date endDate = null;

			switch (actualCalendar.get(Calendar.DAY_OF_WEEK)) {

			case 1:
				startDate = product.getSundayStartDate();
				endDate = product.getSundayEndDate();
				break;
			case 2:
				startDate = product.getMondayStartDate();
				endDate = product.getMondayEndDate();
				break;
			case 3:
				startDate = product.getTuesdayStartDate();
				endDate = product.getTuesdayEndDate();
				break;
			case 4:
				startDate = product.getWednesdayStartDate();
				endDate = product.getWednesdayEndDate();
				break;
			case 5:
				startDate = product.getThursdayStartDate();
				endDate = product.getThursdayEndDate();
				break;
			case 6:
				startDate = product.getFridayStartDate();
				endDate = product.getFridayEndDate();
				break;
			case 7:
				startDate = product.getSaturdayStartDate();
				endDate = product.getSaturdayEndDate();
				break;
			default:
				return response;
			}

			if ((actualDate != null) && (startDate != null)	&& (endDate != null)) {

				actualCalendar = getOnlyTimeCalendar(actualDate);
				Calendar startCalendar = getOnlyTimeCalendar(startDate);
				Calendar endCalendar = getOnlyTimeCalendar(endDate);

				long actualTime = actualCalendar.getTimeInMillis();
				long startTime = startCalendar.getTimeInMillis();
				long endTime = endCalendar.getTimeInMillis();

				if ((startTime <= actualTime) && (actualTime <= endTime))
					response = true;
			}
			
			break;
			
		case ProductConstants.NOT_HAS_STATUS:
			
			response = true;
			break;
		
		default:
			
			response = false;
			break;
		}

		return response;
	}

	/**
	 * Return a Calendar from a date and sets the fields year, month, and day to 0
	 * 
	 * @param 	date
	 * @return	Calendar from a date and sets the fields year, month, and day to 0
	 */
	private static Calendar getOnlyTimeCalendar(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 0);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.YEAR, 0);

		return calendar;
	}
}
