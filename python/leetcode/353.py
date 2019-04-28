from collections import deque
class SnakeGame(object):
    def __init__(self, width,height,food):
        """
        Initialize your data structure here.
        @param width - screen width
        @param height - screen height
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
        :type width: int
        :type height: int
        :type food: List[List[int]]
        """
        self.foodIndex = 0
        self.snake = deque()  # A queue as the snake
        self.snake.append((0, 0))
        self.body = {(0, 0)}  # A set to keep all positions of the snake
        self.foods = food
        self.width = width
        self.height = height
        self.moves = {'U': (0, -1), 'L': (-1, 0), 'R': (1, 0), 'D': (0, 1)}

    def move(self, direction):
        """
        Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
        @return The game's score after the move. Return -1 if game over.
        Game over when snake crosses the screen boundary or bites its body.
        :type direction: str
        :rtype: int
        """
        tail = self.snake.popleft()  # pop out the tail
        self.body.remove(tail)
        if not self.snake:
            head = tail
        else:
            head = self.snake[-1]
        xm, ym = self.moves[direction]
        nx, ny = head[0]+xm, head[1]+ym
        if (nx, ny) in self.body or nx < 0 or nx >= self.width or ny < 0 or ny >= self.height:
            return -1
        self.snake.append((nx, ny))  # append the new head
        self.body.add((nx, ny))
        if self.foodIndex < len(self.foods) and nx == self.foods[self.foodIndex][1] and ny == self.foods[self.foodIndex][0]:
            self.foodIndex += 1
            self.snake.appendleft(tail)
            self.body.add(tail)
          # Add back the tail if the snake eat a food
        return len(self.snake) - 1