import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.by/weather-minsk-4248/10-days/";
        return Jsoup.parse(new URL(url), 10000);
    }
    public static void main(String[] args) throws IOException {
        Document page = getPage();
        Element tableWeather = page.select("div[class=widget__container]").first();
        Elements names = tableWeather.select("div[class=widget__row widget__row_date]").select("div[class=widget__item]");
        Elements values = tableWeather.select(".values").select(".value");
        for(var name : names) {
            String date = name.select(".w_date").text();
            System.out.println(date);
        }
    }
}
