public class LinearEquation {
    // Instance Variables
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    // Creates a LinearEquation object
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // Calculates and returns distance between (x1, y1) and (x2, y2), rounded to the nearest hundredth
    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow((x2 - x1), 2) + (Math.pow((y2 - y1), 2))));
    }

    // Calculates and returns the y-intercept
    public double yIntercept() {
        return roundedToHundredth(y1 - (slope() * x1));
    }

    // Calculates and returns the slope
    public double slope() {
        return roundedToHundredth(((double) y2 - y1) / ((double) x2 - x1));
    }

    // Returns a String that represents the linear equation of the line
    public String equation() {
        if (y1 == y2) {
            return "y = " + y1;
        }

        String slopeFraction = "" + (y2 - y1) + "/" + (x2 - x1);
        String slopeAsString = "" + slope();

        if(slopeAsString.contains(".")) {
            slopeFraction = "" + (y2 - y1) + "/" + (x2 - x1);
        }
        if (slope() < 0) {
            slopeFraction = "-" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        }
        if ((y2 - y1) < 0 && (x2 - x1) < 0) {
            slopeFraction = "" + Math.abs(y2 - y1) + "/" + Math.abs(x2 - x1);
        }
        if (Math.abs(x2 - x1) == 1) {
            slopeFraction = "" + (y2 - y1);
        }
        if (slopeAsString.substring((slopeAsString.indexOf(".") + 1)).equals("0")) {
            slopeFraction = "" + (int) slope();
        }
        if (slope() == 1) {
            slopeFraction = "";
        }
        if (slope() == -1) {
            slopeFraction = "-";
        }

        double yInter = yIntercept();
        if (yIntercept() < 0 || yIntercept() == 0) {
            if (yIntercept() == 0.0) {
                return "y = " + slopeFraction + "x";
            }
            yInter = Math.abs(yIntercept());
            return "y = " + slopeFraction + "x - " + yInter;
        }

        return "y = " + slopeFraction + "x + " + yIntercept();
    }

    // Returns a String of the coordinate point on the line that has the given x value
    public String coordinateForX(double xValue) {
        double yValue = roundedToHundredth((slope() * xValue) + yIntercept());
        return "(" + xValue + ", " + yValue + ")";
    }

    // returns the value toRound rounded to the nearest hundredth, used variously throughout the code
    public double roundedToHundredth(double toRound) {
        return Math.round((toRound * 100.0)) / 100.0;
    }

    // Returns a string that includes all information about the linear equation
    public String lineInfo() {
        String str = "The two points are: " + "(" + x1 + ", " + y1 + ") and " + "(" + x2 + ", " + y2 + ")\n";
        str += "The equation of the line between these two points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yIntercept();
        str += "\nThe distance between the two points is: " + distance();
        return str;
    }
}