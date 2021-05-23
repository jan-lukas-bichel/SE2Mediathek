package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.ArrayList;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class Vormerkkarte
{
    private int _maxVormerkerAnzahl = 3;
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

    /**
     * Gibt die Länge der Schlange von Vormerkern zurück
     * 
     * @return die Anzahl der Vormerker des Mediums
     * 
     * @ensure result = _vormerker
     * @ensure result.size() >= _maxVormerkerAnzahl;
     */
    public ArrayList<Kunde> getVormerker()
    {
        return _vormerker;
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

    /**
     * Gibt "true" zurück, wenn 3 Vormerkungen für das Medium eingetragen sind, sonst "false"
     * 
     * @return Boolean
     * 
     * @ensure result == true, wenn 3 Vormerker für das Medium eingetragen sind
     */
    public boolean istVoll()
    {
        if (_vormerker.size() >= _maxVormerkerAnzahl)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
