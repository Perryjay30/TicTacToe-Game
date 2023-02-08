package Exercise8_18;

import UsersCredentialForm.PerryException;

import static Exercise8_18.Mark.E;

public class Player {
    private Mark mark;
    private String name;

    public Player(Mark mark, String name) {
        this.mark = mark;
        this.name = name;
    }

    public Mark getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }

    public void move(int position, Board board) throws PerryException {
        Mark [][] boardFace = board.getBoardFace();
        if(position <= 0 || position > 9) {
            throw new ArrayIndexOutOfBoundsException("Please enter a valid position");
        }
        else {
            int row = 0;
            int column = position - 1;
            if (position > 3) {
               row = 1;
               column = position - 4;
            }
            if (position > 6) {
                row = 2;
                column = position - 7;
            }
            if(boardFace[row][column] == E) {
                boardFace[row][column] = mark;
            } else throw new PerryException("You cannot play in an already selection position. Please play in an unselected position");
        }
    }
}
