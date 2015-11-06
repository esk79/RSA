import static spark.Spark.*;

public class Controller {
    public static void getPublicKey() {
        get("/getPublicKey", (req, res) ->{
            String appNumber = req.body();

            res.body("is dumb as all hell");
            return res.body();
        });
    }
}