package com.example.simplilearn.flyaway.config.data;

public abstract class DataLoader {
    /**
     * Loads all the data that is specific to the particular environment that is being
     * deployed.
     */
    public abstract void loadEnvironmentSpecificData();

    /**
     * Loads all application data
     */
    public void loadData(){
        loadCommonEnvironmentData();
        loadEnvironmentSpecificData();
    }

    /**
     * Loads the data that is common to all environments.
     */
    public void loadCommonEnvironmentData(){
        //Load data that is common to all environments : Develeopment, Stage, Test, Prod, etc.
    }
}
