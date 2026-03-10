package com.quintas.carmen.login_register.controller;

import com.quintas.carmen.login_register.App;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controller for the 3 en raya (Tic-Tac-Toe) game view.
 */
public class GameController {

    private static final char X = 'X';
    private static final char O = 'O';

    @FXML
    private Label lblTurno;
    @FXML
    private Button btn00, btn01, btn02, btn10, btn11, btn12, btn20, btn21, btn22;

    private Button[][] board;
    private char[][] cells;
    private char currentPlayer;
    private boolean gameOver;

    @FXML
    public void initialize() {
        board = new Button[][]{
            {btn00, btn01, btn02},
            {btn10, btn11, btn12},
            {btn20, btn21, btn22}
        };
        cells = new char[3][3];
        resetGame();
    }

    @FXML
    private void onCellClick(ActionEvent event) {
        if (gameOver) return;

        Button btn = (Button) event.getSource();
        int row = -1, col = -1;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r][c] == btn) {
                    row = r;
                    col = c;
                    break;
                }
            }
        }
        if (row < 0 || col < 0 || cells[row][col] != 0) return;

        cells[row][col] = currentPlayer;
        btn.setText(String.valueOf(currentPlayer));
        btn.setDisable(true);

        if (checkWin(currentPlayer)) {
            lblTurno.setText("¡Gana " + currentPlayer + "!");
            gameOver = true;
            disableAll();
            return;
        }
        if (checkDraw()) {
            lblTurno.setText("¡Empate!");
            gameOver = true;
            return;
        }

        currentPlayer = (currentPlayer == X) ? O : X;
        lblTurno.setText("Turno: " + currentPlayer);
    }

    @FXML
    private void onReiniciarClick(ActionEvent event) {
        resetGame();
    }

    @FXML
    private void onSalirClick(ActionEvent event) throws IOException {
        App.setRoot("/com/quintas/carmen/login_register/fxml/Login");
    }

    private boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0] == player && cells[i][1] == player && cells[i][2] == player) return true;
            if (cells[0][i] == player && cells[1][i] == player && cells[2][i] == player) return true;
        }
        if (cells[0][0] == player && cells[1][1] == player && cells[2][2] == player) return true;
        if (cells[0][2] == player && cells[1][1] == player && cells[2][0] == player) return true;
        return false;
    }

    private boolean checkDraw() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (cells[r][c] == 0) return false;
            }
        }
        return true;
    }

    private void disableAll() {
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                board[r][c].setDisable(true);
            }
        }
    }

    private void resetGame() {
        currentPlayer = X;
        gameOver = false;
        lblTurno.setText("Turno: X");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                cells[r][c] = 0;
                board[r][c].setText(" ");
                board[r][c].setDisable(false);
            }
        }
    }
}
