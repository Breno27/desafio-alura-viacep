import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String busca = "";
        List<Endereco> enderecos = new ArrayList<>();
        ConsultaCep consultaCep = new ConsultaCep();
        GeradorArquivo geradorArquivo = new GeradorArquivo();

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um cep para busca: \n-caso deseje encerrar digite \"sair\" ");
            busca = scan.nextLine();

            if (busca.equalsIgnoreCase("sair")) {
                break;
            }

            try {
                enderecos.add(consultaCep.buscaEndereco(busca));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (JsonSyntaxException e) {
                System.out.println("Digite o CEP no formato: 01001000");
            }
            geradorArquivo.geraJson(enderecos);
        }

        System.out.println("Seu arquivo .json com os endereços está pronto!");
    }
}