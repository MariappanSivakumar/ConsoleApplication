package Controller;

public class ExpressionSpliter {

    public java.util.ArrayList<String> split(String expression) {
        java.util.ArrayList<String> expressionstoredcontrainer = new java.util.ArrayList<String>();
        String stepbystepprocessstore = new String();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i)!=' ' &&expression.charAt(i) >= 48 && expression.charAt(i) <= 57 || expression.charAt(i) == '.' || expression.charAt(i) == 'E') {
                stepbystepprocessstore += expression.charAt(i);
            } else {
                expressionstoredcontrainer.add(stepbystepprocessstore);
                stepbystepprocessstore = "";
                stepbystepprocessstore += expression.charAt(i);
                expressionstoredcontrainer.add(stepbystepprocessstore);
                stepbystepprocessstore = "";
            }
            if (i == (expression.length() - 1)) {
                expressionstoredcontrainer.add(stepbystepprocessstore);
            }
        }
        return expressionstoredcontrainer;
    }
}
