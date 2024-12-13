package fr.istic.vv;

/**
 * Erreur jetée quand la date demandée est invalide.
 */
public class NotADateException extends Exception{

    public NotADateException(String message){
        super(message);
    }
}
