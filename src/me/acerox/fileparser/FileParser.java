package me.acerox.fileparser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileParser {

    private String file;
    private String content = "";
    private FileReader fileReader;
    private BufferedReader bufferedReader;

    public FileParser(String file) throws FileNotFoundException {
        this.file = file;
        open(file);
    }

    private void open(String file) throws FileNotFoundException {
        fileReader = new FileReader(file);
        bufferedReader = new BufferedReader(fileReader);
    }

    public void save() throws IOException {
        String str = bufferedReader.readLine();
        while (str != null) {
            content += content + str;
            str = bufferedReader.readLine();
        }
        bufferedReader.close();
    }

    public String getField(String field) {
        StringTokenizer stringTokenizer = new StringTokenizer(content, ";");
        String text = "";

        while (!field.equals(text)) {
            text = stringTokenizer.nextToken();
        }
        return text;
    }
}

