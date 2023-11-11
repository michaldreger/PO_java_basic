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
}
