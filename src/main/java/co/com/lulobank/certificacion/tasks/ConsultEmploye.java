package co.com.lulobank.certificacion.tasks;

import co.com.lulobank.certificacion.utils.Endpoints;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsultEmploye implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(Endpoints.GET_EMPLOYES.getEndpoint()));
    }

    public static ConsultEmploye withGetMethodAll() {
        return Tasks.instrumented(ConsultEmploye.class);
    }
}
