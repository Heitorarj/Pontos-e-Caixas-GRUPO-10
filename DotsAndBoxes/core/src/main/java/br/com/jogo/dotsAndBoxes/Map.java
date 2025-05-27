package br.com.jogo.dotsAndBoxes;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Map {

    private Dot dots[][] = new Dot[6][6];
    private Line lines[][] = new Line[6][6];
    private Line horizontalLines[][] = new Line[6][6];
    private Square squares[][] = new Square[5][5];
    private ShapeRenderer shape = new ShapeRenderer();
    private float mouseX, mouseY;
    private Player humanPlayer = new Player(1, 0, true);
    private Player computerPlayer = new Player(2, 0, false);

    private void inicializeDots() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                dots[i][j] = new Dot();
            }
        }
    }

    private void inicializeLines() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                lines[i][j] = new Line();
                horizontalLines[i][j] = new Line();
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
                        dots[i][j + 1].getPositionY());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                horizontalLines[i][j].createLine(dots[i][j].getPositionX(), dots[i + 1][j].getPositionX(),
                        dots[i][j].getPositionY(), dots[i][j].getPositionY());
            }
        }
    }

    private void createSquares() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                // Linhas horizontais (top e bottom)
                Line top = horizontalLines[i][j + 1]; // Linha acima do quadrado
                Line bottom = horizontalLines[i][j]; // Linha abaixo do quadrado

                // Linhas verticais (left e right)
                Line left = lines[i][j]; // Linha à esquerda do quadrado
                Line right = lines[i + 1][j]; // Linha à direita do quadrado

                squares[i][j] = new Square(top, bottom, left, right);
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

    private void verifyLines() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                Line vertical = lines[i][j];
                if (vertical.getCanClick() && vertical.isClicked(getMouseInputX(), getMouseInputY())) {
                    vertical.setCanClick(false);
                    vertical.setClicked(true);
                    vertical.setColor(Color.BLUE);
                    humanPlayer.setCanPlay(false);
                    computerPlayer.setCanPlay(true);
                    return;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                Line horizontal = horizontalLines[i][j];
                if (horizontal.getCanClick() && horizontal.isClicked(getMouseInputX(), getMouseInputY())) {
                    horizontal.setCanClick(false);
                    horizontal.setClicked(true);
                    horizontal.setColor(Color.BLUE);
                    humanPlayer.setCanPlay(false);
                    computerPlayer.setCanPlay(true);
                    return;
                }
            }
        }

    }

    private ArrayList<Line> getAvailableLines() {
        ArrayList<Line> availableLines = new ArrayList<>();

        // Adiciona linhas verticais disponíveis
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (lines[i][j].getCanClick()) {
                    availableLines.add(lines[i][j]);
                }
            }
        }

        // Adiciona linhas horizontais disponíveis
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6; j++) {
                if (horizontalLines[i][j].getCanClick()) {
                    availableLines.add(horizontalLines[i][j]);
                }
            }
        }

        return availableLines;
    }

    private void computerPlay() {
        ArrayList<Line> availableLines = getAvailableLines();

        if (!availableLines.isEmpty()) {
            // Escolhe uma linha aleatória
            Random random = new Random();
            Line chosenLine = availableLines.get(random.nextInt(availableLines.size()));

            // Marca a linha como selecionada
            chosenLine.setCanClick(false);
            chosenLine.setClicked(true);
            chosenLine.setColor(Color.RED); // Usa uma cor diferente para a CPU
            computerPlayer.setCanPlay(false);
            humanPlayer.setCanPlay(true);
        }
    }

    private void linesGetClicked() {
        if (Gdx.input.justTouched()) {
            if (humanPlayer.getCanPlay()) {
                verifyLines();
            }
        }

        if (computerPlayer.getCanPlay()) {
            computerPlay();
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

    private void updateSquares() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                squares[i][j].updateSquare();
            }
        }

    }

    private void renderSquares() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                squares[i][j].render(shape);
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
    }

    public void createMap() {
        createDots();
        createLines();
        createSquares();
    }

    public void updateMap() {
        linesAreHovered();
        linesGetClicked();
        updateSquares();
    }

    public void renderMap() {
        renderLines();
        renderDots();
        renderSquares();
    }

    public void disposeMap() {
        shape.dispose();
        disposeLines();
        disposeDots();
    }

}
