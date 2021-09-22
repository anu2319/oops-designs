import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class User {

    private static String Username, password, email;



    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        User obj = new User();
        System.out.println("enter the number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch(n){
            case 1 : register();
                break;
            case 2 : login();
                break;
            case 3 : sendMails();
                break;
            case 4 : ListMyMails();
                break;
            case 5 : ListSentMails();
                break;
            case 6 : deleteMyMails();
                break;
            case 7 : deleteSentMails();
                break;
            case 8 : return;

        }

    }

    private static void register() throws IOException {
        User obj = new User();
        System.out.println("Enter Your Name : ");
        obj.Username = br.readLine();
        System.out.println("Enter Your Password : ");
        obj.password = br.readLine();
        System.out.println("Enter Your Email : ");
        obj.email = br.readLine();
        System.out.println("Registered Successfully..");

    }

    private static void login() throws IOException {
        User obj = new User();
        System.out.println("Enter your name: ");
        String inputUser = br.readLine();
        System.out.println("Enter your password: ");
        String inputPassword = br.readLine();
        System.out.println("Enter your email: ");
        String inputEmail = br.readLine();

        if ((inputUser.equals(Username)) && (inputPassword.equals(password)) && (inputEmail.equals(email))) {
            System.out.println("Login successfully..");
        } else {
            System.out.println("invalid input..");
        }
    }

    private static Map<String, Map<String, String>> outer = new HashMap<>();
    private static Map<String, String> inner = new HashMap<>();

    private static void sendMails() throws IOException {

        System.out.println("Enter the from mailId: ");
        String from = br.readLine();
        System.out.println("Enter the to mailId: ");
        String to = br.readLine();
        System.out.println("Enter the message: ");
        String message = br.readLine();
        inner.put(to, message);
        outer.put(from, inner);
        System.out.println(outer);
        System.out.println("Mail sent successfully...");
    }


    static void ListMyMails() throws IOException {
        sendMails();
        System.out.println("************************");
        System.out.println("List my mails...");
        System.out.println("Enter the to mailId: ");
        String inputTo = br.readLine();
        if (inner.containsKey(inputTo)) {
            System.out.println("My Mails:");
            System.out.println(inner.get(inputTo));
        }
    }

    static void ListSentMails() throws IOException {
        sendMails();
        System.out.println("************************");
        System.out.println("List sent Mails....");
        System.out.println("Enter the from mailId");
        String inputFrom = br.readLine();
        if (outer.containsKey(inputFrom)) {
            System.out.println("My sent mails: ");
            System.out.println(outer.get(inputFrom));
        }

    }


    private static void deleteMyMails() throws IOException {
        sendMails();
        System.out.println("Enter the mail which you want to delete: ");
        String inputMail = br.readLine();
        if (inner.containsKey(inputMail)) {
            inner.remove(inputMail);
            System.out.println(inner);
        }
    }

    private static void deleteSentMails() throws IOException {
        sendMails();
        System.out.println("Enter the mail which you want to delete from sent mail: ");
        String inputMail = br.readLine();
        if (outer.containsKey(inputMail)) {
            outer.remove(inputMail);
            System.out.println(outer);
        }
    }

}















