package me.ookamiiixd.main;

public class Utils {

    public static String getFileExtension(String filename) {
        int maybeExt = filename.lastIndexOf(".");
        if (maybeExt > 0 && maybeExt < filename.length() - 1) {
            return filename.substring(maybeExt + 1).toLowerCase();
        }
        return "";
    }

    public static String formatMs(long ms) {
        var seconds = ms / 1000 / 1000;
        var minutes = (seconds / 60);
        var remainingSeconds = (seconds % 60);
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}
