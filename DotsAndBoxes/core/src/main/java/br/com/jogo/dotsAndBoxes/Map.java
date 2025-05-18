package br.com.jogo.dotsAndBoxes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;

public class Map {

    private Dot dots[][] = new Dot[6][6];
    private Line lines[][] = new Line[6][5];
    private Line horizontalLines[][] = new Line[5][6];
    private Square squares[][] = new Square[5][5];
    float mouseX, mouseY;

    private void inicializeDots() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j] = new Dot();
            }
        }
    }

    private void inicializeLines() {
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

    private void inicializeSquares() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Line top = horizontalLines[i][j];
                Line bottom = horizontalLines[i + 1][j];
                Line left = lines[j][i];
                Line right = lines[j][i + 1];

                squares[i][j] = new Square(top, bottom, left, right);
            }
        }
    }

    private void createDots() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].createDot(215f + (i * 70), 150f + (j * 50f), 5f);
            }
        }
    }

    private void createLines() {
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

    private float getMouseInputX() {
        this.mouseX = Gdx.input.getX();
        return mouseX;
    }

    private float getMouseInputY() {
        this.mouseY = Gdx.graphics.getHeight() - Gdx.input.getY();
        return mouseY;
    }

    private void linesAreHovered() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                Line line = lines[i][j];
                line.setHovered(line.getCanClick() && line.isClicked(getMouseInputX(), getMouseInputY()));
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                Line line = horizontalLines[i][j];
                line.setHovered(line.getCanClick() && line.isClicked(getMouseInputX(), getMouseInputY()));
            }
        }
    }

    private void linesGetClicked() {
        if (Gdx.input.justTouched()) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 5; j++) {
                    Line line = lines[i][j];
                    if (line.getCanClick() && line.isClicked(getMouseInputX(), getMouseInputY())) {
                        line.setCanClick(false);
                        line.setColor(Color.BLUE);
                        return;
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 6; j++) {
                    Line line = horizontalLines[i][j];
                    if (line.getCanClick() && line.isClicked(getMouseInputX(), getMouseInputY())) {
                        line.setCanClick(false);
                        line.setColor(Color.RED);
                        return;
                    }
                }
            }
        }
    }

    private void renderDots() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].renderDot();
            }
        }
    }

    private void renderLines() {
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

    private void disposeDots() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j].disposeDot();
            }
        }
    }

    private void disposeLines() {
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

    public Map() {
        inicializeDots();
        inicializeLines();
        inicializeSquares();
    }

    public void createMap() {
        createDots();
        createLines();
    }

    public void updateMap() {
        linesAreHovered();
        linesGetClicked();
    }

    public void renderMap() {
        renderLines();
        renderDots();
    }

    public void disposeMap() {
        disposeLines();
        disposeDots();
    }

}
