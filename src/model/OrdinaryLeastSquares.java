package model;

import java.util.ArrayList;

public class OrdinaryLeastSquares {
    private int num_of_formula;
    private double x;
    private double step_of_x;
    //count of steps
    private int n;
    private ArrayList<Double> xi;
    private ArrayList<Double> yi;
    private ArrayList<Double> xiyi;
    private ArrayList<Double> xiPow2;
    private ArrayList<Double> xiPow3;
    private ArrayList<Double> xiPow4;
    private ArrayList<Double> xiPow2ToYi;

    public OrdinaryLeastSquares(int num_of_formula, double x, double step_of_x) {
        this.num_of_formula = num_of_formula;
        this.x = x;
        this.step_of_x = step_of_x;
        n = 8;
        xi = new ArrayList<Double>();
        yi = new ArrayList<Double>();
        xiyi = new ArrayList<Double>();
        xiPow2 = new ArrayList<Double>();
        xiPow3 = new ArrayList<Double>();
        xiPow4 = new ArrayList<Double>();
        xiPow2ToYi = new ArrayList<Double>();
        generateXi();
        generateYi();
        generateXiPow2();
        generateXiPow3();
        generateXiPow4();
        generateXiPow2ToYi();
        generateXiYi();
        //TODO: generating results, deleting the worst and recalculation
        /*result = getResultOfIntegration(1);
        result_2 = getResultOfIntegration(2);*/
        //isCorrect = OrdinaryLeastSquares(result, result_2);
    }

    private void generateXiYi () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = xi.get(i)*yi.get(i);
            xiyi.add(next);
            sum += next;
        }
        xiyi.add(sum);
    }
    private void generateXiPow2ToYi () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = xiPow2.get(i)*yi.get(i);
            xiPow2ToYi.add(next);
            sum += next;
        }
        xiPow2ToYi.add(sum);
    }
    private void generateXiPow4 () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = Math.pow(xi.get(i), 4);
            xiPow4.add(next);
            sum += next;
        }
        xiPow4.add(sum);
    }
    private void generateXiPow3 () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = Math.pow(xi.get(i), 3);
            xiPow3.add(next);
            sum += next;
        }
        xiPow3.add(sum);
    }
    private void generateXiPow2 () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = Math.pow(xi.get(i), 2);
            xiPow2.add(next);
            sum += next;
        }
        xiPow2.add(sum);
    }
    private void generateYi () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = formula(num_of_formula, xi.get(i));
            yi.add(next);
            sum += next;
        }
        yi.add(sum);
    }
    private void generateXi () {
        double next, sum = 0;
        for (int i = 0; i < n; i++) {
            next = x + i*step_of_x;
            xi.add(next);
            sum += next;
        }
        xi.add(sum);
    }

    private double formula(int num, double x) {
        switch(num) {
            case 1:
                return (Math.cos(x)/(Math.pow(x, 2) + 1));
            case 2:
                return (Math.sqrt(1+2*Math.pow(x,2)-Math.pow(x,3)));
            case 3:
                return (1/Math.sqrt(3+Math.pow(x, 5)));
            case 4:
                return (Math.sqrt(Math.pow(x, 2)+3));
            default:
                return (Math.cos(x)/(Math.pow(x, 2) + 1));
        }

    }
}
