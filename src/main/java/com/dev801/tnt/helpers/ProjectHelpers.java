package com.dev801.tnt.helpers;

import java.util.Date;
import java.util.Random;

public class ProjectHelpers {
	private static final Random RANDOM = new Random(new Date().getTime());

	public static final String WARBAND_PAGE = "warband";
	public static final String WARBAND_ATTRIBUTE = "warband";

	public static final String WARBANDS_PAGE = "warbands";
	public static final String WARBANDS_ATTRIBUTE = "warbands";

	public static Integer getIdHolder() {
		return Math.abs(RANDOM.nextInt()) * -1;
	}
}
