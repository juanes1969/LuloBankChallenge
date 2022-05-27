package co.com.lulobank.certificacion.questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateResponseMessage implements Question {

    private String message;

    public ValidateResponseMessage(String message) {
        this.message = message;
    }

    @Override
    public Object answeredBy(Actor actor) {
        return Serenity.sessionVariableCalled("MESSAGE_USER").toString().contains(message);
    }

    public static ValidateResponseMessage inMessage(String message) {
        return new ValidateResponseMessage(message);
    }
}
