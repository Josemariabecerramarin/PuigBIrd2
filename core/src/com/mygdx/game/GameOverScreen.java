package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.ScreenUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.naming.Context;

public class GameOverScreen implements Screen {
    float x = 105;
    float y = 125;
    final Bird game;
    OrthographicCamera camera;
    BitmapFont font = new BitmapFont();
    Texture background = new Texture("gameover.png");
    List<Score> scoreCopia;
    List<Score> scoreOrdenado = new ArrayList<>();
    Score scoreGuard;
    int aborrar;
    static int puntuacion;


    static class Score{
        int puntuacion;

        public Score (int puntuacion){
            this.puntuacion = puntuacion;
            GameOverScreen.puntuacion = puntuacion;
        }
    }
    public GameOverScreen(final Bird gam) {
        game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);


            font.getData().setScale(3);
            font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            game.batch.begin();
            game.batch.draw(background, x + 220 , y + 200, 180, 60);
        /*game.font.draw(game.batch, "Game Over! ", 300, 300);
        game.font.draw(game.batch, "Final Score: " + game.lastScore, 300, 180);
        game.font.draw(game.batch, "Top Score: " + game.topScore, 300, 120);*/
            font.draw(game.batch, "SCOREBOARD", x + 160, y + 130);

            scoreCopia = Bird.scoreList;
            for (int j = 0; j < Bird.scoreList.size(); j++) {
                if (!scoreCopia.isEmpty()) scoreGuard = scoreCopia.get(0);
                else break;
                for (int i = 1; i < scoreCopia.size(); i++) {
                    if (scoreGuard.puntuacion <= scoreCopia.get(i).puntuacion) {
                        scoreGuard = scoreCopia.get(i);
                        aborrar = i;
                    }
                }
                scoreOrdenado.add(scoreGuard);
                scoreCopia.remove(scoreGuard);
            }

            for (int i = 0; i < scoreOrdenado.size() && i < 5; i++) {
                font.draw(game.batch, "" + scoreOrdenado.get(i).puntuacion, x + 300, y + 70 - i * 40);

            }

            game.batch.end();
        if (Gdx.input.justTouched()) {
            game.setScreen(new MainMenuScreen(game));
            dispose();
        }
        }



    @Override
    public void resize(int width, int height) {
    }
    @Override
    public void show() {
    }
    @Override
    public void hide() {
    }
    @Override
    public void pause() {
    }
    @Override
    public void resume() {
    }
    @Override
    public void dispose() {
    }
    /*void guardarPuntuacion(int puntuacion) {
     *//*   try {
            *//**//*FileOutputStream writer = new FileOutputStream(new File("scores.txt"));
            writer.write(puntuacion);
            writer.close();*//**//*
            *//**//*FileWriter fileWriter = new FileWriter("gradle/scores.txt", true);*//**//*

          *//**//*  fileWriter.write(puntuacion + "\n");
            fileWriter.flush();
            fileWriter.close();*//**//*
            *//**//*puntos = String.valueOf(puntuacion);
            FileHandle file = Gdx.files.local("assets/scores.txt");
            file.writeString(puntos, false);*//**//*

        } catch (Exception e) {
            e.printStackTrace();
        }*//*
        try {
            FileOutputStream f = context.openFileOutput("scores.txt", Context.MODE_APPEND);
            Str
        }
        leerPuntuaciones();
    }

    void leerPuntuaciones() {
        try {
            Scanner scanner = new Scanner(new File("gradle/scores.txt"));
            scanner.useDelimiter(",|\n");

            while (scanner.hasNext()) {
                String nombre = scanner.next();
                int puntos = scanner.nextInt();

                scoreList.add(new Score(puntos));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

}
