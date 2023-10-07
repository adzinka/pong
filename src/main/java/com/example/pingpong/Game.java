package com.example.pingpong;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Game {
    private final double width;
    private final double height;

    private Ball ball;
    private Bat leftBat;
    private Bat rightBat;

    public Game(double width, double height) {
        this.width = width;
        this.height = height;
        this.ball = new Ball(this, new Point2D(80, 90), new Point2D(100, 100), 15);
        this.leftBat = new Bat(this, new Point2D(30, 60), new Point2D(0, 50));
        this.rightBat = new Bat(this, new Point2D(width - 30 - 15, 150), new Point2D(0, -50));
    }

    public void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, width, height);

        gc.setFill(Color.DARKGRAY);
        drawTopBottomLine(gc);
        drawDashLine(gc);
        drawScore(gc);

        this.ball.draw(gc);
        this.leftBat.draw(gc);
        this.rightBat.draw(gc);
    }

    public void simulate(double timeDelta) {
        this.ball.simulate(timeDelta);
        this.leftBat.simulate(timeDelta);
        this.rightBat.simulate(timeDelta);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    void drawRect(Rectangle rect, GraphicsContext gc) {
        gc.fillRect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
    }

    void drawDashLine(GraphicsContext gc) {
        Rectangle square = new Rectangle(getWidth() / 2 ,15, 15, 15);

        while (square.getY() < getHeight() - 15) {
            drawRect(square, gc);
            square.setY(square.getY() + 30);
        }
    }

    void drawTopBottomLine(GraphicsContext gc) {
        Rectangle topLine = new Rectangle(0, 0, getWidth(), 15);
        drawRect(topLine, gc);

        Rectangle bottomLine = new Rectangle(0, getHeight() - 15, getWidth(), 15);
        drawRect(bottomLine, gc);
    }

    void drawScore(GraphicsContext gc) {
        gc.setFont(Font.font("Arial", FontWeight.BOLD, 45));
        gc.setFill(Color.WHITE);
        gc.fillText("0", getWidth() / 2 - 70, 65);
        gc.fillText("2", getWidth() / 2 + 65, 65);
    }
}
