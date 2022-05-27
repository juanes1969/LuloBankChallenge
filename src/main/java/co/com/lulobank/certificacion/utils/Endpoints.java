package co.com.lulobank.certificacion.utils;

public enum Endpoints {

    BASE_URL("http://dummy.restapiexample.com/api/v1"),
    CREATE_EMPLOYE("/create"),
    DELETE_EMPLOYE("/delete/"),
    GET_EMPLOYES("/employees"),
    GET_BY_ID_EMPLOYE("/employee/");


    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
