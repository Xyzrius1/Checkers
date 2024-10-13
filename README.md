# Checkers  ⬛⬜⬛⬜⬛
Overview
This project implements a Checkers Game to be used in conjunction with a BitManipulation Utility Class to show how bitwise operations along with binary arithmetic can be utilized within a real-world application. Usually, bitwise operations and binary arithmetic give low-level access to data efficiently, especially in game development and in systems programming, where the performance factor is important.
This document explains in detail the design and implementation, besides challenges encountered while developing the CheckersGame and BitManipulationUtil classes, and also how bitwise operations can be applied to efficiently solve some common computational tasks.

Summary of Game Rules:

Players alternate turns moving their pieces diagonally.

Capturing an opponent's piece by jumping over it is possible and mandatory if available.

Reaching the far end of the board promotes a piece to a king.

The code ensures moves are validated based on the rules of checkers, including diagonal movement, capturing, and king movement.



Game Development

When developing games, especially board games like checkers:

Bitboards: A bitboard is a compact way of representing the status of a board. Using bitwise operations, you can query and update the state of a square on the board rather quickly. For example: You can store a 64-

square board in two 64-bit integers - Player 1's pieces and Player 2's pieces.

Moving Validation: Bitwise operations are way more efficient compared to iteration through the whole board when checking for valid moves.

Key Functions:

setBit(int number, int bitPosition): Sets the desired bit of a number to 1.

clearBit(int number, int bitPosition): Clears a particular bit in a number.

toggleBit(int number, int bitPosition): Toggles a bit from 1 to 0 or vice versa.

getBit(int number, int bitPosition): Returns the value of a given bit.

toBinaryString(int number), toHexString(int number): These two methods convert decimal numbers into binary or hexadecimal format.

