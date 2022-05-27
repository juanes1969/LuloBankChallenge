package co.com.lulobank.certificacion.tasks;


import co.com.lulobank.certificacion.utils.Build;
import co.com.lulobank.certificacion.utils.Endpoints;
import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.json.JSONObject;

public class ConsultEmployeById implements Task {

    private int id;

    public ConsultEmployeById(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Endpoints.GET_BY_ID_EMPLOYE.getEndpoint()
                .concat(String.valueOf(id))).with(
                requestSpecification -> requestSpecification.headers(Build.headerRequest())));


        ResponseBody responseBody = SerenityRest.lastResponse().getBody();
        String body = responseBody.asString();
        JSONObject jsonObject = new JSONObject(body);

        actor.remember("DATA_USER_CONSULTED", jsonObject.get("data"));
    }

    public static ConsultEmployeById withId(int id) {
        return Tasks.instrumented(ConsultEmployeById.class, id);
    }
}
