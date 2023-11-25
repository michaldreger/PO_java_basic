package pl.edu.pg.eti.ksg.po.lab1.transformacje;

public class ZlozenieTransformacji implements Transformacja {
    private final Transformacja[] transformacje;

    public ZlozenieTransformacji(Transformacja[] transformacje) {
        this.transformacje = transformacje;
    }

    @Override
    public Punkt transformuj(Punkt p) {
        Punkt wynik = p;
        for (Transformacja transformacja : transformacje) {
            wynik = transformacja.transformuj(wynik);
        }
        return wynik;
    }

    @Override
    public Transformacja getTransformacjaOdwrotna() throws BrakTransformacjiOdwrotnejException {
        // Kolejność odwrótna dla transformacji odwrotnej
        Transformacja[] odwrotneTransformacje = new Transformacja[transformacje.length];
        for (int i = 0; i < transformacje.length; i++) {
            odwrotneTransformacje[i] = transformacje[transformacje.length - 1 - i].getTransformacjaOdwrotna();
        }
        return new ZlozenieTransformacji(odwrotneTransformacje);
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ZlozenieTransformacji zlozenie = (ZlozenieTransformacji) obj;

        Punkt p1 = new Punkt(1, 1);
        Punkt p2 = new Punkt(2, 3);

        Punkt pk1 = this.transformuj(p1);
        Punkt pk2 = this.transformuj(p2);

        Punkt pk1z = zlozenie.transformuj(p1);
        Punkt pk2z = zlozenie.transformuj(p2);

        return (pk1.equals(pk1z) && pk2.equals(pk2z));
    }

}
