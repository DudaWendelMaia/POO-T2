public abstract class AudioVisual implements Cobravel {
    private String titulo;
    private double precoBase;

    public AudioVisual(String titulo, double precoBase) {
        this.titulo = titulo;
        this.precoBase = precoBase;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    @Override
    public double calculaPrecoVenda() {
        return 0.00; //precoCusto * (1 + taxaImposto);
    }

    @Override
    public double calculaImposto() {
        return 0.00;
    }
}