public class RandomNameGenerator {
    private static String[] katakana = {
            "N", "WA", "RA", "YA", "MA", "HA", "NA", "TA", "SA", "KA", "A",
            "WI", "RI", "MI", "NI", "CHI", "SHI", "KI", "I",
            "RU", "YU", "MU", "FU", "NU","TSU", "SU", "KU", "U",
            "WE", "RE", "ME", "HE", "NE", "TE", "SE", "KE", "E",
            "WO", "RO", "YO", "MO", "HO", "NO", "TO", "SO", "KO", "O"};

    public static String getRandomName(){
        int randomNumber = 3 + (int)(Math.random() * 2);
        String result = "";
        for (int i = 0; i < randomNumber; i++) {
            result += katakana[(int)(Math.random() * katakana.length)];
        }
        return result;
    }
}
