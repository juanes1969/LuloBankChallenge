package co.com.lulobank.certificacion.tasks;

import co.com.lulobank.certificacion.interactions.Save;
import co.com.lulobank.certificacion.models.Employe;
import co.com.lulobank.certificacion.utils.Build;
import co.com.lulobank.certificacion.utils.Endpoints;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;
import org.json.JSONObject;

public class CreateEmploye implements Task {

    private Employe body;

    public CreateEmploye(Employe body) {
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(Endpoints.CREATE_EMPLOYE.getEndpoint())
                .with(requestSpecification -> requestSpecification.headers(Build.headerRequest())
                        .body(body).log().all()));

        ResponseBody responseBody = SerenityRest.lastResponse().getBody();
        String body = responseBody.asString();
        JSONObject jsonObject = new JSONObject(body);


        actor.remember("ID_USER", jsonObject.getJSONObject("data").get("id"));

        actor.attemptsTo(
                Save.theData("NAME_USER", jsonObject.getJSONObject("data").get("name")),
                Save.theData("MESSAGE_USER", jsonObject.get("message")));

    }


    public static CreateEmploye withPostMethod(Employe body) {
        return Tasks.instrumented(CreateEmploye.class, body);
    }
}
