package com.ssafy.saxparsing;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSaxParser extends DefaultHandler{

	// 날씨 데이터 담을 리스트
	private List<Weather> list = new ArrayList<>();

	Weather weather; // <data> 태그 내의 데이터를 담기위한 객체의 참조변수

	String content; 	// 중간 데이터를 저장하기 위한 문자열
	
	// 날씨 데이터 리스트 반환 메소드
	public List<Weather> getWeather() {
		
		try {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		SAXParser parser = factory.newSAXParser();
		parser.parse("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=3020053000", this);
		}catch(SAXException | IOException e) {
			e.printStackTrace();
		}catch(ParserConfigurationException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 시작 태그를 만날 때 호출되는 메소드
	@Override
	public void startElement (String uri, String localName,
			String qName, Attributes attributes)
					throws SAXException
	{
		// 태그이름 : qName
		// <data> 태그를 만나면 데이터 담을 객체 생성
		if(qName.equals("data")) {
			weather = new Weather();
			list.add(weather);
		}
	}

	// 시작 태그와 중간 태그 중간에 데이터를 저장하기 위한 메소드
	// 실행 시점 : 닫는 태그를 만났을 때
	// 중간에 있는 데이터를 일단 저장을 한다!
	public void characters (char ch[], int start, int length)
			throws SAXException
	{
		content = new String(ch, start, length);
	}

	// 닫는 태그 끝날 때 호출되는 메소드
	public void endElement (String uri, String localName, String qName)
			throws SAXException
	{
		// 해당 태그 만날 시 weather 객체에 담기
		switch(qName) {
		case "hour":
			weather.setHour(content);
			break;
		case "temp":
			weather.setTemp(content);
			break;
		case "wfKor":
			weather.setWfKor(content);
			break;
		case "reh":
			weather.setReh(content);
			break;
		// 객체 완성된 후 list에 담기 or 이 방식 말고 완성되기전에 만들자마자 담아도 됨 (startelement쪽...)
		/*case "data":
			list.add(weather);
			break;*/
		default:
			break;
		}
	}



}
