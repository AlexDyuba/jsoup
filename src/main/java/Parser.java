import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;

public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://www.gismeteo.by/weather-minsk-4248/10-days/";
        return Jsoup.parse(new URL(url), 10000);
    }

    public static Collection<String> getDate() throws IOException {
        Document page = getPage();
        Collection<String> listName = new ArrayList<>();
        Element tableWeather = page.select("div[class=widget__container]").first();
        Elements names = tableWeather.select("div[class=widget__row widget__row_date]").select("div[class=widget__item]");
        for (var name : names) {
            listName.add(name.text());
        }
        return listName;
    }

    public static Collection<String> getPhenomenon() throws IOException {
        Document page = getPage();
        Collection<String> listPhenomenon = new ArrayList<>();
        Element tablePhenomenon = page.getElementsByClass
                ("widget__row widget__row_table widget__row_icon").first();
        Elements phenomenon = tablePhenomenon.getElementsByClass("tooltip");
        for (var p : phenomenon) {
            listPhenomenon.add(p.attr("data-text"));
        }
        return listPhenomenon;
    }

    public static Collection<String> getTemperature() throws IOException {
        Document page = getPage();
        Collection<String> listTemperature = new ArrayList<>();
        Element tableTemperature = page.getElementsByClass
                ("widget__row widget__row_table widget__row_temperature").first();
        Elements temperature = tableTemperature.getElementsByClass("unit unit_temperature_c");
        for (var t : temperature) {
            listTemperature.add(t.text());
        }
        return listTemperature;
    }

    public static Collection<String> getSpeedWind() throws IOException {
        Document page = getPage();
        Collection<String> listSpeedWind = new ArrayList<>();
        Element tableSpeedWind = page.getElementsByClass
                ("widget__row widget__row_table widget__row_wind-or-gust").first();
        Elements speedWind = tableSpeedWind.getElementsByClass("unit unit_wind_m_s");
        for (var s : speedWind) {
            listSpeedWind.add(s.text());
        }
        return listSpeedWind;
    }

    public static Collection<String> getPrecipitation() throws IOException {
        Document page = getPage();
        Collection<String> listPrecipitation = new ArrayList<>();
        Element tablePrecipitation = page.getElementsByClass
                ("widget__row widget__row_table widget__row_precipitation").first();
        Elements precipitation = tablePrecipitation.getElementsByClass("w_prec__value");
        for (var p : precipitation) {
            listPrecipitation.add(p.text());
        }
        return listPrecipitation;
    }

    public static Collection<String> getPressure() throws IOException {
        Document page = getPage();
        Collection<String> listPressure = new ArrayList<>();
        Element tablePressure = page.getElementsByClass("widget__row widget__row_pressure").first();
        Elements pressure = tablePressure.select("div[class=maxt]").select("span[class=unit unit_pressure_mm_hg_atm]");
        for (var p : pressure) {
            listPressure.add(p.text());
        }
        return listPressure;
    }
}
