package com.bridgelabz.UserManagement.Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EditedDateFormat {

	public String editedDateFormat() {
		DateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy hh:mm aa");
		String dateString = dateFormat.format(new Date()).toString();
		return dateString;
	}
}
