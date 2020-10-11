package com.bcb.conversaomoeda.api.util;

import java.time.LocalDateTime;

public class DataUtil {

	public static LocalDateTime converterStringToLocalDateTime(String data) {
		return LocalDateTime.parse(data.substring(0, 19));
	}
	
}
