package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.ArrayList;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class Vormerkkarte
{
    //Test
    private ArrayList<Kunde> _vormerker = new ArrayList<Kunde>();
    private Medium _medium;

    /**
     * Initialisiert eine neue Vormerkkarte mit den gegebenen Daten
     * 
     * @param vormerker
     * @param medium
     * 
     * @require medium != null
     * @require vormerker != null
     */
    public Vormerkkarte(Kunde vormerker, Medium medium)
    {
        _medium = medium;
        _vormerker.add(vormerker);
    }

    /**
     * Setzt den uebergebenen Kunden ans Ende der Vormerkerliste
     * 
     * @param kunde
     * 
     * @ensure kunde == getErsterVormerker || kunde == getZweiterVormerker || kunde == getDritterVormerker
     */
    public void addVormerker(Kunde kunde)
    {
        if (!istVoll())
        {
            _vormerker.add(kunde);
        }
    }

    public void removeVormerker(Kunde kunde)
    {
        for (int i = 0; i < _vormerker.size(); i++)
        {
            if (_vormerker.get(i) == kunde)
            {
                _vormerker.remove(i);
            }
        }
    }

    // Doch über Index zugreifung? ansonsten müsste ich das In den Funktionen machen wäre nicht so guter stil
    // also param int index und rückgabewert Kunde Gruß Ali 
    //    public ArrayList<Kunde> getVormerker()
    //    {
    //        return _vormerker;
    //    }

    /**
     * Gibt den ersten Vormerker zurück
     * 
     * @return den ersten Vormerker 
     * 
     * @ensure result != null
     */
    public Kunde getErsterVormerker()
    {
        return _vormerker.get(0);
    }

    /**
     * Gibt den zweiten Vormerker zurück
     * 
     * @return den zweiten Vormerker 
     * 
     * @ensure result != null
     */
    public Kunde getZweiterVormerker()
    {
        if (_vormerker.size() > 1)
        {
            return _vormerker.get(1);
        }
        return null;
    }

    /**
     * Gibt den dritten Vormerker zurück
     * 
     * @return den dritten Vormerker 
     * 
     * @ensure result != null
     */
    public Kunde getDritterVormerker()
    {
        if (_vormerker.size() > 2)
        {
            return _vormerker.get(2);
        }
        return null;
    }

    /**
     * Gibt das Medium zurück, dessen Ausleihe auf der Karte vermerkt ist
     * 
     * @return das Medium, dessen Ausleihe auf der Karte vermerkt ist
     * 
     * @ensure result != null
     */
    public Medium getMedium()
    {
        return _medium;
    }

    public boolean istVoll()
    {
        if (_vormerker.size() >= 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Gibt die Länge der Schlange von Vormerkern zurück
     * 
     * @return die Anzahl der Vormerker des Mediums
     * 
     * @ensure result < 4
     */
    public int getSize()
    {
        return _vormerker.size();
    }
}
