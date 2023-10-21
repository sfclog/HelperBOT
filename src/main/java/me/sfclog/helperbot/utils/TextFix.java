package me.sfclog.helperbot.utils;

public class TextFix {


    public static String fix(String msg) {
        String[] words = msg.split("\\s+");

        String output = "";
        for (String word : words) {
            if (word.contains("\n")) {
                String[] lines = word.split("\n");
                for (String line : lines) {
                    output += " " + line + "\n";
                }
            } else {
                output += " " + word;
            }
        }

       return output.trim();
    }
}
