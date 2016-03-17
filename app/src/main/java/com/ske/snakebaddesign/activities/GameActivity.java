package com.ske.snakebaddesign.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ske.snakebaddesign.R;
import com.ske.snakebaddesign.guis.BoardView;
import com.ske.snakebaddesign.models.Game;

import java.util.Observable;
import java.util.Observer;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements Observer{

    private Game game;

    private BoardView boardView;
    private Button buttonTakeTurn;
    private Button buttonRestart;
    private TextView textPlayerTurn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        initComponents();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void initComponents() {
        game = new Game(2,6);
        game.addObserver(this);
        boardView = (BoardView) findViewById(R.id.board_view);
        boardView.setBoardSize(6);
        buttonTakeTurn = (Button) findViewById(R.id.button_take_turn);
        buttonTakeTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeTurn();
            }
        });
        buttonRestart = (Button) findViewById(R.id.button_restart);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });
        textPlayerTurn = (TextView) findViewById(R.id.text_player_turn);
    }

    private void resetGame(){
        game.resetGame();
        game = new Game(2,6);
        for(int i = 0 ; i < game.getPlayer().length ; i++){
            game.rollDice();
            moveCurrentPiece(game.getFace());
        }
    }

    private void takeTurn() {
        //final int value = 1 + new Random().nextInt(6);
        game.rollDice();
        String title = "You rolled a die";
        String msg = "You got " + game.getFace();
        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                game.setPosition();
                moveCurrentPiece(game.getFace());
                dialog.dismiss();
            }
        };
        displayDialog(title, msg, listener);
    }

    private void moveCurrentPiece(int value) {
        if (game.getTurn() % 2 == 0) {
            boardView.setP1Position(game.getPlayer()[0].getPosition());
            textPlayerTurn.setText("Player 1's Turn");
        } else {
            boardView.setP2Position(game.getPlayer()[1].getPosition());
            textPlayerTurn.setText("Player 2's Turn");
        }

        checkWin();
    }

    private void checkWin() {
        String title = "Game Over";
        String msg = "";
        OnClickListener listener = new OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                game.resetGame();
                dialog.dismiss();
            }
        };
        if (game.getWinner().equals("player0")) {
            msg = "Player 2 won!";
            resetGame();
        } else if (game.getWinner().equals("player1")) {
            msg = "Player 1 won!";
            resetGame();
        } else {
            return;
        }
        displayDialog(title, msg, listener);
    }

    private void displayDialog(String title, String message, DialogInterface.OnClickListener listener) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle(title);
        alertDialog.setMessage(message);
        alertDialog.setCancelable(false);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", listener);
        alertDialog.show();
    }

    @Override
    public void update(Observable observable, Object data) {
        boardView.postInvalidate();
    }

}
