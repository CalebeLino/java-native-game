package com.calebe;

import com.calebe.engine.CycleManager;
import com.calebe.engine.DaggerEngineComponent;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        CycleManager cycleManager = DaggerEngineComponent.create().cycleManager();
        cycleManager.performActivation();
        cycleManager.performUpdate();
    }
}