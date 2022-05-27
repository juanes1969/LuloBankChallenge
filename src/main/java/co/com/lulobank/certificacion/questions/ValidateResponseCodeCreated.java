package co.com.lulobank.certificacion.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponseCodeCreated implements Question {
    private Object code;

    @Override
    public Object answeredBy(Actor actor) {
        return actor.recall("ID_USER") != null;
    }

    public static ValidateResponseCodeCreated isCreatedCode() {
        return new ValidateResponseCodeCreated();
    }
}
