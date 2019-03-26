import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        KlasaZPolamiDoWstrzyknięcia klasaZPolamiDoWstrzyknięcia = new KlasaZPolamiDoWstrzyknięcia();

        System.out.println("##############  Przed wstyrzyknięciem");
        // TODO 8 wywołaj showColaborators() na obiekcie
klasaZPolamiDoWstrzyknięcia.showColaborators();
        MojeRefleksje.wstrzyknij(klasaZPolamiDoWstrzyknięcia, "Jakaś wartość");

        System.out.println("##############  Po wsytrzyknięciu");
        // TODO 9 wywołaj showColaborators() na obiekcie
        klasaZPolamiDoWstrzyknięcia.showColaborators();

    }
}
/*
        TODO 1 utwórz adnotację @WstrzyknijJesliMnieZnajdziesz
  */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface WstrzyknijJesliMnieZnajdziesz{

}
/*
    TODO 2 utwórz klasę, KlasaZPolamiDoWstrzyknięcia.Colaborator
	(jej instancja będzie tworzona i 'wstrzykiwana' za pomocą refleksji)
    Pola / metody klasy :
    String name
    String KlasaZPolamiDoWstrzyknięcia.Colaborator
    nadpisz toString - zwraca wartość name
  */

class KlasaZPolamiDoWstrzyknięcia {

    Colaborator colaboratorBezAdnotacji;

    @WstrzyknijJesliMnieZnajdziesz
    Colaborator colaboratorZAdnotacją;

    public void showColaborators() {
        System.out.printf("KlasaZPolamiDoWstrzyknięcia.Colaborator z adnotacją: " + colaboratorZAdnotacją + "\n");
        System.out.println("KlasaZPolamiDoWstrzyknięcia.Colaborator bez adnotacji: " + colaboratorBezAdnotacji);
    }
}
/*
    TODO 2 utwórz klasę, KlasaZPolamiDoWstrzyknięcia.Colaborator
	(jej instancja będzie tworzona i 'wstrzykiwana' za pomocą refleksji)
    Pola / metody klasy :
    String name
    String KlasaZPolamiDoWstrzyknięcia.Colaborator
    nadpisz toString - zwraca wartość name
  */

     class Colaborator {
        String name;

        public Colaborator(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

/*
    TODO 3 uzupełnij klasę

    a) Dwoma polami typu KlasaZPolamiDoWstrzyknięcia.Colaborator,
    Jedno z z pól z adnotacją @WstrzyknijJeśliMnieZnajdziesz.

    b) Metodą:
    public void showColaborators() {
        System.out.printf("KlasaZPolamiDoWstrzyknięcia.Colaborator z adnotacją: " + colaboratorZAdnotacją + "\n");
        System.out.println("KlasaZPolamiDoWstrzyknięcia.Colaborator bez adnotacji: " + colaboratorBezAdnotacji);
    }
 */

/*
    TODO 4 Uzupełnik klasę MojeRefleksje

 */
class MojeRefleksje {
    static void wstrzyknij(Object target, String name) throws IllegalAccessException {
Field[] declaredFields=target.getClass().getDeclaredFields();
        for (Field f:declaredFields
             ) {Annotation[] annotations=f.getAnnotations();
            for (Annotation a: annotations
            ) {if(a.annotationType().getName().equals("WstrzyknijJesliMnieZnajdziesz")){
                f.setAccessible(true);
                f.set(target,new Colaborator(name));
            }

            }
        }

        // TODO 5 pobierz pola obiektu i przeiteruj po nich

        // TODO 6 Pobierz adnotacje z pola i przeiteruj po nich

        // TODO & jeśli adnotacja to WstrzyknijJesliMnieZnajdziesz utwórz nową instancję KlasaZPolamiDoWstrzyknięcia.Colaborator'a i przypisz ją do pola

    }
}