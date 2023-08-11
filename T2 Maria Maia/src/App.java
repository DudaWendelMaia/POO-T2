import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private List<AudioVisual> audiovisuais;
    private Scanner entrada; // Atributo para entrada de dados
    private ArrayList<String> dados;
    private int numAudioVisuais = -1;

    public App() {
        audiovisuais = new ArrayList<>();
        try {
            String linha;
            BufferedReader streamEntrada = new BufferedReader(new FileReader("dados.csv"));
            entrada = new Scanner(streamEntrada); // Usa como entrada um arquivo

            PrintStream streamSaida = new PrintStream(new File("resultado.csv"));
            System.setOut(streamSaida); // Usa como saida um arquivo

            dados = new ArrayList<>();

            while ((linha = streamEntrada.readLine()) != null) {
                dados.add(linha);
                numAudioVisuais++;

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
       // entrada.useLocale(Locale.ENGLISH);
       Locale.setDefault(Locale.US);
       entrada.close();

    }

    public void executa() {

        try {
            lerAudiovisuais(); // 1
            escreverInformacoesItens(); // 2
            escreverQtdGamesRPG(); // 3
            escreverBlueRayImposto(); // 4

        } catch (Exception e) {

            System.out.println("Erro ao ler/escrever arquivo: " + e.getMessage());

        }
    }

    // 1
    public void lerAudiovisuais() {
        for (int i = 1; i < dados.size(); i++) {
            try {
                String[] linha = dados.get(i).split(";");

                if(linha.length!=4){
                    numAudioVisuais--;
                    continue;
                }
                if(linha[3].equals("INVALIDO")){
                    numAudioVisuais--;
                    continue;
                }
                if (linha[2].equals("1")) {
                    audiovisuais.add(new BlueRay(linha[0], Double.parseDouble(linha[1]), Integer.parseInt(linha[3])));
                } else if (linha[2].equals("2")) {
                    audiovisuais.add(new Game(linha[0], Double.parseDouble(linha[1]), Categoria.valueOf(linha[3])));
                }else{
                    numAudioVisuais--;
                    continue;
                }
                
            } catch (Exception e) {
                System.err.println("Número não reconhecido");
            }

        }

        System.out.println("1;" + numAudioVisuais);
    }

    // 2
    public void escreverInformacoesItens() throws Exception {
        if (audiovisuais.size() == 0)
            throw new Exception("Linha vazia");
        for (AudioVisual av : audiovisuais) {
            double precoVenda = av.calculaPrecoVenda();
            double imposto = av.calculaImposto();
            System.out.printf("2;%s;%.2f;%.2f \n", av.getTitulo(), precoVenda, imposto);

        }

    }

    // 3
    public void escreverQtdGamesRPG() {
        int qtdGames = 0;

        for (AudioVisual av : audiovisuais) {
            if (av instanceof Game) {
                Game game = (Game) av;

                if (game.getCategoria() == Categoria.RPG) {
                    qtdGames++;
                }
            }
        }
        System.out.println("3;" + qtdGames);
    }

    // 4
    public void escreverBlueRayImposto() throws Exception {
        double imposto = 0;
        int ray = 0;
        Double blueRayMaisPerto = 0.0;
        BlueRay maisProximo = null;
        for (AudioVisual av : audiovisuais) {
            if (av instanceof BlueRay) {
                BlueRay blueRay = (BlueRay) av;
                imposto += blueRay.calculaImposto();
                ray++;
            }
        }
        if (imposto == 0)
            System.out.println("4:Nenhum BlueRay");
        else{
            imposto = imposto / ray;

        for (AudioVisual audioVisual : audiovisuais) {
            if (audioVisual instanceof BlueRay) {
                if (maisProximo == null) {
                    maisProximo = (BlueRay) audioVisual;
                    blueRayMaisPerto = Math.abs(maisProximo.calculaImposto() - imposto);
                } else {
                    if (Math.abs(audioVisual.calculaImposto() - imposto) < blueRayMaisPerto) {
                        maisProximo = (BlueRay) audioVisual;
                        blueRayMaisPerto = Math.abs(maisProximo.calculaImposto() - imposto);
                    }
                }
                
            }
        }
        System.out.printf("4;%.2f;%s\n ",imposto,maisProximo.getTitulo());
        }
        
    }
}

