package juego;


/**
 * Esta clase representa el juego del tres en raya, donde dos jugadores (humano y maquina) se turnan
 * para colocar sus fichas en un tablero de 3x3 casillas.
 * El objetivo del juego es conseguir que tres fichas del mismo tipo estén en linea en horizontal, vertical o diagonal.
 */
public class TresEnRaya {
    private int medidaTab=3;
    public char [][]tab;
    private char caracterSinDestapar='#';

   private int fila;
   private int columna;
    boolean gameOverJugador=false;
    boolean gameOverMaquina=false;

    /**
     * Constructor de la clase TresEnRaya que inicializa el tablero con casillas vacias.
     */
public TresEnRaya(){
    tab = new char[medidaTab][medidaTab];
    for(int i = 0; i<tab.length; i++){
        for(int j=0;j<tab[i].length;j++){
            tab[i][j]=caracterSinDestapar;
        }
    }
}
    /**
     * Metodo que representa el turno del jugador humano, donde se coloca una ficha en la posicion especificada por fila y columna.
     */
    public void turnoJugador(){

        if (tab[fila][columna] == caracterSinDestapar) {

            tab[fila][columna] = insertarCaracterJugador();
        }
        tresEnFila();
        tresEnColumna();
        tresEnDiagonal();
        tableroLleno();
        return;

    }
    /**
     * Metodo que representa el turno de la maquina, donde se coloca una ficha aleatoriamente en una casilla vacia del tablero.
     */
    public void turnoMaquina(){
        int fila;
        int columna;
        do {
            fila = (int) (Math.random() * 3);
            columna = (int) (Math.random() * 3);
        } while (tab[fila][columna] != caracterSinDestapar); // Verifica si la casilla está vacía

        tab[fila][columna] = insertarCaracterMaquina(); // Inserta el caracter de la máquina en la casilla vacía
        tresEnFila();
        tresEnColumna();
        tresEnDiagonal();
        tableroLleno();
        return;

    }
    /**
     * Metodo que devuelve el caracter a insertar para el jugador humano.
     * @return Caracter 'X' para el jugador humano.
     */
    public char insertarCaracterJugador(){
        char caracter='X';
        return caracter;
    }

    /**
     * Metodo que devuelve el caracter a insertar para la maquina.
     * @return Caracter 'O' para la maquina.
     */
    public char insertarCaracterMaquina(){
        char caracter='O';
        return caracter;
    }

    /**
     * Metodo que verifica si hay tres fichas del mismo tipo en una fila y actualiza el estado del juego en consecuencia.
     */
    public void tresEnFila() {

        if ((tab[0][0] == 'X' && tab[0][1] == 'X' && tab[0][2] == 'X') ||
                (tab[1][0] == 'X' && tab[1][1] == 'X' && tab[1][2] == 'X') ||
                (tab[2][0] == 'X' && tab[2][1] == 'X' && tab[2][2] == 'X')) {
            gameOverJugador = true;
        }

        if ((tab[0][0] == 'O' && tab[0][1] == 'O' && tab[0][2] == 'O') ||
                ( tab[1][0] == 'O' && tab[1][1] == 'O' && tab[1][2] == 'O') ||
                (tab[2][0] == 'O' && tab[2][1] == 'O' && tab[2][2] == 'O')) {
            gameOverMaquina = true;
        }

    }

    /**
     * Metodo que verifica si hay tres fichas del mismo tipo en una columna y actualiza el estado del juego en consecuencia.
     */
    public void tresEnColumna(){
        if ((tab[0][0] == 'X' && tab[1][0] == 'X' && tab[2][0] == 'X')||
                (tab[0][1] == 'X' && tab[1][1] == 'X' && tab[2][1] == 'X')||
                (tab[0][2] == 'X' && tab[1][2] == 'X' && tab[2][2] == 'X')){
            gameOverJugador = true;
        }

        if ((tab[0][0] == 'O' && tab[1][0] == 'O' && tab[2][0] == 'O')||
                ( tab[0][1] == 'O' && tab[1][1] == 'O' && tab[2][1] == 'O')||
                (tab[0][2] == 'O' && tab[1][2] == 'O' && tab[2][2] == 'O')){
            gameOverMaquina = true;
        }
    }

    /**
     * Metodo que verifica si hay tres fichas del mismo tipo en una diagonal y actualiza el estado del juego en consecuencia.
     */
    public void tresEnDiagonal(){
        if ((tab[0][0] == 'X' && tab[1][1] == 'X' && tab[2][2] == 'X') ||
                (tab[0][2] == 'X' && tab[1][1] == 'X' && tab[2][0] == 'X')) {
            gameOverJugador = true;

        }
        if ((tab[0][0] == 'O' && tab[1][1] == 'O' && tab[2][2] == 'O') ||
                (tab[0][2] == 'O' && tab[1][1] == 'O' && tab[2][0] == 'O')) {
            gameOverMaquina = true;

        }
    }
    /**
     * Metodo que verifica si el tablero esta lleno, es decir, si no quedan casillas vacías.
     * @return True si el tablero esta lleno, False si aun quedan casillas vacias.
     */
    public boolean tableroLleno() {
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                if (tab[i][j] == caracterSinDestapar) {
                  return false;
                }
            }
        }
        return true;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getMedidaTab() {
        return medidaTab;
    }

    public void setMedidaTab(int medidaTab) {
        this.medidaTab = medidaTab;
    }

    public char[][] getTab() {
        return tab;
    }

    public void setTab(char[][] tab) {
        this.tab = tab;
    }
}
