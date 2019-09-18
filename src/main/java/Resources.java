public class Resources {

    public static String getUsersPage2EndPointUri() {
        String endPoint = "/api/users/?page=2";
        return endPoint;
    }

    public static String getUser2EndPointUri() {
        String endPoint = "/api/users/2";
        return endPoint;
    }

    public static String getRegisterEndPointUri() {
        String endPoint = "/api/register";
        return endPoint;
    }

    public static String getSingleResources() {
        String endPoint = "/api/unknown/2";
        return endPoint;
    }

    public static String getDelayedResponse() {
        String endPoint = "/api/users?delay=3";
        return endPoint;
    }
    public static String getUserDataPost() {
        String endPoint = "/api/users";
        return endPoint;
    }
}
