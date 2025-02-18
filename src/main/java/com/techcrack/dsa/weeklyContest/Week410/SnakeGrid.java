package com.techcrack.dsa.weeklyContest.Week410;

import java.util.List;

class SnakeGrid {
    public int finalPositionOfSnake(int n, List<String> commands) {
      

        int snakeRow = 0;
        int snakeColumn = 0;

        for (String s : commands) {
            if (s.equals("RIGHT"))
                snakeColumn++;
            else if (s.equals("LEFT"))
                snakeColumn--;
            else if (s.equals("UP"))
                snakeRow--;
            else
                snakeRow++;
        }

        return snakeRow * n + snakeColumn;
    }
}