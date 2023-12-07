package be.kdg.model;

import java.time.LocalDate;
import java.util.Random;

/**
 * Vincent Verboven
 * 23/11/2023
 */
public class MesFactory {

    private static Random rng = new Random();
    private static final char[] KLINKERS = {'a','e','i','o','u'};
    private static final char[] MEDEKLINKERS = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

    private MesFactory(){
    }

    public static Mes newEmptyMes(){
        return new Mes();
    }

    public static Mes newFilledMes(String type, LocalDate productieDag, double lengte, int hardheid, String materiaal, Lemmet lemmet){
        return new Mes(type, productieDag, lengte, hardheid, materiaal, lemmet);
    }

    public static Mes newRandomMes(){
        String type = generateString(15, 1, false);
        LocalDate productieDag = LocalDate.of(
                rng.nextInt(2000,2023),
                rng.nextInt(1,13),
                rng.nextInt(1,28));
        double lengte  = rng.nextDouble(15,25);
        int hardheid = rng.nextInt(50,71);
        String materiaal = generateString(15, 4, false);
        Lemmet lemmet = Lemmet.values()[rng.nextInt(0,Lemmet.values().length)];
        return new Mes(type, productieDag, lengte, hardheid, materiaal, lemmet);
    }

    private static String generateString(int maxWordLength, int wordCount, boolean camelCase){
        StringBuilder string = new StringBuilder();
        for(int i = 0; i < wordCount; i++){
            int wordLength = rng.nextInt(1,maxWordLength+1);
            string.append(generateWord(wordLength, camelCase)).append(" ");
        }
        return string.toString();
    }

    private static String generateWord(int wordLength, boolean camelCase){
        StringBuilder wordBuilder = new StringBuilder();
        while(wordBuilder.length() != wordLength){
            switch(rng.nextInt(0,3)){
                case 0:  wordBuilder.append(KLINKERS[rng.nextInt(0, KLINKERS.length)]); break;
                case 1, 2: wordBuilder.append(MEDEKLINKERS[rng.nextInt(0, MEDEKLINKERS.length)]); break;
            }
        }
        if(!camelCase){
            wordBuilder.replace(0,1,wordBuilder.substring(0,1).toUpperCase());
        }
        return wordBuilder.toString();
    }

}
