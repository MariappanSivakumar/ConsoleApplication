package view;

public class GetInformation {

    private String input;

    public String getString() {
        try {
            input = ((new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine());
        } catch (java.io.IOException e) {}
        return input;
    }
}
