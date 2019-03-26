import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        KlasaZPolamiDoWstrzyknięcia klasaZPolamiDoWstrzyknięcia = new KlasaZPolamiDoWstrzyknięcia();

        System.out.println("##############  Przed wstyrzyknięciem");
        // TODO 8 wywołaj showColaborators() na obiekcie

        MojeRefleksje.wstrzyknij(klasaZPolamiDoWstrzyknięcia, "Jakaś wartość");

        System.out.println("##############  Po wsytrzyknięciu");
        // TODO 9 wywołaj showColaborators() na obiekcie

    }


}



/*
        TODO 1 utwórz adnotację @WstrzyknijJesliMnieZnajdziesz
  */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface WstrzyknijJesliMnieZnajdziesz


/*
    TODO 2 utwórz klasę, Colaborator 
	(jej instancja będzie tworzona i 'wstrzykiwana' za pomocą refleksji)
    Pola / metody klasy :
    String name
    String Colaborator
    nadpisz toString - zwraca wartość name
  */

/*
    TODO 3 uzupełnij klasę

    a) Dwoma polami typu Colaborator,
    Jedno z z pól z adnotacją @WstrzyknijJeśliMnieZnajdziesz.

    b) Metodą:
    public void showColaborators() {
        System.out.printf("Colaborator z adnotacją: " + colaboratorZAdnotacją + "\n");
        System.out.println("Colaborator bez adnotacji: " + colaboratorBezAdnotacji);
    }
 */

class KlasaZPolamiDoWstrzyknięcia {

}

/*
    TODO 4 Uzupełnik klasę MojeRefleksje

 */
class MojeRefleksje {
    static void wstrzyknij(Object target, String name) throws IllegalAccessException {
        // TODO 5 pobierz pola obiektu i przeiteruj po nich

        // TODO 6 Pobierz adnotacje z pola i przeiteruj po nich

        // TODO & jeśli adnotacja to WstrzyknijJesliMnieZnajdziesz utwórz nową instancję Colaborator'a i przypisz ją do pola

    }
}