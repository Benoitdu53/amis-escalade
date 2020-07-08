package com.escalade.model;

import java.util.Map;

public class MessageErreur extends Exception
{
    private Map erreur;

    public Map getErreur()
    {
        return erreur;
    }

    public void setErreur(final Map erreur)
    {
        this.erreur = erreur;
    }
}
