package br.com.jogo.dotsAndBoxes;

public class Map {

    private Dot dots[][] = new Dot[6][6];
    private Line lines[][] = new Line[6][5];

    public Map() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j] = new Dot();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                lines[i][j] = new Line();
            }
        }
    }
    
    public void createMap(){
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].createDot((i* 10f), (j* 10f), 2.5f);
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                lines[i][j].createLine((i*10f), (j*10f), (i*20f), (j*20f));
            }
        }

    }

    public void renderMap() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].renderDot();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                lines[i][j].renderLine();;
            }
        }
    }



    public void disposeMap() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].disposeDot();
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                lines[i][j].disposeLine();
            }
        }
    }
}
