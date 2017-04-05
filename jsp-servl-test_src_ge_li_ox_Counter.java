package ge.li.ox;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by m.shilov on 03.04.2017.
 */
public class Counter extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //parsing string to double
        double obs = Double.parseDouble(request.getParameter("obs"));
        double electric = Double.parseDouble(request.getParameter("electric"));
        double electricFinal = electricCount(electric);
        double hotWater = Double.parseDouble(request.getParameter("hotwat"));
        double hotWaterFinal = hotWaterCount(hotWater);
        double coldWater = Double.parseDouble(request.getParameter("coldwat"));
        double coldWaterFinal = coldWaterCount(coldWater);
        double gas = Double.parseDouble(request.getParameter("gas"));
        double gasFinal = gasCount(gas);
        double inettv = Double.parseDouble(request.getParameter("inettv"));
        double allServices = obs + electricFinal + hotWaterFinal + coldWaterFinal + gasFinal + inettv;


        //screen output
        response.getWriter().println(String.format("Expenses 4 utility payments amounted to:"));

        response.getWriter().println(String.format("Near house service: " + obs + " uah"));
        String formattedDoubleEF = String.format("%.2f", +electricFinal);
        response.getWriter().println(String.format("Electric: " + formattedDoubleEF + " uah"));
        String formattedDoubleHW = String.format("%.2f", +hotWaterFinal);
        response.getWriter().println(String.format("Hot water: " + formattedDoubleHW + " uah"));
        String formattedDoubleCW = String.format("%.2f", +coldWaterFinal);
        response.getWriter().println(String.format("Cold water: " + formattedDoubleCW + " uah"));
        String formattedDoubleG = String.format("%.2f", +gasFinal);
        response.getWriter().println(String.format("Gas: " + formattedDoubleG + " uah"));
        response.getWriter().println(String.format("Internet and tv: " + inettv + " uah"));
        String formattedDoubleAll = String.format("%.2f", +allServices);
        response.getWriter().println(String.format("All services: " + formattedDoubleAll + " uah"));
    }

    //electric counter method
    public static double electricCount(double electric) {
        double electricFinal = 0;
        if (electric <= 100 && electric >= 0) {
            electricFinal = electric * 0.9;
        }
        if (electric > 100) {
            electricFinal = 90 + (electric - 100) * 1.68;
        }
        return electricFinal;
    }

    //hot water counter method
    public static double hotWaterCount(double hotWater) {
        double hotWaterFinal = hotWater * 76.71 + hotWater * 6.93;
        return hotWaterFinal;
    }

    //cold water counter method
    public static double coldWaterCount(double coldWater) {
        double coldWaterFinal = coldWater * 6.84;
        return coldWaterFinal;
    }

    //gas counter
    public static double gasCount(double gas) {
        double gasFinal = gas * 6.88;
        return gasFinal;
    }

}
