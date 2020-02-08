package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class TicTacToeController implements ActionListener {

    private final TicTacToeModel model;
    private final TicTacToeView view;


    /* CONSTRUCTOR */
    public TicTacToeController(int width) {

        /* Initialize model, view, and width */
        this.model = new TicTacToeModel(width);
        this.view = new TicTacToeView(this, width);

    }

    public void start() {

        /* MAIN LOOP (repeats until game is over) */

 /* Display the board using the View's "showBoard()", then use
           "getNextMove()" to get the next move from the player.  Enter
           the move (using the Model's "makeMark()", or display an error
           using the View's "showInputError()" if the move is invalid. */
        // INSERT YOUR CODE HERE
        /* After the game is over, show the final board and the winner */
//        view.showBoard(model.toString());
        // view.showResult(model.getResult().toString());
    }

    public String getMarkAsString(int row, int col) {
        return (model.getMark(row, col).toString());
    }

    public TicTacToeView getView() {
        return this.view;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JButton) {

            JButton button = (JButton) (event.getSource());
            String name = button.getName();
            System.out.print(name);
            int row = Integer.parseInt(name.substring(6, 7));
            int col = Integer.parseInt(name.substring(7));
            boolean markMade = model.makeMark(row, col);
            if (markMade) {

                String mark = model.getResult().toString();

                view.updateSquares();
                
                getResult(mark);
                
                if (model.isGameover()) {
                    view.disableSquares();
                }

            }

        }

    }

    private void getResult(String mark) {
        switch (mark) {
            case "X":
                view.showResult("X");
                break;
            case "O":
                view.showResult("O");
                break;
            case "TIE":
                view.showResult("TIE");
                break;
            default:
                view.showResult("NONE");
                break;

        }
    }

}
