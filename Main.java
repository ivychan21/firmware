import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    static String esp32IP = "http://192.168.1.50";

    public static void main(String[] args) {

        System.out.println("Smart Security System Started");

        while(true){

            boolean faceRecognized = faceRecognition();

            if(faceRecognized){
                System.out.println("Authorized Face Detected");
                sendCommand("openDoor");
            }
            else{
                System.out.println("Unknown Person");
                sendCommand("alarm");
                sendNotification("Unknown person detected!");
            }

            try{
                Thread.sleep(3000);
            }catch(Exception e){}
        }
    }

    public static boolean faceRecognition(){

        // Placeholder for OpenCV Face Recognition
        // You would integrate Haar Cascade + LBPH

        double random = Math.random();

        if(random > 0.5)
            return true;
        else
            return false;
    }

    public static void sendCommand(String command){

        try{

            URL url = new URL(esp32IP + "/command?cmd=" + command);

            HttpURLConnection conn =
                    (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            int response = conn.getResponseCode();

            System.out.println("ESP32 Response: " + response);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void sendNotification(String message){

        System.out.println("Sending Notification: " + message);

        // Example Telegram Bot API
        // https://api.telegram.org/botTOKEN/sendMessage

    }
}