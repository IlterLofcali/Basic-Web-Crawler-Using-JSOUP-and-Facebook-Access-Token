package com.ilter.main;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * A simple example, used on the jsoup website.
 */
public class Main{
	public static void main(String[] args) throws CustomException {
		
		try{
		File input = new File("C:/Users/ilter/Documents/New_Folder/input.html");
		Document doc = Jsoup.parse(input, "UTF-8", "https://en.wikipedia.org/");

		Element content = doc.getElementById("content");
		Elements links = content.getElementsByTag("a");
		for (Element link : links) {
			String linkHref = link.attr("href");
			String linkText = link.text();
		}
		}catch (Exception ce) {
			throw new CustomException("Data çekilemedi", ce);
     }
}
}