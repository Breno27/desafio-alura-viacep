import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GeradorArquivo {
    public void geraJson(List<Endereco> enderecos) throws IOException {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        FileWriter writer = new FileWriter("enderecos.json");
        writer.write(gson.toJson(enderecos));
        writer.close();
    }
}
