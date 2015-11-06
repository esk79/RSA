import static spark.Spark.*;

public class Controller {
    public static void Controller() {
        get("/hello", (req, res) -> "Test");
    }
}