package com.estcium.gemini9.repository;

import edu.gemini.app.ocs.controller.VirtualTelescopeHandler;
import edu.gemini.app.ocs.model.VirtualTelescope;

import java.util.ArrayList;

public class Gemini {
    private ArrayList<VirtualTelescope> virtualTelescopes;

    public Gemini(){
        ArrayList<VirtualTelescope> vts = new ArrayList<>();
        vts.add(VirtualTelescopeHandler.getVirtualTelescope("NORTH"));
        virtualTelescopes=vts;
    }

    public ArrayList<VirtualTelescope> getVirtualTelescopes() {
        return virtualTelescopes;
    }
}
