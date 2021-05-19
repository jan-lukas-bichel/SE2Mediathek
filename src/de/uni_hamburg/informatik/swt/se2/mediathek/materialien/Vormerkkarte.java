package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.util.ArrayList;

import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class Vormerkkarte
{
    private ArrayList<Kunde> _vormerker = new ArrayList<Kunde>();
    private Medium _medium;

    Vormerkkarte(Kunde vormerker, Medium medium)
    {
        _medium = medium;
        _vormerker.add(vormerker);
    }

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

    public Kunde getVormerker(int vormerkerIndex)
    {
        return _vormerker.get(vormerkerIndex);
    }

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
}
