public class Game extends AudioVisual {
  

    private Categoria categoria;

    public Game(String titulo, double precoBase, Categoria categoria) {
        super(titulo, precoBase);
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    @Override
    public double calculaPrecoVenda() {
        double percentual = 0;
        switch (categoria) {
            case ACAO:
                percentual = 0.2;
                break;
            case ESPORTE:
                percentual = 0.3;
                break;
            case ESTRATEGIA:
                percentual = 0.4;
                break;
            case SIMULACAO:
                percentual = 0.5;
                break;
            case RPG:
                percentual = 0.7;
                break;
        }
        return getPrecoBase() + (getPrecoBase() * (percentual));
    }

    @Override
    public double calculaImposto() {
        return calculaPrecoVenda() * 0.5;
    }
}
