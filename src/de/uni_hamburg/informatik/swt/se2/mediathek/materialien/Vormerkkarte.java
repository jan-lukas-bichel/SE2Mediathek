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
        addVormerker(vormerker);
    }

    /**
     * Setzt den uebergebenen Kunden ans Ende der Vormerkerliste
     * 
     * @param kunde
     */
    public void addVormerker(Kunde kunde)
    {

        if (!istVoll())
        {
            if (!_vormerker.contains(kunde))
            {
                _vormerker.add(kunde);
            }
        }

    }

    /**
     * Enfernt den uebergebenen Kunden ans Ende der Vormerkerliste
     * 
     * @param kunde
     */
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
     * Gibt eine List-Array mit allen Vormerkern zurück
     * 
     * @return List-Array mit allen Vormerkern
     * 
     * @ensure result = _vormerker
     * @ensure result.size() >= _maxVormerkerAnzahl;
     */
    public ArrayList<Kunde> getVormerker()
    {
        return _vormerker;
    }

    /**
     * Gibt Vormerker an spezifiziertem Index zurück
     * 
     * @return Vormerker an spezifiziertem Index
     * 
     * @ensure result = _vormerker.get(index)
     */
    public Kunde getVormerkerByIndex(int index)
    {
        if (index < _vormerker.size())
        {
            return _vormerker.get(index);
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

    /**
     * Gibt "true" zurück, wenn 3 Vormerkungen für das Medium eingetragen sind, sonst "false"
     * 
     * @return Boolean
     * 
     * @ensure result == true, wenn 3 Vormerker für das Medium eingetragen sind
     */
    // Hier kommt beim durchführen eine Null Pointer exception musst du denke ich thrown Gruß Ali
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
