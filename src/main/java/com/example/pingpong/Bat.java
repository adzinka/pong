package com.example.pingpong;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Bat {

    private Game game;
    private Point2D position;
    private Point2D speed;

    private final double width = 15;
    private final double height = 80;

    Bat(Game game, Point2D position, Point2D speed) {
        this.game = game;
        this.position = position;
        this.speed = speed;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.LIGHTGRAY);
        gc.fillRect(position.getX(), position.getY(), width, height);
    }

    public void simulate(double timeDelta){
        position = position.add(speed.multiply(timeDelta));

        if (position.getY() > game.getHeight() - height - 15 || position.getY() + height < 15 + height) {
//            System.out.println(position.getY());
            speed = new Point2D(speed.getX(), -speed.getY());
        }

    }
}

