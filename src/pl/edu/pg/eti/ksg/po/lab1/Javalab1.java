package pl.edu.pg.eti.ksg.po.lab1;

import pl.edu.pg.eti.ksg.po.lab1.transformacje.BrakTransformacjiOdwrotnejException;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.Obrot;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.Punkt;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.Skalowanie;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.Transformacja;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.Translacja;
import pl.edu.pg.eti.ksg.po.lab1.transformacje.ZlozenieTransformacji;

public class Javalab1 {
    public static void main(String[] args) {
        /*
         * Konstrukcja językowa try {} catch (...){} służy do
         * obsługi wyjątków. Kod w bloku try jest monitorowany
         * pod kątem wystąpienia wyjątku bądź wyjątków
         * wspomnianych na początku bloku/bloków catch.
         * Jeżeli gdzieś w bloku try wystąpi wyjątek, to sterowanie
         * zostanie natychmiast przeniesione do bloku catch.
         * Tam powinien znajdować się kod obsługujący wyjątek.
         * Może to być np. wypisanie stosu wywołań na wyjście błędów
         * lub zapisanie wyjątku w logach, lub wyrzucenie (zgłoszenie)
         * innego wyjątku lepiej opisującego sytuacje (można załączyć
         * wyjątek który zainicjował to zdarzenie patrz. Konstruktor
         * klasy java.lang.Exception)
         */
        try {
            Punkt p1 = Punkt.E_X;
            System.out.println(p1);
            Transformacja tr = new Translacja(5, 6);
            System.out.println(tr);
            Punkt p2 = tr.transformuj(p1);
            System.out.println(p2);
            Transformacja trr = tr.getTransformacjaOdwrotna();
            System.out.println(trr);
            Punkt p3 = trr.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();

        try {
            Punkt p1 = new Punkt(2, 2);
            System.out.println(p1);
            Transformacja tr2 = new Skalowanie(5, 4);
            System.out.println(tr2);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();
        try {
            Punkt p1 = new Punkt(2, 2);
            Transformacja tr2 = new Skalowanie(5, 0);
            System.out.println(tr2);
            System.out.println(p1);
            Punkt p2 = tr2.transformuj(p1);
            System.out.println(p2);
            Transformacja trr2 = tr2.getTransformacjaOdwrotna();
            System.out.println(trr2);
            Punkt p3 = trr2.transformuj(p2);
            System.out.println(p3);
        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }
        System.out.println();

        try {
            Punkt p1 = new Punkt(2, 0);
            Transformacja tr3 = new Obrot(360);
            System.out.println(tr3);
            System.out.println(p1);
            Punkt p2 = tr3.transformuj(p1);
            System.out.println(p2);
            Transformacja trr3 = tr3.getTransformacjaOdwrotna();
            System.out.println(trr3);

            Punkt p3 = trr3.transformuj(p2);
            System.out.println(p3);

        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }

        try {
            Punkt p1 = new Punkt(1, 1);
            System.out.println(p1);
            Transformacja tr1 = new Translacja(1, 3);
            Transformacja tr2 = new Skalowanie(4, 4);

            Transformacja[] transformacje1 = new Transformacja[] { tr1, tr2 }; // Correct array initialization

            Transformacja tr11 = new Translacja(0, 2);
            Transformacja tr22 = new Translacja(1, 1);
            Transformacja tr33 = new Skalowanie(2, 2);
            Transformacja tr44 = new Skalowanie(2, 2);

            Transformacja[] transformacje2 = new Transformacja[] { tr11, tr22, tr33, tr44 };

            Transformacja tr4 = new ZlozenieTransformacji(transformacje1);
            Transformacja tr5 = new ZlozenieTransformacji(transformacje2);

            Punkt p2 = tr4.transformuj(p1);
            System.out.println(p2);
            Punkt p3 = tr5.transformuj(p1);
            System.out.println(p3);
            System.out.println(tr4.equals(tr5));

            Transformacja Blad = new Skalowanie(0, 0);
            Transformacja[] transformacjeCatch = new Transformacja[] { tr1, tr2, Blad };
            Transformacja transformacjaCatch = new ZlozenieTransformacji(transformacjeCatch);

            Punkt pBlad = new Punkt(1, 1);
            Punkt pBladKonec = transformacjaCatch.transformuj(pBlad);

            System.out.println(pBladKonec);

            Transformacja trr = transformacjaCatch.getTransformacjaOdwrotna();
            Punkt pBladOdwrotny = trr.transformuj(pBladKonec);

            System.out.println(pBladOdwrotny);

        } catch (BrakTransformacjiOdwrotnejException ex) {
            ex.printStackTrace();
        }

    }
}