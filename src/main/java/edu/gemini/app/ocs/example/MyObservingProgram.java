/*
 * Copyright (c) 2020. Chaiyong Ragkhitwetsagul
 * All rights reserved.
 */

package edu.gemini.app.ocs.example;

import com.estcium.gemini9.model.base.BaseObservingProgram;

public class MyObservingProgram extends BaseObservingProgram {
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
