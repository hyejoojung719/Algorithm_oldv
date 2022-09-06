package com.ssafy.saxparsing;

import java.util.List;

public class WeatherMain {
	public static void main(String[] args) {
		WeatherSaxParser parser = new WeatherSaxParser();
		
		List<Weather> list = parser.getWeather();
		
		list.stream().forEach(System.out::println);
	}
}
