package ds.confectionery_client.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public final class Logging {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";


    public static String beautifulJson(String json){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(json);
        return gson.toJson(je);
    }

    public static void printObject(Object object, String message){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        System.out.println(message);
        System.out.println(ANSI_GREEN + beautifulJson(json) + ANSI_RESET);
    }

    public static void printError(Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        System.out.println(ANSI_RED + beautifulJson(json) + ANSI_RESET);
    }

    public static void unhandledError(){
        System.out.println(ANSI_RED + "unhandledError" + ANSI_RESET);
    }
}