import java.io.IOException;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws IOException {
        List<String> dates = (List<String>) Parser.getDate();
        List<String> phenomenon = (List<String>) Parser.getPhenomenon();
        List<String> temperature = (List<String>) Parser.getTemperature();
        List<String> speedWind = (List<String>) Parser.getSpeedWind();
        List<String> precipitation = (List<String>) Parser.getPrecipitation();
        List<String> pressure = (List<String>) Parser.getPressure();
        String nameMonth = dates.get(0).split(" ")[2];
        for (int i = 1; i < dates.size(); i++) {
            dates.set(i, dates.get(i) + " " + nameMonth);
        }
        for (int i = 0; i < dates.size(); i++) {
            System.out.printf("День: %s.\n", dates.get(i));
            System.out.printf("Погодные явления: %s.\n", phenomenon.get(i));
            System.out.printf("Температура: %sС.\n", temperature.get(i));
            System.out.printf("Максимальная скорость ветра: %s м/с.\n", speedWind.get(i));
            System.out.printf("Осадки мм: %s.\n", precipitation.get(i));
            System.out.printf("Давление: %s.\n\n", pressure.get(i));
        }
    }
}
