package d0329;

/**
 * Created by Administrator on 2017/3/29.
 */
public class WorldCup {
    private int year;
    private String winCountry;
    private String period;

    public WorldCup() {
    }

    public WorldCup(int year, String country, String number) {
        this.year = year;
        this.winCountry = country;
        this.period = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getWinCountry() {
        return winCountry;
    }

    public void setWinCountry(String winCountry) {
        this.winCountry = winCountry;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "【" + year + "年，" + period + "世界杯，" + "冠军" + winCountry + "】";
    }
}
