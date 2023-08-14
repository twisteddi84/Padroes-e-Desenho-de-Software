package Aula1;


public class Word_Search {
    public static void main(String[] args) {
        char sopa[][] = new char [40][40];
        sopa[0][0] = 'A';
        String sopa_letras_string = "STACKJCPAXLFYLKWUGGTESTLLNJSUNCUXZPDETOFQIKICFNGSENILMJFUMRKZBUUOMSBSKCYSUMTRASARZIXRBMWWRJDAXVFJEJHQGSDRAIBACWEZOLMZOLTVIUQVRAMDGWHAGFTWPJZWUMH";
        int comprimento_string = sopa_letras_string.length();
        System.out.println(sopa_letras_string.charAt(0));
        int count = 0;
        for(int i = 0; i<=39;i++){
            for(int j = 0;j<=39;i++){
                sopa[i][j] = sopa_letras_string.charAt(count);
                count+=1;
            }
        }
    }
}
