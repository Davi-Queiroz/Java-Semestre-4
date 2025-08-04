public class LeituraInvalida extends Exception {
    public LeituraInvalida(int index, double temperatura) {

        super("Leitura inválida na posição " + index+  ": "+  temperatura);
    }
}
