package checkers;

import java.util.Scanner;

public class CheckersGame {
    private static final int BOARD_SIZE = 8;
    private static char[][] board;

    public static void main(String[] args) {
        initializeBoard();
        printBoard();

        Scanner scanner = new Scanner(System.in);
        boolean player1Turn = true; // Player 1 (b) starts first

        while (true) {
            String currentPlayer = player1Turn ? "Player One (b)" : "Player Two (w)";
            System.out.println(currentPlayer + ", it's your turn to move a piece.");
            System.out.print("Enter your move (e.g., F4-D5): ");
            String moveInput = scanner.nextLine().trim();

            // Validate the input and process the move
            if (isValidMoveInput(moveInput)) {
                String[] move = moveInput.split("-");
                int fromRow = BOARD_SIZE - Integer.parseInt(move[0].substring(1)); // Convert to 0-index
                int fromCol = move[0].charAt(0) - 'A'; // Convert letter to index
                int toRow = BOARD_SIZE - Integer.parseInt(move[1].substring(1)); // Convert to 0-index
                int toCol = move[1].charAt(0) - 'A'; // Convert letter to index

                // Attempt to make the move
                if (isValidMove(fromRow, fromCol, toRow, toCol, player1Turn)) {
                    makeMove(fromRow, fromCol, toRow, toCol);
                    printBoard();
                    player1Turn = !player1Turn; // Switch turn
                } else {
                    System.out.println("Invalid move! Please try again.");
                }
            } else {
                System.out.println("Invalid input format! Please use A1-B2 format.");
            }
        }
    }

    // Initialize the board with pieces
    private static void initializeBoard() {
        board = new char[BOARD_SIZE][BOARD_SIZE];
        // Set up black pieces (b) at the top (rows 0-2)
        for (int row = 0; row < 3; row++) {
            for (int col = (row % 2); col < BOARD_SIZE; col += 2) {
                board[row][col] = 'b'; // Player 1 (black) pieces
            }
        }
        // Set up white pieces (w) at the bottom (rows 5-7)
        for (int row = 5; row < BOARD_SIZE; row++) {
            for (int col = (row % 2); col < BOARD_SIZE; col += 2) {
                board[row][col] = 'w'; // Player 2 (white) pieces
            }
        }
    }

    // Print the board state
    private static void printBoard() {
        System.out.println("  A B C D E F G H");
        for (int row = 0; row < BOARD_SIZE; row++) {
            System.out.print((BOARD_SIZE - row) + " "); // Print row number
            for (int col = 0; col < BOARD_SIZE; col++) {
                System.out.print((board[row][col] == '\0' ? '.' : board[row][col]) + " ");
            }
            System.out.println();
        }
    }

    // Check if the move input format is valid
    private static boolean isValidMoveInput(String move) {
        return move.matches("[A-H][1-8]-[A-H][1-8]");
    }

    // Validate the move
    private static boolean isValidMove(int fromRow, int fromCol, int toRow, int toCol, boolean isPlayer1) {
        char currentPiece = board[fromRow][fromCol];
        char targetPiece = board[toRow][toCol];

        // Check if the piece belongs to the current player
        if ((isPlayer1 && currentPiece != 'b' && currentPiece != 'B') || (!isPlayer1 && currentPiece != 'w' && currentPiece != 'W')) {
            return false;
        }

        // Check if moving to an empty square
        if (targetPiece != '\0') {
            return false; // Can't move to a square that's not empty
        }

        // Calculate the direction of the move
        int rowDiff = toRow - fromRow;
        int colDiff = toCol - fromCol;

        // Check for valid moves (regular moves and captures)
        if (isPlayer1) {
            if (currentPiece == 'b' || currentPiece == 'B') {
                // Regular move
                if (rowDiff == 1 && Math.abs(colDiff) == 1) {
                    return true;
                }
                // Capture
                if (rowDiff == 2 && Math.abs(colDiff) == 2) {
                    int capturedRow = fromRow + 1;
                    int capturedCol = fromCol + (colDiff / 2);
                    return board[capturedRow][capturedCol] == 'w' || board[capturedRow][capturedCol] == 'W'; // Capture white piece
                }
            }
        } else {
            if (currentPiece == 'w' || currentPiece == 'W') {
                // Regular move
                if (rowDiff == -1 && Math.abs(colDiff) == 1) {
                    return true;
                }
                // Capture
                if (rowDiff == -2 && Math.abs(colDiff) == 2) {
                    int capturedRow = fromRow - 1;
                    int capturedCol = fromCol + (colDiff / 2);
                    return board[capturedRow][capturedCol] == 'b' || board[capturedRow][capturedCol] == 'B'; // Capture black piece
                }
            }
        }

        return false; // Not a valid move
    }

    // Make the move on the board
    private static void makeMove(int fromRow, int fromCol, int toRow, int toCol) {
        char currentPiece = board[fromRow][fromCol];
        board[toRow][toCol] = currentPiece; // Move the piece
        board[fromRow][fromCol] = '\0'; // Remove the piece from the original position

        // Check for capturing a piece
        int rowDiff = toRow - fromRow;
        int colDiff = toCol - fromCol;
        if (Math.abs(rowDiff) == 2 && Math.abs(colDiff) == 2) {
            int capturedRow = fromRow + (rowDiff / 2);
            int capturedCol = fromCol + (colDiff / 2);
            board[capturedRow][capturedCol] = '\0'; // Remove the captured piece
        }

        // Check for kinging
        if (currentPiece == 'b' && toRow == BOARD_SIZE - 1) {
            board[toRow][toCol] = 'B'; // Promote to king
        } else if (currentPiece == 'w' && toRow == 0) {
            board[toRow][toCol] = 'W'; // Promote to king
        }
    }
}
