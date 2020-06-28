package util;

import java.io.*;

public class ImageNoiseFilter {

    public ImageNoiseFilter removeNoiseFrom(String sourceFile) throws Exception {

        BufferedReader br = new BufferedReader( new FileReader(sourceFile) );
        BufferedWriter bw = new BufferedWriter( new FileWriter(sourceFile.replace(".txt", ".clean.txt")));

        int c;

        while ((c = br.read())!=-1) {
            if (c == '@') c = ' ';
<<<<<<< HEAD
            
=======

>>>>>>> refs/remotes/origin/lessCode
            bw.write(c);
        }

        br.close();
        bw.close();

        return this;
    }
}
