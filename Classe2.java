public class Classe2 {
    public static int calcularSoma(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public static String[] mostrarOpcoes() {
        return Classe3.pegarOpcoes();
    }

    public static String resultado(float fltInputUsuario1,float fltInputUsuario2,int opcaoEscolhida){

        return Classe3.processarDados(fltInputUsuario1,fltInputUsuario2,opcaoEscolhida);

    }
}
