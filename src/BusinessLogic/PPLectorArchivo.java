package BusinessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PPLectorArchivo {
    
    public static List<String>  ppReadFile() throws Exception {
        // Declaración de BufferedReader para leer el archivo
        BufferedReader reader = null;
        List<String> lectura=new ArrayList<>();
        

        try {
            // Se instancia un objeto FileReader para leer el archivo
            File file = new File("setAlimento.txt");
            reader = new BufferedReader(new FileReader(file));

            // Lectura línea por línea del archivo
            String line;
            while ((line = reader.readLine()) != null) {
                lectura.add(line);
            }
            return lectura;
        } catch (IOException e) {
            // En caso de error, se imprime el mensaje de error
            e.printStackTrace();
        } finally {
            try {
                // Se cierra el BufferedReader
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lectura;
    }
}
