package com.example.pingpong;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
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
        // (game.getHeight() - position.getY()) - why?
        if ((game.getHeight() - position.getY()) > game.getHeight() - 30 || (game.getHeight() - position.getY()) < 15) {

            speed = new Point2D(speed.getX(), -speed.getY());
            System.out.println("Y coordinate " + (game.getHeight() - position.getY()));
        }

        if (position.getX() > game.getWidth() - size || position.getX() < 0) {
            if (position.getX() < 0) {
                position = new Point2D(0, position.getY());
            }
            speed = new Point2D(-speed.getX(), speed.getY());
            System.out.println("X coordinate " + position.getX());
        }

    }

    public Rectangle2D getBoundingBox() {
        return new Rectangle2D(position.getX(), game.getHeight() - position.getY(),
                15, 15);
    }

    public void hit() {
        speed = new Point2D(-speed.getX(), -speed.getY());
    }
}
