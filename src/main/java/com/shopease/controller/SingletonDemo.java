package com.shopease.controller;

import com.shopease.singleton.SessionManager;

public class SingletonDemo {
    public static void main(String[] args) {
        SessionManager session1 = SessionManager.getInstance();
        session1.setCurrentUser("admin");

        SessionManager session2 = SessionManager.getInstance();
        System.out.println("Usuario actual: " + session2.getCurrentUser()); // Debería imprimir "admin"

        System.out.println("Misma instancia: " + (session1 == session2));   // true
    }
}