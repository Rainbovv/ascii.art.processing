package util;

import java.io.*;

public class ImageComparator {
    public int compareTwo(String sourceFile, String modifiedFile) throws Exception {

        BufferedReader br = new BufferedReader( new FileReader(sourceFile));
        BufferedReader brModified = new BufferedReader( new FileReader(modifiedFile));

        int c;
        int cModified;
        int result = 0;

        while ((c = br.read())!=-1) {
            cModified = brModified.read();
            if (c != cModified) result++;
        }
        return result;
    }
}