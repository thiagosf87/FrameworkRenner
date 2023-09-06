package br.com.renner.toolbox;

import com.github.javafaker.Faker;
import io.cucumber.java.eo.Se;

import java.io.File;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.Random;

import static br.com.renner.toolbox.SetupTestRunProperties.*;
import static br.com.renner.web.interactions.CadastroInteractions.faker;

public class GlobalTools {

    static Random random = new Random();
    static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    static Faker faker = new Faker(new Locale("pt-BR"));

    public static String getExecutionNavegador() {
        String navegador = System.getProperty("navegador");
        if (navegador != null && navegador.length() > 0)
            return navegador.toLowerCase();

        return SetupTestRunProperties.getConfigNavegador().toLowerCase();
    }

    public static String getExecutionUrl() {
        String ambiente = getExecutionAmbiente();
        if (ambiente.toLowerCase().contains("hml")) {
            return getConfigUrlHml().replace("{AMBIENTE}", ambiente.toLowerCase());
        }
        return getConfigUrlPrd().toLowerCase();
    }

    public static String getExecutionUrlHml() {
        String ambiente = getExecutionAmbiente();
        if (ambiente.toLowerCase().contains("hml")) {
            return getConfigUrlHml().replace("{AMBIENTE}", ambiente.toLowerCase());
        }
        return getConfigUrlHml().replace("{AMBIENTE}", "hml01");
    }

    public static String getExecutionAmbiente() {
        String ambiente = System.getProperty("ambiente");
        if (ambiente == null || ambiente.length() == 0) {
            ambiente = getConfigAmbiente();
        }
        return ambiente.toLowerCase();
    }

    public static String removeAccents(String wordWithAccent) {
        wordWithAccent = Normalizer.normalize(wordWithAccent, Normalizer.Form.NFD);
        wordWithAccent = wordWithAccent.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        return wordWithAccent;
    }

    public static String removeSpaces(String args) {
        String result = args.replaceAll("\\s+", "");
        return result;
    }

    public static String geradorNome() {
        String nome = removeAccents(faker.name().firstName());

        // remover segundo nome
        String[] firtaName = nome.split("\\s");
        nome = firtaName[0];

        return nome;
    }

    public static String geradorSobrNome() {
        String randomSobreNome = removeSpaces(removeAccents(faker.name().lastName()));
        String lastName = randomSobreNome;

        return lastName;

    }


    public static String cpfGenerator() {
        String recurrence = "";
        int number = 10;
        int number1 = random.nextInt(number);
        int number2 = random.nextInt(number);
        int number3 = random.nextInt(number);
        int number4 = random.nextInt(number);
        int number5 = random.nextInt(number);
        int number6 = random.nextInt(number);
        int number7 = random.nextInt(number);
        int number8 = random.nextInt(number);
        int number9 = random.nextInt(number);
        int division1 = number9 * 2 + number8 * 3 + number7 * 4 + number6 * 5 + number5 * 6 + number4 * 7 + number3 * 8 + number2 * 9 + number1 * 10;

        division1 = (int) (11 - (Math.round(division1 - (Math.floor(division1 / 11) * 11))));

        if (division1 >= 10)
            division1 = 0;

        int division2 = division1 * 2 + number9 * 3 + number8 * 4 + number7 * 5 + number6 * 6 + number5 * 7 + number4 * 8 + number3 * 9 + number2 * 10 + number1 * 11;

        division2 = (int) (11 - Math.round(division2 - (Math.floor(division2 / 11) * 11)));

        if (division2 >= 10)
            division2 = 0;

        recurrence = "" + number1 + number2 + number3 + '.' + number4 + number5 + number6 + '.' + number7 + number8 + number9 + '-' + division1 + division2;

        return recurrence;
    }

    public static String birthdayGenerator(int minimumAge, int maximumAge) throws Exception {
        String birthday = String.valueOf(dateFormat.format(faker.date().birthday(minimumAge, maximumAge)));

        return birthday;
    }

}
