package com.n26.stats.transaction.annotation;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeRangeValidator {

	public boolean isValid(Long arg0) {

		long diffInMili = new Date().getTime() - arg0;

		if ((diffInMili / 1000) > 60) {
			return false;
		}
		return true;
	}

}
