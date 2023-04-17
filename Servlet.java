package com.example.demo1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.io.*;
import java.io.FileWriter;
import java.io.Writer;

@WebServlet(urlPatterns = "/")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        HttpSession newSession = req.getSession();
        String redirect = req.getParameter("Replay");
        newSession.setAttribute("redirect",redirect);
        resp.sendRedirect("/WEB-INF/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        int counterOrdi=0;
        int counterUser=0;
        String Value = req.getParameter("Input");

        int valeur=1;

        int playerValue = Integer.valueOf(Value);

        if (playerValue > 0 && playerValue < 4) {

            if (session.getAttribute("users") == null) {
                List users = new ArrayList<>();
                users.add(Integer.valueOf(Value));
                Random random = new Random();
                valeur = random.nextInt(3) + 1;

                users.add(valeur);

                if (valeur == 1 && Integer.valueOf(Value) == 2) {
                    users.add("l'ordi a joué pierre et vous avez joué feuille vous avez gagné");
                    counterUser++;
                }
                else if (valeur == 1 && Integer.valueOf(Value) == 3) {
                    users.add("l'ordi a joué pierre et vous avez joué ciseaux vous avez perdu");
                    counterOrdi++;
                } else if (valeur == 2 && Integer.valueOf(Value) == 1) {
                    users.add("l'ordi a joué feuille et vous avez joué pierre vous avez perdu");
                    counterOrdi++;
                } else if (valeur == 2 && Integer.valueOf(Value) == 3) {
                    users.add("l'ordi a joué feuille et vous avez joué ciseaux vous avez gagné");
                    counterUser++;
                } else if (valeur == 3 && Integer.valueOf(Value) == 1) {
                    users.add("l'ordi a joué ciseaux et vous avez joué pierre vous avez gagné");
                    counterUser++;
                } else if (valeur == 3 && Integer.valueOf(Value) == 2) {
                    users.add("l'ordi a joué ciseaux et vous avez joué feuille vous avez perdu");
                    counterOrdi++;
                } else if (valeur == Integer.valueOf(Value)) {
                    users.add("Vous et l'ordi êtes à égalité");
                }

                session.setAttribute("users", users);

            } else {

                List users = (List) session.getAttribute("users");
                users.add(Value);
                users.add(valeur);
                if (valeur == 1 && Integer.valueOf(Value) == 2) {
                    users.add("l'ordi a joué pierre et vous avez joué feuille vous avez gagné");
                    counterUser++;
                } else if (valeur == 1 && Integer.valueOf(Value) == 3) {
                    users.add("l'ordi a joué pierre et vous avez joué ciseaux vous avez perdu");
                    counterOrdi++;
                } else if (valeur == 2 && Integer.valueOf(Value) == 1) {
                    users.add("l'ordi a joué feuille et vous avez joué pierre vous avez perdu");
                    counterOrdi++;
                } else if (valeur == 2 && Integer.valueOf(Value) == 3) {
                    users.add("l'ordi a joué feuille et vous avez joué ciseaux vous avez gagné");
                    counterUser++;
                } else if (valeur == 3 && Integer.valueOf(Value) == 1) {
                    users.add("l'ordi a joué ciseaux et vous avez joué pierre vous avez gagné");
                    counterUser++;
                } else if (valeur == 3 && Integer.valueOf(Value) == 2) {
                    users.add("l'ordi a joué ciseaux et vous avez joué feuille vous avez perdu");
                    counterOrdi++;
                } else if (valeur == Integer.valueOf(Value)) {
                    users.add("Vous et l'ordi êtes à égalité");
                }

                session.setAttribute("users", users);

                }


            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
            if( counterUser ==3 || counterOrdi ==3 ) {
                req.getRequestDispatcher("/WEB-INF/stop.jsp").forward(req, resp);
            }

        } else if (playerValue<0 || playerValue>4) { session.invalidate();
            req.getRequestDispatcher("/WEB-INF/break.jsp").forward(req, resp);
        }



        }
    }
