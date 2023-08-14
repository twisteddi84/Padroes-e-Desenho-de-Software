package lab03;
import java.util.Set;

import lab03.JGalo;
import lab03.JGaloInterface;

public class Tabuleiro implements JGaloInterface{
    public char actualChar = 'X';
    public char playerAnterior = ' ';
    public char[][] tabuleiro;
    public char resultado;
    
    public Tabuleiro(){
        char[][] tab = new char[3][3];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = ' ';
            }
        }
        this.tabuleiro = tab;
        this.actualChar = 'X';
        this.playerAnterior = ' ';
        this.resultado = ' ';
    }

    @Override
    public char getActualPlayer() {
        if (this.actualChar == 'X'){
            this.actualChar = 'O';
            this.playerAnterior = 'X';
            return 'X';
        }
        else{
            this.actualChar = 'X';
            this.playerAnterior = 'O';
            return 'O';
        }
    }
    @Override
    public boolean setJogada(int lin, int col) {
        // TODO Auto-generated method stub
        if (this.tabuleiro[lin-1][col-1] == ' '){
            this.tabuleiro[lin-1][col-1] = this.playerAnterior;
            return true;
        }
        else
            System.out.println("Jogada invalida");
            return false;
    }
    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        for(int position = 0;position<tabuleiro.length;position++){
            if(this.tabuleiro[position][0] != ' '){ //Primeira coluna
                if (this.tabuleiro[position][0] == this.tabuleiro[position][1] && this.tabuleiro[position][1]==this.tabuleiro[position][2]){//Horizontal
                    this.resultado = this.tabuleiro[position][0];
                    return true;
                }
                if(position == 2){ //Testar diagonal Direita-Cima
                    if (this.tabuleiro[position][0] == this.tabuleiro[1][1] && this.tabuleiro[1][1]==this.tabuleiro[0][2]){
                        this.resultado = this.tabuleiro[position][0];
                        return true;
                    }
                }                
            }
            if(this.tabuleiro[0][position] != ' '){ //Primeira linha
                if (this.tabuleiro[0][position] == this.tabuleiro[1][position] && this.tabuleiro[1][position]==this.tabuleiro[2][position]){//Horizontal
                    this.resultado = this.tabuleiro[0][position];
                    return true;
                }
                if(position == 0){ //Testar diagonal Direita-Baixo
                    if (this.tabuleiro[0][position] == this.tabuleiro[1][1] && this.tabuleiro[1][1]==this.tabuleiro[2][2]){
                        this.resultado = this.tabuleiro[0][position];
                        return true;
                    }
                } 
            }
        }
        if (tabuleiroCompleto()){
            return true;
        }
        return false;
    }
    @Override
    public char checkResult() {
        // TODO Auto-generated method stub

        return this.resultado;
    }

    public boolean tabuleiroCompleto(){
        for(int linha = 0;linha<tabuleiro.length;linha++){
            for(int coluna = 0;coluna<tabuleiro.length;coluna++){
                if(this.tabuleiro[linha][coluna]==' '){
                    return false;
                }
            }
        }
        return true;
    }

}
