package co.com.lulobank.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateData implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return !actor.recall("DATA_USER_CONSULTED").equals(null);
    }

    public static ValidateData objectDataIsNotNull() {
        return new ValidateData();
    }
}
