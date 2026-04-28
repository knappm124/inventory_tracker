/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.knappm124.inventorytracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author melissa
 */
public class IdMaker {

    public static int counter;

    public static int newId() {
        counter += 1;
        saveCounter();
        return counter;
    }

    public static void updateCounter() {
        try (Scanner myscanner = new Scanner("counter.txt")) {
            while (myscanner.hasNextLine()) {
                counter = myscanner.nextInt();
            }
        }
    }

    public static void saveCounter() {
        try (PrintWriter out = new PrintWriter("counter.txt")) {
            out.println(counter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
