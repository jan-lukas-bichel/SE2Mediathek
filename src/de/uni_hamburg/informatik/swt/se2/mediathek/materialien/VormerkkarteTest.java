package de.uni_hamburg.informatik.swt.se2.mediathek.materialien;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Kundennummer;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.CD;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien.Medium;

public class VormerkkarteTest
{
    private Kunde _kunde;
    private Kunde _kunde2;
    private Kunde _kunde3;
    private Kunde _kunde4;
    private Medium _medium;

    public VormerkkarteTest()
    {
        _kunde = new Kunde(new Kundennummer(123456), "Hans", "Wurst");
        _kunde2 = new Kunde(new Kundennummer(123123), "Bettina", "Beispiel");
        _kunde3 = new Kunde(new Kundennummer(654321), "Peter", "Pan");
        _kunde4 = new Kunde(new Kundennummer(321321), "Karo", "Klar");
        _medium = new CD("bar", "baz", "foo", 123);
    }

    @Test
    public void testeKonstruktor() throws Exception
    {
        Vormerkkarte karte = new Vormerkkarte(_kunde, _medium);

        assertEquals(_kunde, karte.getVormerker()
            .get(0));
        assertEquals(_medium, karte.getMedium());
    }

    @Test
    public void testaddVormerker()
    {
        Vormerkkarte karte = new Vormerkkarte(_kunde, _medium);

        karte.addVormerker(_kunde2);
        assertEquals(_kunde2, karte.getVormerker()
            .get(1));
    }

    @Test
    public void testistVoll()
    {
        Vormerkkarte karte = new Vormerkkarte(_kunde, _medium);

        assertEquals(karte.istVoll(), false);
        karte.addVormerker(_kunde2);
        assertEquals(karte.istVoll(), false);
        karte.addVormerker(_kunde3);
        assertEquals(karte.istVoll(), true);
        karte.addVormerker(_kunde4);
        assertEquals(karte.istVoll(), true);
        assertEquals(3, karte.getVormerker()
            .size());

        karte.removeVormerker(_kunde);
        karte.removeVormerker(_kunde2);
        karte.removeVormerker(_kunde3);
        assertEquals(0, karte.getVormerker()
            .size());
        assertEquals(karte.istVoll(), false);
    }

    @Test
    public void testRemoveVormerker()
    {
        Vormerkkarte karte = new Vormerkkarte(_kunde, _medium);
        karte.addVormerker(_kunde2);
        karte.addVormerker(_kunde3);
        karte.removeVormerker(_kunde);

        assertEquals(2, karte.getVormerker()
            .size());
        assertEquals(_kunde2, karte.getVormerker()
            .get(0));
        assertEquals(_kunde3, karte.getVormerker()
            .get(1));

        karte.removeVormerker(_kunde);
        assertEquals(2, karte.getVormerker()
            .size());
    }
}
