package juego;
import java.util.Scanner;

public class InterfaceJuego {
   Scanner sc=new Scanner(System.in);
    TresEnRaya ter=new TresEnRaya();

    public static void main(String[]args){
        InterfaceJuego juego=new InterfaceJuego();
        juego.jugar();
    }
    public void jugar(){
        instruccionesJuego();
        System.out.println("¿Quiere empezar el juego? S/N");
        char respuesta=sc.next().charAt(0);
        if(respuesta=='S' || respuesta=='s'){
            while(!ter.gameOverJugador && !ter.gameOverMaquina && !ter.tableroLleno()) {
                System.out.println("Turno del jugador");
                System.out.println("Indica la coordenada a rellenar");
                ter.setFila(sc.nextInt());
                ter.setColumna(sc.nextInt());
                ter.turnoJugador();
                dibujarTablero();
                if (ter.gameOverJugador || ter.gameOverMaquina || ter.tableroLleno()) {
                    break;
                }
                System.out.println("Turno de la máquina");
                ter.turnoMaquina();
                dibujarTablero();

            }
            if(ter.gameOverMaquina){
                ganaMaquina();
            }else if(ter.gameOverJugador){
                ganaJugador();
            }else {
             empate();
            }
        }else{
            System.out.println("Hasta pronto!");
            System.exit(0);
        }
    }
    public void dibujarTablero(){

        for(int i=0;i<7;i++){
            switch (i){
                case 0,2,4,6:
                    System.out.println("-------------");
                    break;
                case 1:
                    System.out.println("| "+ter.tab[0][0]+"\t| "+ter.tab[0][1]+"\t| "+ter.tab[0][2]+"\t|");
                    break;
                case 3:
                    System.out.println("| "+ter.tab[1][0]+"\t| "+ter.tab[1][1]+"\t| "+ter.tab[1][2]+"\t|");
                    break;
                case 5:
                    System.out.println("| "+ter.tab[2][0]+"\t| "+ter.tab[2][1]+"\t| "+ter.tab[2][2]+"\t|");
                    break;
                default:
                 System.out.println("Error");

            }
        }

    }

    public void instruccionesJuego(){
        System.out.println("- El objetivo del tres en raya es ser el primer jugador en colocar " +
                "tres de sus fichas en línea en el tablero, ya sea en horizontal, vertical o diagonal..");
        System.out.println("- El juego se juega en un tablero de 3x3 casillas.");
        System.out.println("- Un jugador será designado como \"X\" y la máquina como \"O\"");
        System.out.println("- El jugador empeiza primero ");
        System.out.println("- El jugador \"X\" comienza seleccionando una casilla vacía en el tablero.\n" +
                "Debe especificar la fila y columna donde desea colocar su ficha.\n" +
                "Por ejemplo, si el jugador \"X\" desea colocar su ficha en la primera fila " +
                "y la segunda columna, dirá \"Fila 1, Columna 2\".");
        System.out.println("- Si estás jugando contra la máquina, después de que el jugador \"X\" haya colocado su ficha, " +
                "la máquina seleccionará una casilla vacía aleatoriamente para colocar su ficha");
        System.out.println("- Después de cada turno, se verificará si alguno de los jugadores ha colocado tres de sus fichas en línea.");
        System.out.println("- Si un jugador logra tener tres fichas en línea, ese jugador será declarado como ganador " +
                "y el juego terminará");
        System.out.println("- Si el tablero se llena sin que ninguno de los jugadores haya logrado formar una línea " +
                " con sus fichas, el juego terminará en empate.");
        System.out.println("- El juego terminará cuando uno de los jugadores gane o cuando haya un empate.");
    }
    public void ganaJugador(){
        System.out.println("El jugador ha ganado!!! ");
        System.exit(0);
    }

    public void ganaMaquina(){
        System.out.println("Los máquinas han ganado!!! ");
        System.exit(0);
    }

    public void empate(){
        System.out.println("Todos ganamos!!! ");
        System.exit(0);
    }
}
