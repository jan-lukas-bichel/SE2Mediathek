package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    private void registriereVormerkAktion()
    {
        _vormerkUI.getVormerkenButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    merkeAusgewaehlteMedienVor();
                }
            });
    }

    +addVormerker(Kunde):void     +getVormerker(int): Kunde
    +removeVormerker(Kunde):void
    +getMedium():Medium
    +istVoll()Boolean
}
