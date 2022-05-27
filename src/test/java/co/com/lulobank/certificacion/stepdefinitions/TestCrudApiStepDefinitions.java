package co.com.lulobank.certificacion.stepdefinitions;

import co.com.lulobank.certificacion.exeptions.APIExeption;
import co.com.lulobank.certificacion.models.Employe;
import co.com.lulobank.certificacion.questions.ValidateUserDeleted;
import co.com.lulobank.certificacion.tasks.ConsultEmploye;
import co.com.lulobank.certificacion.tasks.ConsultEmployeById;
import co.com.lulobank.certificacion.tasks.CreateEmploye;
import co.com.lulobank.certificacion.tasks.DeletedEmploye;
import co.com.lulobank.certificacion.utils.Endpoints;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static co.com.lulobank.certificacion.questions.ValidateData.objectDataIsNotNull;
import static co.com.lulobank.certificacion.questions.ValidateResponseCodeCreated.isCreatedCode;
import static co.com.lulobank.certificacion.questions.ValidateResponseMessage.inMessage;
import static co.com.lulobank.certificacion.questions.ValidateRespose.isCode;
import static co.com.lulobank.certificacion.utils.Constants.API_CRASHED;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class TestCrudApiStepDefinitions {


    @Given("that the {word} consumes on the base endpoint")
    public void thatTheUserConsumesOnTheBaseEndpoint(String actor) {
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(actor).whoCan(CallAnApi.at(Endpoints.BASE_URL.getEndpoint()));
    }

    @When("the user uses get the endpoint information")
    public void theUserUsesGetTheEndpointInformation() {
        theActorInTheSpotlight().attemptsTo(ConsultEmploye.withGetMethodAll());
    }

    @When("the user uses post the endpoint information")
    public void theUserUsesPostTheEndpointInformation(DataTable employe) {
        theActorInTheSpotlight().attemptsTo(CreateEmploye.withPostMethod(new Employe(employe)));
    }

    @When("the user uses get id the endpoint information whit id {int}")
    public void theUserUsesGetIdTheEndpointInformationWhitId(Integer id) {
        theActorInTheSpotlight().attemptsTo(ConsultEmployeById.withId(id));

    }

    @When("the user uses delete the endpoint information whit id {int}")
    public void theUserUsesDeleteTheEndpointInformationWhitId(Integer codeDeleted) {
        theActorInTheSpotlight().attemptsTo(DeletedEmploye.withCode(codeDeleted));
    }

    @Then("And the user will be able to visualize the data of the employe {word}")
    public void andTheUserWillBeAbleToVisualizeTheDataOfTheEmployeDeleted(String option) {
        theActorInTheSpotlight().should(seeThat(ValidateUserDeleted.withTheData(option))
                .orComplainWith(APIExeption.class, API_CRASHED));
    }

    @Then("the user will be able to visualize the response status code {int}")
    public void theUserWillBeAbleToVisualizeTheResponseStatusCode(Integer code) {
        theActorInTheSpotlight().should(seeThat(isCode(), equalTo(code))
                .orComplainWith(APIExeption.class, API_CRASHED));
    }

    @Then("the user will be able to visualize the message {word}")
    public void theUserWillBeAbleToVisualizeTheMessage(String message) {
        theActorInTheSpotlight().should(
                seeThat(inMessage(message)),
                seeThat(isCreatedCode()).orComplainWith(APIExeption.class, API_CRASHED));

    }

    @Then("the user will be able to visualize the data of the employe consulted")
    public void theUserWillBeAbleToVisualizeTheDataOfTheEmployeConsulted() {
        theActorInTheSpotlight().should(seeThat(objectDataIsNotNull())
                .orComplainWith(APIExeption.class, API_CRASHED));
    }
}
