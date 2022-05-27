package co.com.lulobank.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUserDeleted implements Question {

    private String opt;

    public ValidateUserDeleted(String opt) {
        this.opt = opt;
    }

    @Override
    public Object answeredBy(Actor actor) {
        return actor.recall("DATA_USER_DELETED").toString().contains(opt);
    }

    public static ValidateUserDeleted withTheData(String opt) {
        return new ValidateUserDeleted(opt);
    }
}
