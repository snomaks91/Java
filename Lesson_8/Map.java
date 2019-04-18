package Lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Map extends JPanel {

    public static final int MODE_H_V_A = 0;
    public static final int MODE_H_V_H = 1;

    int fieldSizeX;
    int fieldSizeY;

    int[][] field;

    int winLen;

    int cellHeigth;
    int cellWidth;

    boolean isInitialized = false;

    int EMPTY_DOT = 0;
    int PLAYER_DOT = 1;
    int AI_DOT = 2;
    int PADDING_DOT = 5;

    boolean gameOver;

    String MSG_DRAW = "Ничья!";
    String MSG_HUMAN_WIN = "Победил игрок!";
    String MSG_AI_WIN = "Победил компьютер!";

    int STATE_DRAW = 0;
    int STATE_HUMAN_WIN = 1;
    int STATE_AI_WIN = 2;
    int stateGameOver;

    static Random random = new Random();
    private final Font font = new Font("Times new roman", Font.BOLD, 48);

    public Map() {
        setBackground(Color.ORANGE);
    }

    void startNewGame(int mode, int fieldSizeX, int fieldSizeY, int winLen) {
        this.fieldSizeX = fieldSizeX;
        this.fieldSizeY = fieldSizeY;
        this.winLen = winLen;
        field = new int[fieldSizeY][fieldSizeX];

        isInitialized = true;
        gameOver = false;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                update(e);
                repaint();
            }
        });
        repaint();
    }

    void update(MouseEvent e) {
        if (gameOver) return;
        int cellX = e.getX() / cellWidth;
        int cellY = e.getY() / cellHeigth;
        if (isCellValid(cellY, cellX)) {
            field[cellX][cellY] = PLAYER_DOT;
        } else {
            return;
        }
        if (checkWin(PLAYER_DOT)) {
            stateGameOver = STATE_HUMAN_WIN;
            gameOver = true;
            return;
        }
        if (isMapFull()) {
            stateGameOver = STATE_DRAW;
            gameOver = true;
            return;
        }
        aiStep();
        repaint();
        if (checkWin(AI_DOT)) {
            stateGameOver = STATE_AI_WIN;
            gameOver = true;
            return;
        }
        if (isMapFull()) {
            stateGameOver = STATE_DRAW;
            gameOver = true;
            return;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    void render(Graphics g) {

        if (!isInitialized) return;

        int panelWidth = getWidth();
        int panelHeigth = getHeight();

        cellHeigth = panelHeigth / fieldSizeY;
        cellWidth = panelWidth / fieldSizeX;

        for (int i = 0; i < fieldSizeY; i++) {
            int y = i * cellHeigth;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSizeX; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeigth);
        }

        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellValid(j, i)) continue;
                if (field[i][j] == PLAYER_DOT) {
                    g.setColor(Color.blue);
                    g.drawLine(i * cellHeigth + PADDING_DOT *5,
                            j * cellWidth + PADDING_DOT *5,
                            (i + 1) * cellHeigth - PADDING_DOT *5,
                            (j + 1) * cellWidth - PADDING_DOT * 5);
                    g.drawLine((i + 1) * cellHeigth - PADDING_DOT *5,
                            j * cellWidth + PADDING_DOT *5,
                            i * cellHeigth + PADDING_DOT *5,
                            (j + 1) * cellWidth - PADDING_DOT * 5);
                } else {
                    g.setColor(Color.BLACK);
                    g.fillOval(i * cellHeigth + PADDING_DOT,
                            j * cellWidth + PADDING_DOT,
                            cellWidth - PADDING_DOT * 2,
                            cellHeigth - PADDING_DOT * 2);
                }
            }
        }
        if (gameOver) {
            showMessageGameOver(g);
        }
    }

    void showMessageGameOver(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 200, getWidth(), 70);
        g.setColor(Color.GREEN);
        g.setFont(font);
        if (stateGameOver == STATE_DRAW) {
            g.drawString(MSG_DRAW, 180, getHeight()/2);
        } else {
            if (stateGameOver == STATE_HUMAN_WIN) {
                g.drawString(MSG_HUMAN_WIN, 70, getHeight()/2);
            } else {
                g.drawString(MSG_AI_WIN, 20, getHeight()/2);
            }
        }
    }

    boolean isCellValid(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    boolean checkWin(int DOT) {
        int k = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == DOT) {
                    k++;
                } else {
                    if (k >= winLen) {
                        return true;
                    } else {
                        k = 0;
                        continue;
                    }
                }
            }
            if (k >= winLen) {
                return true;
            } else {
                k = 0;
            }
        }
        k = 0;
        for (int j = 0; j < fieldSizeX; j++) {
            for (int i = 0; i < fieldSizeY; i++) {
                if (field[i][j] == DOT) {
                    k++;
                } else {
                    if (k >= winLen) {
                        return true;
                    } else {
                        k = 0;
                        continue;
                    }
                }
            }
            if (k >= winLen) {
                return true;
            } else {
                k = 0;
            }
        }

        k = 0;
        for (int i = 0; i < fieldSizeY; i++) {
            if (field[i][i] == DOT) {
                k++;
            } else {
                continue;
            }
        }
        if (k >= winLen) {
            return true;
        }
        k = 0;
        for (int i = 0; i+1 < fieldSizeY; i++) {
            if (field[i+1][i] == DOT) {
                k++;
            } else {
                break;
            }
        }
        if (k == winLen) {
            return true;
        }
        k = 0;
        for (int i = 0; i+1 < fieldSizeY; i++) {
            if (field[i][i+1] == DOT) {
                k++;
            } else {
                break;
            }
        }
        if (k == winLen) {
            return true;
        }
        k = 0;
        for (int i = fieldSizeY - 1; i > 0; i--) {
            if (field[i-1][i] == DOT) {
                k++;
            } else {
                break;
            }
        }
        if (k == winLen) {
            return true;
        }
        k = 0;
        for (int i = fieldSizeY - 1, j = 0; i-1 >= 0; i--, j ++) {
            if (field[i-1][j] == DOT) {
                k++;
            } else {
                break;
            }
        }
        if (k == winLen) {
            return true;
        }
        k = 0;
        for (int i = fieldSizeY - 1, j = 0; j+1 < fieldSizeX; i--, j ++) {
            if (field[i][j+1] == DOT) {
                k++;
            } else {
                break;
            }
        }
        if (k == winLen) {
            return true;
        }
        k = 0;
        for (int j = 0, i = fieldSizeY - 1; j < fieldSizeX; i--, j++) {
            if (field[i][j] == DOT) {
                k++;
            } else {
                k = 0;
                continue;
            }
        }
        if (k >= winLen) {
            return true;
        }
        return false;
    }

    boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) {
                    return false;
                }
            }
        }
        return true;
    }

    void aiStep() {
        int x;
        int y;
        boolean flag = false;
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (isCellValid(j, i)) {
                    field[i][j] = AI_DOT;
                    if (checkWin(AI_DOT)) {
                        flag = true;
                        break;
                    } else {
                        field[i][j] = PLAYER_DOT;
                        if (checkWin(PLAYER_DOT)) {
                            field[i][j] = AI_DOT;
                            flag = true;
                            break;
                        } else {
                            field[i][j] = EMPTY_DOT;
                        }
                    }
                }
            }
            if (flag) {
                break;
            }
        }

        if (flag == false) {
            do {
                x = random.nextInt(fieldSizeX);
                y = random.nextInt(fieldSizeY);
            }
            while (!isCellValid(x, y));
            field[y][x] = AI_DOT;
        }
    }
}
