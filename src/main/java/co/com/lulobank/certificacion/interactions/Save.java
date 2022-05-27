package co.com.lulobank.certificacion.interactions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class Save implements Interaction {

    private String key;
    private Object value;

    public Save(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Serenity.setSessionVariable(key).to(value);
    }

    public static Save theData(String key, Object value) {
        return Tasks.instrumented(Save.class, key, value);
    }
}
