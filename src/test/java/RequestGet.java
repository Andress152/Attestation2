import lombok.Data;

public class RequestGet {

    @Data
    public class ResponseError {
        private int cod;
        private String message;
    }

}
