package br.com.jogo.dotsAndBoxes;

public class Map {

    private Dot dots[][] = new Dot[6][6];
    private Line lines[][] = new Line[6][5];
    private Line horizontalLines[][] = new Line[5][6];

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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                horizontalLines[i][j] = new Line();
            }
        }
    }

    public void createMap() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].createDot(215f + (i * 70), 150f + (j * 50f), 5f);
            }
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                lines[i][j].createLine(dots[i][j].getPositionX(), dots[i][j].getPositionX(), dots[i][j].getPositionY(),
                        dots[i][j].getPositionY() + 50f);
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                horizontalLines[i][j].createLine(dots[i][j].getPositionX(), dots[i][j].getPositionX() + 70f,
                        dots[i][j].getPositionY(), dots[i][j].getPositionY());
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
                lines[i][j].renderLine();
                ;
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                horizontalLines[i][j].renderLine();
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
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                horizontalLines[i][j].disposeLine();
            }
        }
    }
}
