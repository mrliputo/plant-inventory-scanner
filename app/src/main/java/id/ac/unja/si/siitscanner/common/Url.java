package id.ac.unja.si.siitscanner.common;

public class Url {
    private static String domain = "http://johnsmith393939.000webhostapp.com";
    private static String speciesPath = "/species";

    public static String getUrl() {
        return domain + speciesPath + "/";
    }
}
