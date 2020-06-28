package util;

import java.io.*;

public class ImageNoiseGenerator {

    public ImageNoiseGenerator applyNoiseTo(String sourceFile, int percentAmount) throws Exception {

        BufferedReader br = new BufferedReader( new FileReader(sourceFile) );
        BufferedWriter bw = new BufferedWriter( new FileWriter(sourceFile.replace(".txt", ".noisy." + percentAmount + ".txt")) );

        int c;

        while((c = br.read())!=-1) {
            if( Math.random() < percentAmount / 100.0 && c == ' ' ) {
                c = '@';
            }
            bw.write(c);

        }
        bw.close();
        br.close();

        return this;
    }

}