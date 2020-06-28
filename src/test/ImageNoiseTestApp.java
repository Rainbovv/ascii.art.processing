package test;

import util.*;

public class ImageNoiseTestApp {

    static String javaLogo = "tests/data/java-logo.txt";
    static String eclipseLogo = "tests/data/eclipse-logo.txt";

    public static void main(String[] args) throws Exception {

        testsSetup();

        testNoiseReduction();

    }

    public static void testsSetup() throws Exception {
        header("SETTING UP TESTS");
        new ImageNoiseGenerator()
                .applyNoiseTo(javaLogo, 25)
                .applyNoiseTo(javaLogo, 50)
                .applyNoiseTo(javaLogo, 75)
                .applyNoiseTo(eclipseLogo, 25)
                .applyNoiseTo(eclipseLogo, 50)
                .applyNoiseTo(eclipseLogo, 75);

    }

    public static void testNoiseReduction() throws Exception {

        ImageComparator imageComparator = new ImageComparator();

        header("TESTS RUNNING");
        new ImageNoiseFilter()
                .removeNoiseFrom("tests/data/java-logo.noisy.25.txt")
                .removeNoiseFrom("tests/data/java-logo.noisy.50.txt")
                .removeNoiseFrom("tests/data/java-logo.noisy.75.txt")
                .removeNoiseFrom("tests/data/eclipse-logo.noisy.25.txt")
                .removeNoiseFrom("tests/data/eclipse-logo.noisy.50.txt")
                .removeNoiseFrom("tests/data/eclipse-logo.noisy.75.txt");


        if (  imageComparator.compareTwo(javaLogo, "tests/data/java-logo.noisy.25.clean.txt")
            + imageComparator.compareTwo(javaLogo, "tests/data/java-logo.noisy.50.clean.txt")
            + imageComparator.compareTwo(javaLogo, "tests/data/java-logo.noisy.75.clean.txt")

            + imageComparator.compareTwo(eclipseLogo, "tests/data/eclipse-logo.noisy.25.clean.txt")
            + imageComparator.compareTwo(eclipseLogo, "tests/data/eclipse-logo.noisy.50.clean.txt")
            + imageComparator.compareTwo(eclipseLogo, "tests/data/eclipse-logo.noisy.75.clean.txt")
            == 0 ) {

            System.out.println("TEST SUCCEEDED!");

        } else {
            System.err.println("TEST FAILED");
        }
    }


    public static void header(String message) {
        System.out.println("########################################");
        System.out.println(message);
        System.out.println("########################################");
    }

}