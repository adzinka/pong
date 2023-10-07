package com.example.pingpong;

import javafx.geometry.Point2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ball {

    protected Game game;

    protected Point2D position;

    private Point2D speed;

    protected double size;

/*    public Ball(Game game) {
        this.game = game;
    }*/

    public Ball(Game game, Point2D start, Point2D speed, double size) {
        this.game = game;
        this.position = start;
        this.speed = speed;
        this.size = size;
    }

    public void draw(GraphicsContext gc) {
        gc.setFill(Color.LIGHTGRAY);
        double x = position.getX();
        double y = game.getHeight() - position.getY();
        gc.fillRect(x, y, size, size);
    }

    public void simulate(double timeDelta) {
        position = position.add(speed.multiply(timeDelta));
        //position = new Point2D(position.getX() % game.getWidth(),
        //                        position.getY() % game.getHeight());

        if (position.getY() > game.getHeight() - 15 || position.getY() < 25) {
            System.out.println(position.getY());
            speed = new Point2D(speed.getX(), -speed.getY());
        }

        if (position.getX() > game.getWidth() - size || position.getX() < 0) {
            System.out.println(position.getX());
            speed = new Point2D(-speed.getX(), speed.getY());
        }
    }
}
