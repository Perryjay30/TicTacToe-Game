package Exercise8_18;

import static Exercise8_18.Mark.*;

public class Board {
    public Mark[][] getBoardFace() {
            return boardFace;
    }
    private Mark [][] boardFace = {{E,E,E},{E,E,E},{E,E,E}};

    void displayBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(boardFace[i][j]);
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    private boolean checkWinnerAcrossRowZero() {
        boolean isX = (boardFace[0][0] == X && boardFace[0][1] == X && boardFace[0][2] == X);
        boolean isO = (boardFace[0][0] == O && boardFace[0][1] == O && boardFace[0][2] == O);

        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossRowOne() {
        boolean isX = (boardFace[1][0] == X && boardFace[1][1] == X && boardFace[1][2] == X);
        boolean isO = (boardFace[1][0] == O && boardFace[1][1] == O && boardFace[1][2] == O);

        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossRowTwo() {
        boolean isX = (boardFace[2][0] == X && boardFace[2][1] == X && boardFace[2][2] == X);
        boolean isO = (boardFace[2][0] == O && boardFace[2][1] == O && boardFace[2][2] == O);

        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossColumnZero() {
        boolean isO = (boardFace[0][0] == O && boardFace[1][0] == O && boardFace[2][0] == O);
        boolean isX = (boardFace[0][0] == X && boardFace[1][0] == X && boardFace[2][0] == X);


        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossColumnOne() {
        boolean isO = (boardFace[0][1] == O && boardFace[1][1] == O && boardFace[2][1] == O);
        boolean isX = (boardFace[0][1] == X && boardFace[1][1] == X && boardFace[2][1] == X);


        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossColumnTwo() {
        boolean isO = (boardFace[0][2] == O && boardFace[1][2] == O && boardFace[2][2] == O);
        boolean isX = (boardFace[0][2] == X && boardFace[1][2] == X && boardFace[2][2] == X);


        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossLeftDiagonal() {
        boolean isO = (boardFace[0][0] == O && boardFace[1][1] == O && boardFace[2][2] == O);
        boolean isX = (boardFace[0][0] == X && boardFace[1][1] == X && boardFace[2][2] == X);

        if (isX || isO) return true;
        else return false;
    }

    private boolean checkWinnerAcrossRightDiagonal() {
        boolean isX = (boardFace[0][2] == X && boardFace[1][1] == X && boardFace[2][0] == X);
        boolean isO = (boardFace[0][2] == O && boardFace[1][1] == O && boardFace[2][0] == O);

        if (isX || isO) return true;
        else return false;
    }



    public boolean isAWinner() {
            if(checkWinnerAcrossRowZero()) return true;
            if(checkWinnerAcrossRowOne()) return true;
            if(checkWinnerAcrossRowTwo()) return true;
            if(checkWinnerAcrossColumnZero()) return true;
            if(checkWinnerAcrossColumnOne()) return true;
            if(checkWinnerAcrossColumnTwo()) return true;
            if(checkWinnerAcrossLeftDiagonal()) return true;
            if(checkWinnerAcrossRightDiagonal()) return true;
            else return false;
    }

    public boolean isEmptyCall() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (boardFace[i][j] == E) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isATie() {
        if(!isEmptyCall() && !isAWinner()) return true;
        else {
            return false;
        }
    }
}
