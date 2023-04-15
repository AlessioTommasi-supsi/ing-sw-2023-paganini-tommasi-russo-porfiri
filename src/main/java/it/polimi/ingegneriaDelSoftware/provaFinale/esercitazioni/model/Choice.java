package it.polimi.ingegneriaDelSoftware.provaFinale.esercitazioni.model;

import java.io.Serializable;

public class Choice implements Serializable {
    private Choice_my_shelfie choiche;

    private Object argument;

    public Choice(Choice_my_shelfie choiche, Object argument) {
        this.choiche = choiche;
        this.argument = argument;
    }

    public Choice_my_shelfie getChoiche() {
        return choiche;
    }

    public void setChoiche(Choice_my_shelfie choiche) {
        this.choiche = choiche;
    }

    public Object getArgument() {
        return argument;
    }

    public void setArgument(Object argument) {
        this.argument = argument;
    }


}
