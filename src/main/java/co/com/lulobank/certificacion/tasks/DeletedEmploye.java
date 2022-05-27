package co.com.lulobank.certificacion.tasks;

import co.com.lulobank.certificacion.utils.Build;
import co.com.lulobank.certificacion.utils.Endpoints;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.json.JSONObject;

public class DeletedEmploye implements Task {

    private int code;

    public DeletedEmploye(int code) {
        this.code = code;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(Endpoints.DELETE_EMPLOYE.getEndpoint()
                .concat(String.valueOf(code))).with(
                requestSpecification -> requestSpecification.headers(Build.headerRequest())));

        ResponseBody responseBody = SerenityRest.lastResponse().getBody();
        String body = responseBody.asString();
        JSONObject jsonObject = new JSONObject(body);

        actor.remember("DATA_USER_DELETED", jsonObject.get("message"));
    }

    public static DeletedEmploye withCode(int code) {

        return Tasks.instrumented(DeletedEmploye.class, code);
    }
}
