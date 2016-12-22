package com.dev801.tnt.helpers;

import java.util.Date;
import java.util.Random;

public class ProjectHelpers {
	private static final Random RANDOM = new Random(new Date().getTime());

	public static Integer getIdHolder() {
		return Math.abs(RANDOM.nextInt()) * -1;
	}
}
