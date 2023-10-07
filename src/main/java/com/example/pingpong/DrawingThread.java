package com.example.pingpong;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawingThread extends AnimationTimer {

    private final GraphicsContext gc;

    private long lastTime;
    private final Game game;

    public DrawingThread(Canvas canvas) {
        this.gc = canvas.getGraphicsContext2D();
        this.game = new Game(canvas.getWidth(), canvas.getHeight());
    }

    @Override
    public void handle(long now) {

        if (lastTime > 0) {
            double deltaT = (now - lastTime) / 1e9;
            game.simulate(deltaT);
        }

        game.draw(gc);
        lastTime = now;
    }

}
