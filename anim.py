from manim import *
class Sudoku(Scene):
    def construct(self):
        grid = [[0, 0, 8, 0, 5, 0, 0, 0, 0],
                [1, 0, 0, 9, 2, 0, 0, 0, 6],
                [0, 6, 0, 0, 0, 0, 0, 7, 0],
                [0, 0, 4, 0, 0, 0, 8, 0, 0],
                [0, 0, 0, 0, 0, 3, 0, 0, 0],
                [2, 0, 0, 1, 6, 0, 0, 0 ,7],
                [0 ,0 ,2 ,3 ,9 ,0 ,0 ,4 ,0],
                [0 ,0 ,0 ,0 ,0 ,5 ,0 ,0 ,9],
                [3 ,0 ,0 ,0 ,0 ,7 ,0 ,0 ,]]
        for i in range(9):
            for j in range(9):
                if grid[i][j] != ' ':
                    text = Text(str(grid[i][j]), font_size=60).move_to([j -4,i -4.5,.1])
                    self.play(Write(text))
        self.wait()
