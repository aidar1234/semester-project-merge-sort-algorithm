package benchmarking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InputDataCreator {
    public static void main(String[] args) throws IOException {
        createData();
    }

    static void createData() throws IOException {
        Random random = new Random();

        for (int i = 1000; i <= 100_000; i += 1000) {

            for (int j = 0; j < 10; j++) {
                File file = new File("src/benchmarking/data/" + i + "_" + j + ".txt");
                FileWriter writer = new FileWriter(file);

                for (int k = 0; k < i; k++) {
                    int rand = random.nextInt();
                    writer.write(rand + "\n");
                }

                writer.flush();
                writer.close();
            }
        }
    }
}
